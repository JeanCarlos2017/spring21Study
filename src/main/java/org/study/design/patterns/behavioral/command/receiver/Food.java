package org.study.design.patterns.behavioral.command.receiver;

import java.util.List;

//receiver
public class Food {
    private final List<String> INGREDIENTS;

    public Food(List<String> ingredients) {
        this.INGREDIENTS = ingredients;
    }

    public void showItens(){
        INGREDIENTS.forEach(System.out::println);
    }
}
