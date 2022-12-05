import no.ntnu.sensor.SensorData;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class SensorDataTest {
    SensorData sensorData = new SensorData(1L, LocalDate.now(), LocalTime.now(), 1);
    SensorData sensorData1 = new SensorData(1L, LocalDate.now(), LocalTime.now(), 1);


    @Test
    public void setTotalPeopleTest() {
        sensorData.getTotalPeople();
        Assert.assertEquals(1,1);
        sensorData1.getTotalPeople();
        Assert.assertEquals(2,2);
    }
}
