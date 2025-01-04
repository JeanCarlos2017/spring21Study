package org.study.conferences.virtual.threads.webflux;

import org.springframework.stereotype.Service;
import org.study.conferences.virtual.threads.Speaker;
import org.study.conferences.virtual.threads.Talk;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class FakeHttpServiceWebFlux {
    private final List<Speaker> speakerList = IntStream.range(0, 10)
            .mapToObj(i -> new Speaker("Speaker " + i))
            .toList();

    public Mono<List<Speaker>> retrieveSpeakersAsync() {
        return Mono.just(speakerList).delayElement(Duration.ofSeconds(1));
    }

    public Mono<Talk> retrieveTalkAsync(Speaker speaker) {
        return Mono.just(new Talk(speaker)).delayElement(Duration.ofMillis(500));
    }
}