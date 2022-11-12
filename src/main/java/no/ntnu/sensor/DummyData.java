package no.ntnu.sensor;

import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;


public class DummyData implements ApplicationListener<ApplicationReadyEvent> {
    private SensorRepository sensorRepository;

    public DummyData(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    private final Logger logger = Logger.getLogger("DummyInit");

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (sensorRepository.count() > 0) {
            logger.info("Data already exists");
            return;
        }

        logger.info("Importing test data...");
        Sensor sensor1 = new Sensor(1L, LocalDateTime.now(), 1);
        Sensor sensor2 = new Sensor(2L, LocalDateTime.now(), 1);

        sensorRepository.saveAll(List.of(sensor1, sensor2));
    }
}
