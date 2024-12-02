package org.study.design.patterns.behavioral.command.invoker;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.behavioral.command.concrete.ShowFoodIngredientsCommand;
import org.study.design.patterns.behavioral.command.receiver.Food;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowFoodIngredientsTest {
    @Test
    void showFoodIngredients() {
        List<String> ingredients = List.of("rice", "beans", "meat");
        Food food= new Food(ingredients);
        ShowFoodIngredientsCommand showFoodIngredientsCommand = new ShowFoodIngredientsCommand(food);
        ShowFoodIngredients showFoodIngredients = new ShowFoodIngredients(showFoodIngredientsCommand);
        assertDoesNotThrow(showFoodIngredients::showFoodIngredients);


    }

}