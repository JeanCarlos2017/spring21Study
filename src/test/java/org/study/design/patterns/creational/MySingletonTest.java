package org.study.design.patterns.creational;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySingletonTest {
    @Test
    void whenICallTheGetInstanceMethodItReturnsTheSameObject(){
        MySingleton mySingletonOne= MySingleton.getInstance();
        MySingleton mySingletonTwo= MySingleton.getInstance();

        assertTrue(mySingletonOne.equals(mySingletonTwo));
    }

    @Test
    public void testGetInstanceThreadSafety() throws InterruptedException {
        // Cria um pool de threads com 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Executa 1000 vezes a criação de instâncias do singleton em threads concorrentes
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                MySingleton singleton = MySingleton.getInstance();
                // Verifica se a instância é a mesma em todas as threads
                assertEquals(singleton, MySingleton.getInstance());
            });
        }

        // Aguarda a conclusão de todas as threads
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
    }
}
