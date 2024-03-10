package org.study.design.patterns.creational;

import java.util.Objects;

public class MySingleton {
    //começa com null para fazer uso da técnica Lazy Loading
    private static volatile MySingleton instance = null;
    private MySingleton(){
        //para evitar o uso de reflection
        if (Objects.nonNull(instance)) {
            throw new RuntimeException("Use getInstance() method do create");
        }
    }

    public static MySingleton getInstance() {
        if (Objects.isNull(instance)) {
            //faz uso do syncronized para evitar que threads concorrentes não crie instâncias diferentes
            synchronized (MySingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }
}
