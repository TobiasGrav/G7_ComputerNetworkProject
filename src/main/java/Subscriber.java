import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Subscriber {

    private MqttClient mqttClient;
    private CallBack callBack;

    public Subscriber(String ip, String port) throws MqttException {
        mqttClient = new MqttClient("tcp://" + ip + ":" + port, MqttClient.generateClientId());
        callBack = new CallBack();
        mqttClient.setCallback(callBack);
        mqttClient.connect();
        System.out.println("--- Connection Established ---");
        mqttClient.subscribe("G7/Test");
        System.out.println("--- Subscribed To Topic ---");
    }

    public void disconnect() throws MqttException {
        mqttClient.disconnect();
        System.out.println("--- Connection Disconnected ---");
    }

    public MqttMessage getMqttMessage() {
        return callBack.getMqttMessage();
    }
}
