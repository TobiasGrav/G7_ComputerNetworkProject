package no.ntnu.sensor.sensorData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API Controller for sensor data
 */

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    SensorDataService sensorDataService;

    /**
     * Returns all available data.
     *
     * @return A List containing all SensorData.
     */
    @GetMapping
    public List<SensorData> getAll() {
        return sensorDataService.getAll();
    }

    /**
     * Get a specific author
     *
     * @param id ID of the author to be returned
     * @return Author with the given ID or status 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<SensorData> getOne(@PathVariable Integer id) {
        ResponseEntity<SensorData> response;
        SensorData sensorData = sensorDataService.findSensorById(id);
        if (sensorData != null) {
            response = new ResponseEntity<>(sensorData, HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * Adding sensorData data to database
     * @param sensorData SensorData
     * @return response OK if added, BAD REQUEST if not added
     */
    @PostMapping
    public ResponseEntity<String> add(@RequestBody SensorData sensorData) {
        ResponseEntity<String> response;
        if (sensorDataService.addNewSensorData(sensorData)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    /**
     * Deleting sensorData data from database
     * @param sensorData SensorData
     * @return response OK, if deleted and NOT FOUND if not found
     */
    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable SensorData sensorData) {
        ResponseEntity<String> response;
        if (sensorDataService.deleteSensor(sensorData)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
