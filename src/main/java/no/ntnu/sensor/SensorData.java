package no.ntnu.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Represents a resource: a sensor.
 */
@Entity
public class SensorData {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime dateAndTime;
    private int totalPeople;

    /**
     * Empty constructor
     */
    public SensorData() {
    }

    /**
     * Constructor with parameters
     * @param id Long
     */
    public SensorData(Long id, LocalDateTime dateAndTime, int totalPeople) {
        this.id = id;
        this.dateAndTime = dateAndTime;
        this.totalPeople = totalPeople;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        totalPeople ++;
        this.totalPeople = totalPeople;
    }

    public String getSensorDataAsString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dateAndTime.toLocalDate());
        stringBuilder.append("<");
        stringBuilder.append(dateAndTime.toLocalTime());
        stringBuilder.append("<");
        stringBuilder.append(totalPeople);
        return stringBuilder.toString();
    }
}
