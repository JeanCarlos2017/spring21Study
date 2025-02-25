package org.study.conferences.virtual.threads;

import org.junit.jupiter.api.Test;
import org.study.conferences.virtual.threads.webflux.FakeHttpServiceWebFlux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;


class FakeHttpServiceWebFluxTest {

    private final FakeHttpServiceWebFlux service = new FakeHttpServiceWebFlux();

    @Test
    void retrieveSpeakersAsync() {
        Mono<List<Speaker>> speakersMono = service.retrieveSpeakersAsync();

        StepVerifier.create(speakersMono)
                .expectNextMatches(speakers -> speakers.size() == 10 && speakers.get(0).name().equals("Speaker 0"))
                .verifyComplete();
    }

    @Test
    void testRetrieveTalkAsync() {
        Speaker speaker = new Speaker("Test Speaker");
        StepVerifier.create(service.retrieveTalkAsync(speaker))
                .expectNextMatches(talk -> talk.speaker().equals(speaker))
                .verifyComplete();
    }
}