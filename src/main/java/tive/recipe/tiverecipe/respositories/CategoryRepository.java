package tive.recipe.tiverecipe.respositories;

import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
