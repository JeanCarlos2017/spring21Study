package org.study.conferences.virtual.threads;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.CompletableFuture.delayedExecutor;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
public class FakeHttpService {
    private final List<Speaker> speakerList= IntStream.range(0, 10)
            .mapToObj(i -> new Speaker("Speaker "+i))
            .toList();

    @SneakyThrows
    public List<Speaker> retrieveSpeakers() {
        Thread.sleep(1_000);
        return speakerList;
    }

    public CompletableFuture<List<Speaker>> retrieveSpeakersAsync() {
        return supplyAsync(() -> speakerList, delayedExecutor(1_000, TimeUnit.MILLISECONDS));
    }

    @SneakyThrows
    public Talk retrieveTalk(Speaker speaker) {
        Thread.sleep(500);
        return new Talk(speaker);
    }

    public CompletableFuture<Talk> retrieveTalkAsync(Speaker speaker) {
        return supplyAsync(() -> new Talk(speaker), delayedExecutor(500, TimeUnit.MILLISECONDS));
    }
}
