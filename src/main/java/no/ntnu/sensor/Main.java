package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableJpaRepositories
///Ikke bruk denne bare på konfigurasjons klasser
///@EnableWebMvc
public class Main {
    static final String MQTT_SERVER_IP = "129.241.152.12";
    static final String MQTT_SERVER_PORT = "1883";

    public static void main(String[] args) throws MqttException, InterruptedException {
        SpringApplication.run(Main.class, args);
        //Subscriber subscriber = new Subscriber(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        //Publisher publisher = new Publisher(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        //publisher.publishMessage("Hei");
        //publisher.disconnect();
    }

    public static void StartApplication() throws MqttException, InterruptedException {
        Publisher publisher = new Publisher(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        for (SensorData data : makeSensorData()) {
            publisher.publishMessage(data.getSensorDataAsString());
            System.out.println(data.getSensorDataAsString());
            Thread.sleep(10000);
        }
    }

    public static List<SensorData> makeSensorData() {
        List<SensorData> sensorData = new ArrayList();
        int hours = 30;
        Random random = new Random();
        for (long i = 1; i <= hours; i++) {
            SensorData sensorData1 = new SensorData(i, LocalDateTime.now().minusHours(hours - i), random.nextInt(5, 16));
            sensorData.add(sensorData1);
        }
        return sensorData;
    }
}
