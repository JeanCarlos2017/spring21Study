package org.study.conferences.virtual.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
                .map(speaker -> fakeHttpService.retrieveTalk(speaker))
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


}
