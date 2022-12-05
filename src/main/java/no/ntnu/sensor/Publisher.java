package no.ntnu.sensor;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Responsible for uploading data to server.
 *
 * <b> Uploads data as byte arrays utilizing the Mqtt interface.</b>
 */
public class Publisher {

    MqttClient mqttClient;

    /**
     * Responsible for creating a new instance of the Publisher class.
     *
     * @param ip IP address of server which is to receive the data.
     * @param port Port of the server which is to receive the data.
     * @throws MqttException
     */
    public Publisher(String ip, String port) throws MqttException {
        mqttClient = new MqttClient("tcp://" + ip + ":" + port, MqttClient.generateClientId());
        mqttClient.connect();
    }

    /**
     * Responsible for turning a formatted string in to a MqttMessage object.
     *
     * @param message String which is to be turned in to a MqttMessage object.
     *                String must be correctly formatted.
     * @return Provided data as string as a MqttMessage.
     */
    public MqttMessage createMessage(String message) {
        MqttMessage mqttMessage = new MqttMessage();
        byte[] byteArray = message.getBytes();
        mqttMessage.setPayload(byteArray);
        return mqttMessage;
    }

    /**
     * Responsible for uploading data to the server.
     * @param message message which is to be uploaded as String.
     * @throws MqttException
     */
    public void publishMessage(String message) throws MqttException {
        mqttClient.publish("G7/Test", createMessage(message));
    }

    /**
     * Closes connection to server.
     *
     * @throws MqttException
     */
    public void close() throws MqttException {
        mqttClient.disconnect();
        mqttClient.close();
        System.out.println("--- Connection Disconnected ---");
    }

}
