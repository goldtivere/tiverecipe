package tive.recipe.tiverecipe.repositories;


import org.springframework.data.repository.CrudRepository;
import tive.recipe.tiverecipe.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
