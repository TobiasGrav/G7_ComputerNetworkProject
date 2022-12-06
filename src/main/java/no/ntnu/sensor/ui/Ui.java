package no.ntnu.sensor.ui;

import no.ntnu.sensor.MQTT.Publisher;
import no.ntnu.sensor.Main;
import no.ntnu.sensor.sensorData.SensorData;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

import static no.ntnu.sensor.Main.*;

public class Ui {
    static final String MQTT_SERVER_IP = "129.241.152.12";
    static final String MQTT_SERVER_PORT = "1883";

    private static final int END = 1;
    private static final int SUBSCRIBE = 2;
    private static final int PUBLISH = 3;

    public Ui(){

    }

    public static int showMenu() {
        int menuChoice = 0;
        System.out.println("Press 1 to exit application." + "\n"
                + "Press 2 to subscribe to MQTT broker." + "\n"
                + "Press 3 to publish to MQTT broker."
        );
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("Please enter a number");
        }
        return menuChoice;
    }

    public int waitScreen() {
        int menuChoice = 0;
        System.out.println("Press 1 to exit");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("Please enter a number");
        }
        return menuChoice;
    }

    public static void start(String[] args) throws MqttException, InterruptedException {
        boolean finished = false;
        while(!finished) {
            int menuChoice = showMenu();

            switch (menuChoice) {
                case END -> finished = true;

                case SUBSCRIBE -> SpringApplication.run(Main.class, args);

                case PUBLISH -> StartApplication();

                default -> System.out.println("Please press a number between 1 and 3");
            }
        }
    }

    /**
     * Starts application.
     *
     * @throws MqttException If client can not connect to server.
     * @throws InterruptedException If sleep is interrupted.
     */
    public static void StartApplication() throws MqttException, InterruptedException {
        Publisher publisher = new Publisher(MQTT_SERVER_IP, MQTT_SERVER_PORT);
        for (SensorData data : makeSensorData()) {
            publisher.publishMessage(data.getSensorDataAsString());
            System.out.println(data.getSensorDataAsString());
            Thread.sleep(10000);
        }
    }
}
