package tive.recipe.tiverecipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tive.recipe.tiverecipe.commands.IngredientCommand;
import tive.recipe.tiverecipe.converters.IngredientToIngredientCommand;
import tive.recipe.tiverecipe.domain.Recipe;
import tive.recipe.tiverecipe.repositories.RecipeRepository;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional=recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent())
        {
            log.error("recipe id not found." +
                    " Id: "+recipeId);
        }

        Recipe recipe= recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional= recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if(!ingredientCommandOptional.isPresent())
        {
            log.error("Ingredient id not found." +
                    " Id: "+ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
