package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

    MqttClient mqttClient;

    public Publisher(String ip, String port) throws MqttException {
        mqttClient = new MqttClient("tcp://" + ip + ":" + port, MqttClient.generateClientId());
        mqttClient.connect();
    }

    public MqttMessage createMessage(String message) {
        MqttMessage mqttMessage = new MqttMessage();
        byte[] byteArray = message.getBytes();
        mqttMessage.setPayload(byteArray);
        return mqttMessage;
    }

    public void publishMessage(String message) throws MqttException {
        mqttClient.publish("G7/Test", createMessage(message));
    }

    public void close() throws MqttException {
        mqttClient.disconnect();
        mqttClient.close();
        System.out.println("--- Connection Disconnected ---");
    }

}
