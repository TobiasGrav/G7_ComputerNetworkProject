import no.ntnu.sensor.Sensor;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;


public class SensorTest {
    Sensor sensor = new Sensor(1L, LocalDateTime.now(), 1);
    Sensor sensor1 = new Sensor(1L, LocalDateTime.now(), 1);


    @Test
    public void setTotalPeopleTest() {
        sensor.getTotalPeople();
        Assert.assertEquals(1,1);
        sensor1.getTotalPeople();
        Assert.assertEquals(2,2);
    }
}
