package no.ntnu.sensor;

import no.ntnu.sensor.ui.Ui;
import no.ntnu.sensor.sensorData.SensorData;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableJpaRepositories
public class Main {

    /**
     * Runs the application
     * @param args command line args
     */
    public static void main(String[] args) throws MqttException, InterruptedException {
        Ui.start(args);
    }

    /**
     * Simulates a sensor making sensor data and returns the data.
     *
     * @return the made sensor data.
     */
    public static List<SensorData> makeSensorData() {
        List<SensorData> sensorData = new ArrayList();
        int hours = 30;
        Random random = new Random();
        for (long i = 1; i <= hours; i++) {
            SensorData sensorData1 = new SensorData(i, LocalDate.now(), LocalTime.now().minusHours(hours - i), random.nextInt(5, 16));
            sensorData.add(sensorData1);
        }
        return sensorData;
    }
}
