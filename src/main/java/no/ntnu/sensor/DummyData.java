package no.ntnu.sensor;

import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Component
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
        List<Sensor> sensors = new ArrayList();
        int hours = 20;
        Random random = new Random();
        for(long i = 1; i <= hours; i++){
            Sensor sensor1 = new Sensor(i, LocalDateTime.now().minusHours(hours - i), random.nextInt(5, 16));
            sensors.add(sensor1);
        }


        sensorRepository.saveAll(sensors);
    }
}
