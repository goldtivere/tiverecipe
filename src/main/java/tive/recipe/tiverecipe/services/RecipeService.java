package tive.recipe.tiverecipe.services;



import tive.recipe.tiverecipe.commands.RecipeCommand;
import tive.recipe.tiverecipe.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
