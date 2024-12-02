package org.study.design.patterns.behavioral.command.concrete;

import org.study.design.patterns.behavioral.command.receiver.Food;
import org.study.design.patterns.behavioral.command.Command;

//concrete command
public class ShowFoodIngredientsCommand implements Command {
    private final Food FOOD;

    public ShowFoodIngredientsCommand(Food food) {
        this.FOOD = food;
    }

    @Override
    public void execute() {
        FOOD.showItens();
    }
}
