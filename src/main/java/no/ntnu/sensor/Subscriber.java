package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

/**
 * Responsible for establishes a connection to the server.
 */
@Component
public class Subscriber {

    private MqttClient mqttClient;
    private CallBack callBack;
    private SensorService sensorService;
    private static final String SERVER_URL = "tcp://" + "129.241.152.12" + ":" + "1883";

    /**
     * Creates a new instance of the Subscriber class.
     *
     * <b>Connection to server is established when creating the MqttClient</b>
     *
     * @param sensorService Object which stores the data which is to be uploaded.
     * @throws MqttException If client can not connect to server.
     */
    public Subscriber(SensorService sensorService) throws MqttException {
        this.sensorService = sensorService;
        mqttClient = new MqttClient(SERVER_URL, MqttClient.generateClientId());
        callBack = new CallBack(sensorService);
        mqttClient.setCallback(callBack);
        mqttClient.connect();
        System.out.println("--- Connection Established ---");
        mqttClient.subscribe("G7/Test");
        System.out.println("--- Subscribed To Topic ---");
    }

    /*
    public Subscriber(String ip, String port) throws MqttException {
        mqttClient = new MqttClient("tcp://" + ip + ":" + port, MqttClient.generateClientId());
        callBack = new CallBack();
        mqttClient.setCallback(callBack);
        mqttClient.connect();
        System.out.println("--- Connection Established ---");
        mqttClient.subscribe("G7/Test");
        System.out.println("--- Subscribed To Topic ---");
    }*/

    /**
     * Closes connection to server.
     *
     * @throws MqttException If the client is already disconnected.
     */
    public void close() throws MqttException {
        mqttClient.disconnect();
        mqttClient.close();
        System.out.println("--- Connection Disconnected ---");
    }



    /**
     * Returns the message which is to be transmitted.
     *
     * @return message which is to be transmitted.
     */
    public MqttMessage getMqttMessage() {
        return callBack.getMqttMessage();
    }
}
