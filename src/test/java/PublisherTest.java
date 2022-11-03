import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.Assert;
import org.junit.Test;

public class PublisherTest {

    private String ip = "129.241.152.12";
    private String port = "1883";

    public PublisherTest() throws MqttException {

    }

    @Test
    public void createMessageTest() throws MqttException {
        Publisher publisher = new Publisher(ip, port);
        String message = "Testing the message mqtt constructor";
        Assert.assertEquals(new String(publisher.createMessage(message).getPayload()), message);
    }

    public void publishTest() throws MqttException {
        Publisher publisher = new Publisher(ip, port);
        String message = "Test Message";
        publisher.publishMessage(message);
    }

}
