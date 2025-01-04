package org.study.conferences.virtual.threads;

import lombok.SneakyThrows;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.StructuredTaskScope;

public class CollectionTaskSope<T>  extends StructuredTaskScope<T> {
    private final Collection<T> queue= new ConcurrentLinkedQueue<T>();

    @Override
    protected void handleComplete(Subtask<? extends T> subtask){
        queue.add(subtask.get());
    }

    @SneakyThrows
    List<T> getResult(){
        this.join();

        return List.copyOf(queue);
    }
}
