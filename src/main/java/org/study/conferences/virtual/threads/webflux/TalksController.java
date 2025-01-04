package org.study.conferences.virtual.threads.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.conferences.virtual.threads.Talk;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class TalksController {
    private final FakeHttpServiceWebFlux fakeHttpService;

    public TalksController(FakeHttpServiceWebFlux fakeHttpService) {
        this.fakeHttpService = fakeHttpService;
    }

    @GetMapping("/webflux/talks-async")
    Mono<List<Talk>> getTalksAsync() {
        log.info("getWebFluxTalksAsync");
        return fakeHttpService.retrieveSpeakersAsync()
                .flatMapMany(Flux::fromIterable)
                .flatMap(fakeHttpService::retrieveTalkAsync)
                .collectList();
    }
}
