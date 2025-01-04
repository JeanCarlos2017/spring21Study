package org.study.conferences.virtual.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.StructuredTaskScope;

@RestController
@Slf4j
public class MainController {
    private final FakeHttpService fakeHttpService;

    public MainController(FakeHttpService fakeHttpService) {
        this.fakeHttpService = fakeHttpService;
    }

    @GetMapping("/speakers")
    List<Speaker> getSpeakers(){
        log.info("getSpeakers");
        return fakeHttpService.retrieveSpeakers();
    }

    @GetMapping("/talks")
    List<Talk> getTalks(){
        log.info("getTalks");
        final var speakers = fakeHttpService.retrieveSpeakers();
        return speakers.stream()
                .map(fakeHttpService::retrieveTalk)
                .toList();
    }

    @GetMapping("/speakers-async")
    CompletableFuture<List<Speaker>> getSpeakersAsync(){
        log.info("getSpeakersAsync");
        return fakeHttpService.retrieveSpeakersAsync();
    }


    /*
       Illustrating with reactive programming code can be challenging:
       - Hard to write
       - Hard to understand
       - Hard to test
    */
    @GetMapping("/talks-async")
    CompletableFuture<List<Talk>> getTalksAsync(){
        log.info("getTalksAsync");
        final var speakersFuture = fakeHttpService.retrieveSpeakersAsync();
        return speakersFuture.thenApply(speakers -> {
            final List<CompletableFuture<Talk>> talksFuture = speakers.stream()
                    .map(fakeHttpService::retrieveTalkAsync)
                    .toList();
            return talksFuture.stream().map(CompletableFuture::join).toList();
        });
    }

    @SneakyThrows
    @GetMapping("/talks/java21")
    List<Talk> getTalksAsyncJava21(){
        log.info("getTalksJava21");
        final var speakers = fakeHttpService.retrieveSpeakers();
        try(var scope= new StructuredTaskScope<Talk>()){
            final List<StructuredTaskScope.Subtask<Talk>> talksTasks= speakers.stream()
                    .map(speaker ->
                            scope.fork(() -> fakeHttpService.retrieveTalk(speaker))
                    )
                    .toList();
            scope.join();
            return talksTasks.stream()
                    .map(StructuredTaskScope.Subtask::get)
                    .toList();
        }
    }

    @SneakyThrows
    @GetMapping("/talks/java21/v2")
    List<Talk> getTalksAsyncJava21v2(){
        log.info("getTalksJava21V2");
        final var speakers = fakeHttpService.retrieveSpeakers();
        try(var scope= new CollectionTaskSope<Talk>()){
            speakers.forEach(speaker ->
                            scope.fork(() -> fakeHttpService.retrieveTalk(speaker))
                    );
            return scope.getResult();
        }
    }


}
