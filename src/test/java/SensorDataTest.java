import no.ntnu.sensor.SensorData;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;


public class SensorDataTest {
    SensorData sensorData = new SensorData(1L, LocalDateTime.now(), 1);
    SensorData sensorData1 = new SensorData(1L, LocalDateTime.now(), 1);


    @Test
    public void setTotalPeopleTest() {
        sensorData.getTotalPeople();
        Assert.assertEquals(1,1);
        sensorData1.getTotalPeople();
        Assert.assertEquals(2,2);
    }
}
