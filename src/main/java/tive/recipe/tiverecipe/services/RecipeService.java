package tive.recipe.tiverecipe.services;

import tive.recipe.tiverecipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
