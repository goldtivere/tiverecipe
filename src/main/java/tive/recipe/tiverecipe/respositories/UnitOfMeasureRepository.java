package tive.recipe.tiverecipe.respositories;

import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByUom(String description);
}
