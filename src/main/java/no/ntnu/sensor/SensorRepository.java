package no.ntnu.sensor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository where CRUD operations happen
 */
@Repository
public interface SensorRepository extends CrudRepository<SensorData, Integer> {
}
