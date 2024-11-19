package org.study.design.patterns.structural.bridge.pizza;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
    implementation class
 */
@Slf4j @Getter
public abstract  class Pizza {
    private final BigDecimal price;
    List<String> ingredients = new ArrayList<>();

    public Pizza(BigDecimal price, List<String> ingredients) {
        this.price = price;
        this.ingredients = ingredients;
    }

    public void cookPizza(){
        log.info("Pizza cooked");
    }
}
