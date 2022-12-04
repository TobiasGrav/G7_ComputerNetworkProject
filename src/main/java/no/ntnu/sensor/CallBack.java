package no.ntnu.sensor;

import java.time.LocalDateTime;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallBack implements MqttCallback {

    private MqttMessage mqttMessage = new MqttMessage("No message received.".getBytes());

    private SensorService sensorService;

    public CallBack(SensorService sensorService){
        this.sensorService = sensorService;
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received: "+ new String(mqttMessage.getPayload()) );
        this.mqttMessage = mqttMessage;
        System.out.println(sensorService);
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

        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, min, sec);
        int amountPeople = parseFromString(array[2].trim());

        sensorService.addNewSensor(new SensorData(0L, localDateTime, amountPeople));
    }

    /**
     *
     * @param number
     * @return
     */
    public int parseFromString(String number){
        return Integer.parseInt(number);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    public MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }
}