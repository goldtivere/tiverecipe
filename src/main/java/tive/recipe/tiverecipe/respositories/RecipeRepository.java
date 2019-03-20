package tive.recipe.tiverecipe.respositories;

import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
