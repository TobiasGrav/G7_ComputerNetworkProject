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

/**
 * Responsible for creating dummy data for the purpose of demonstrating that the application functions.
 */
@Component
public class DummyData implements ApplicationListener<ApplicationReadyEvent> {
    private SensorRepository sensorRepository;

    public DummyData(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    private final Logger logger = Logger.getLogger("DummyInit");

    /**
     * Add example data per 20 hours
     * @param event application ready event
     */
    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (sensorRepository.count() > 0) {
            logger.info("Data already exists");
            return;
        }
        logger.info("Importing test data...");
        List<SensorData> sensorData = new ArrayList();
        int hours = 20;
        Random random = new Random();
        for(long i = 1; i <= hours; i++){
            SensorData sensorData1 = new SensorData(i, LocalDateTime.now().minusHours(hours - i), random.nextInt(5, 16));
            sensorData.add(sensorData1);
        }
        sensorRepository.saveAll(sensorData);
    }
}
