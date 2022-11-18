package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
///Ikke bruk denne bare på konfigurasjons klasser
///@EnableWebMvc
public class Main {

    static final String MQTT_SERVER_IP = "129.241.152.12";
    static final String MQTT_SERVER_PORT = "1883";

    public static void main(String[] args) throws MqttException {
        //no.ntnu.sensor.Subscriber subscriber = new no.ntnu.sensor.Subscriber(MQTT_SERVER_IP, MQTT_SERVER_PORT);

        SpringApplication.run(Main.class, args);
    }

}
