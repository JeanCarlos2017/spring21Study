package org.study.design.patterns.structural.composite;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.structural.composite.products.Book;
import org.study.design.patterns.structural.composite.products.VideoGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryServiceTest {

    @Test
    void calculateOrderPrice(){
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setupOrder(
                new CompositeBox(
                        new VideoGame("1", 100)
                ),
                new CompositeBox(
                        new CompositeBox(
                                new Book("2", 200),
                                new Book("3", 300)
                        ),
                        new VideoGame("4", 400),
                        new VideoGame("5", 500)
                )
        );

        assertEquals(1500, deliveryService.calculateOrderPrice());
    }

}