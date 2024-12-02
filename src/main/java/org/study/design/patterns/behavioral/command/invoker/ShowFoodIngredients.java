package org.study.design.patterns.behavioral.command.invoker;

import org.study.design.patterns.behavioral.command.concrete.ShowFoodIngredientsCommand;

public class ShowFoodIngredients {
    private final ShowFoodIngredientsCommand showFoodIngredientsCommand;

    public ShowFoodIngredients(ShowFoodIngredientsCommand showFoodIngredientsCommand) {
        this.showFoodIngredientsCommand = showFoodIngredientsCommand;
    }

    public void showFoodIngredients() {
        showFoodIngredientsCommand.execute();
    }
}
