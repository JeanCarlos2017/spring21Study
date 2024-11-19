package org.study.design.patterns.structural.bridge.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.study.design.patterns.structural.bridge.pizza.Pizza;

@Slf4j
public class AmericanRestaurant extends Restaurant {
    public AmericanRestaurant(String name, Pizza pizza) {
        super(name, pizza);
    }

    @Override
    public void message(){
        log.info("American Restaurant {} is ready!", this.getName());
    }
}
