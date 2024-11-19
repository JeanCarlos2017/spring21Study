package org.study.design.patterns.structural.bridge.pizza;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class PepperoniPizza extends Pizza{

    public PepperoniPizza(BigDecimal price, List<String> ingredients) {
        super(price, ingredients);
        ingredients.add("pepperoni");
    }

    @Override
    public void cookPizza(){
        log.info("Pizza pepperoni cooked");
    }
}
