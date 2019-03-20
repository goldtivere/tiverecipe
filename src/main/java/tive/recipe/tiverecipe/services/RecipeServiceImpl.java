package tive.recipe.tiverecipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tive.recipe.tiverecipe.domain.Recipe;
import tive.recipe.tiverecipe.respositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("I'm in the service");
        Set<Recipe> recipeSet= new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
