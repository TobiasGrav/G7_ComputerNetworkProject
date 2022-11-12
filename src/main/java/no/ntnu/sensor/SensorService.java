package no.ntnu.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    /**
     * Makes iterable to list of products
     * @param iterable Iterable<Product>
     * @return list of products
     */
    public List<Sensor> iterableToList(Iterable<Sensor> iterable) {
        List<Sensor> list = new LinkedList<>();
        iterable.forEach(list::add);
        return list;
    }

    public Sensor findSensorById(int id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.orElse(null);
    }

    public List<Sensor> getAll() {
        return iterableToList(sensorRepository.findAll());
    }

    public boolean addNewSensor(Sensor sensor) {
        boolean added = false;
        if (sensor != null) {
            sensorRepository.save(sensor);
            added = true;
            }
        return added;
    }

    public boolean deleteSensor(Sensor sensor) {
        boolean deleted = false;
        if (sensor != null) {
            sensorRepository.delete(sensor);
            deleted = true;
        }
        return deleted;
    }

    public String updateSensor(int id, Sensor sensor) {
        Sensor existingSensor = findSensorById(id);
        String errorMessage = null;
        if (existingSensor == null) {
            errorMessage = "No sensor with " + id + "found";
        }
        if (sensor == null) {
            errorMessage = "Wrong data in request body";
        } else if (sensor.getId() != id) {
            errorMessage = "Wrong id, does not match";
        }

        if (errorMessage == null) {
            sensorRepository.save(sensor);
        }
        return errorMessage;
    }


}
