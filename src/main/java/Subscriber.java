import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

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

    public void close() throws MqttException {
        mqttClient.disconnect();
        mqttClient.close();
        System.out.println("--- Connection Disconnected ---");
    }

    public MqttMessage getMqttMessage() {
        return callBack.getMqttMessage();
    }
}
