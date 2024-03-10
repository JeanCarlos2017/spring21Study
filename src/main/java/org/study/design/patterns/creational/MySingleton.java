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
        // o uso de variáveis local aumenta a performance
        MySingleton result = instance;
        if (Objects.isNull(result)) {
            //faz uso do syncronized para evitar que threads concorrentes não crie instâncias diferentes
            synchronized (MySingleton.class) {
                if (Objects.isNull(result)) {
                    result = instance= new MySingleton();
                }
            }
        }
        return result;
    }
}
