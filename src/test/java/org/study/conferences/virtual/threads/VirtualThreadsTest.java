package org.study.conferences.virtual.threads;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

class VirtualThreadsTest {

    @Test
    void test() throws InterruptedException {
        List<Thread> threadList = IntStream.range(0, 1_000)
                .mapToObj(i -> Thread.ofPlatform().unstarted(() -> {
                    try {
                        sleep(20_000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })).toList();

        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
    }



}