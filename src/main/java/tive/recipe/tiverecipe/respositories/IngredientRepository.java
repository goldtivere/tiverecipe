package tive.recipe.tiverecipe.respositories;

import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.Ingredient;
import tive.recipe.tiverecipe.domain.Recipe;

import java.util.Set;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

    Set<Ingredient> findByRecipe(Recipe l);

}
