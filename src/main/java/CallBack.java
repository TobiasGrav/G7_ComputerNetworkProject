import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallBack implements MqttCallback {

    private MqttMessage mqttMessage = new MqttMessage("No message received.".getBytes());

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received: "+ new String(mqttMessage.getPayload()) );
        this.mqttMessage = mqttMessage;
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    public MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }
}