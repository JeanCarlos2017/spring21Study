package org.study.design.patterns.structural.bridge.restaurant;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.structural.bridge.pizza.PepperoniPizza;
import org.study.design.patterns.structural.bridge.pizza.Pizza;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
   os exemplos foram inspirados no vídeo https://www.youtube.com/watch?v=88kAIisOiYs
 */

class AmericanRestaurantTest {

    @Test
    void message() {
        Pizza pizza = new PepperoniPizza(BigDecimal.TEN, new ArrayList<>());
        pizza.cookPizza();
        Restaurant americanRestaurant = new AmericanRestaurant("americanRestaurant", pizza);
        americanRestaurant.message();
        assertEquals(americanRestaurant.getName(), "americanRestaurant");
    }
}