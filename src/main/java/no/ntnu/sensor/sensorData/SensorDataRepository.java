package no.ntnu.sensor.sensorData;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository where CRUD operations happen
 */
@Repository
public interface SensorDataRepository extends CrudRepository<SensorData, Integer> {
}
