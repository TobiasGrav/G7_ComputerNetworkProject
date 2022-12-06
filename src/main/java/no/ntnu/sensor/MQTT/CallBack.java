package no.ntnu.sensor.MQTT;

import java.time.LocalDate;
import java.time.LocalTime;

import no.ntnu.sensor.sensorData.SensorData;
import no.ntnu.sensor.sensorData.SensorDataService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Responsible for receiving, formatting and adding messages to a database.
 */
public class CallBack implements MqttCallback {

    private MqttMessage mqttMessage = new MqttMessage("No message received.".getBytes());

    private SensorDataService sensorDataService;

    /**
     * Creates instance of CallBack
     *
     * @param sensorDataService given sensorDataService
     */
    public CallBack(SensorDataService sensorDataService){
        this.sensorDataService = sensorDataService;
    }

    /**
     * Displays connection lost in terminal if exception is thrown
     *
     * @param throwable the thrown exception
     */
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    /**
     * Formatting mqtt message, and sends it to the database
     *
     * @param s string
     * @param mqttMessage message to be formatted
     */
    public void messageArrived(String s, MqttMessage mqttMessage) {
        System.out.println("Message received: "+ new String(mqttMessage.getPayload()) );
        this.mqttMessage = mqttMessage;
        System.out.println(sensorDataService);
        String message = mqttMessage.toString();
        String[] array = message.split("<");
        String[] dateArray = array[0].trim().split("-");
        String[] timeArray = array[1].trim().split(":");
        int year = parseFromString(dateArray[0]);
        int month = parseFromString(dateArray[1]);
        int day = parseFromString(dateArray[2]);

        int hour = parseFromString(timeArray[0]);
        int min = parseFromString(timeArray[1]);
        float secondsAsFloat = Float.parseFloat(timeArray[2]);
        int sec = Math.round(secondsAsFloat);
        LocalDate localdate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.of(hour, min, sec);
        int amountPeople = parseFromString(array[2].trim());

        sensorDataService.addNewSensorData(new SensorData(0L, localdate, localTime, amountPeople));
    }

    /**
     * Parses string number to int value and returns it.
     *
     * @param number string number to be parsed to int
     * @return parsed int
     */
    public int parseFromString(String number){
        return Integer.parseInt(number);
    }


    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    /**
     * Fetches the MQTT-message and returns it.
     *
     * @return MQTT-message
     */
    public MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }
}