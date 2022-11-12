package no.ntnu.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    SensorService sensorService;

    @GetMapping
    public List<Sensor> getAll() {
        return sensorService.getAll();
    }

    /**
     * Get a specific author
     *
     * @param id ID of the author to be returned
     * @return Author with the given ID or status 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getOne(@PathVariable Integer id) {
        ResponseEntity<Sensor> response;
        Sensor sensor = sensorService.findSensorById(id);
        if (sensor != null) {
            response = new ResponseEntity<>(sensor, HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }


    @PostMapping
    public ResponseEntity<String> add(@RequestBody Sensor sensor) {
        ResponseEntity<String> response;
        if (sensorService.addNewSensor(sensor)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Sensor sensor) {
        ResponseEntity<String> response;
        if (sensorService.deleteSensor(sensor)) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
