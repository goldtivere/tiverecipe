package tive.recipe.tiverecipe.services;

import tive.recipe.tiverecipe.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndId(Long recipeId,Long ingredientId);
}
