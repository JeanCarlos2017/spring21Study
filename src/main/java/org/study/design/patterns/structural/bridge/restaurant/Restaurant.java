package org.study.design.patterns.structural.bridge.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.study.design.patterns.structural.bridge.pizza.Pizza;

/*
    abstraction class
 */

@Getter @Setter @Slf4j
public abstract  class Restaurant {
    private String name;
    private Pizza pizza;

    public Restaurant(String name, Pizza pizza) {
        this.name = name;
        this.pizza = pizza;
    }

    public void message(){
        log.info("Restaurant {} is ready!", name);
    }
}
