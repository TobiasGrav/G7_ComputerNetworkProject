package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Main {

    static final String MQTT_SERVER_IP = "129.241.152.12";
    static final String MQTT_SERVER_PORT = "1883";

    public static void main(String[] args) throws MqttException {
        //Subscriber subscriber = new Subscriber(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        Publisher publisher = new Publisher(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        publisher.publishMessage("hei");
        publisher.disconnect();
        SpringApplication.run(Main.class, args);
    }

}
