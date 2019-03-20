package tive.recipe.tiverecipe.services;

import tive.recipe.tiverecipe.domain.Ingredient;
import tive.recipe.tiverecipe.domain.Recipe;

import java.util.Set;

public interface IngredientService {

    Set<Ingredient> getIngredientByRecipe(Recipe recipe);
}
