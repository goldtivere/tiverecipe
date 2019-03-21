package tive.recipe.tiverecipe.repositories;


import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
