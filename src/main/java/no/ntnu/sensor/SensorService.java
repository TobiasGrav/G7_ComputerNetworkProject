package no.ntnu.sensor;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    private SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository){
        this.sensorRepository = sensorRepository;
    }

    /**
     * Makes iterable to list of products
     * @param iterable Iterable<Product>
     * @return list of products
     */
    public List<SensorData> iterableToList(Iterable<SensorData> iterable) {
        List<SensorData> list = new LinkedList<>();
        iterable.forEach(list::add);
        return list;
    }

    /**
     * Find sensor data by ID
     * @param id id to be found
     * @return sensor data if found, or null if not
     */
    public SensorData findSensorById(int id) {
        Optional<SensorData> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);
    }

    /**
     * Get list of sensor data
     * @return list of sensor data
     */
    public List<SensorData> getAll() {
        return iterableToList(sensorRepository.findAll());
    }

    /**
     * Add new sensor data
     * @param sensorData sensor data to be added
     * @return true if added, false if not
     */
    public boolean addNewSensorData(SensorData sensorData) {
        boolean added = false;
        if (sensorData != null) {
            sensorRepository.save(sensorData);
            added = true;
        }
        return added;
    }

    /**
     * Delete sensor data
     * @param sensorData sensor data to be deleted
     * @return true if deleted, false if not
     */
    public boolean deleteSensor(SensorData sensorData) {
        boolean deleted = false;
        if (sensorData != null) {
            sensorRepository.delete(sensorData);
            deleted = true;
        }
        return deleted;
    }

    /**
     * Update sensor data.
     * @param id id that needs to be updated.
     * @param sensorData sensor data that is updating.
     * @return null if updated, error message if not.
     */
    public String updateSensor(int id, SensorData sensorData) {
        SensorData existingSensorData = findSensorById(id);
        String errorMessage = null;
        if (existingSensorData == null) {
            errorMessage = "No sensorData with " + id + "found";
        }
        if (sensorData == null) {
            errorMessage = "Wrong data in request body";
        } else if (sensorData.getId() != id) {
            errorMessage = "Wrong id, does not match";
        }

        if (errorMessage == null) {
            sensorRepository.save(sensorData);
        }
        return errorMessage;
    }


}