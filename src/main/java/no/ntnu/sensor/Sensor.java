package no.ntnu.sensor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Represents a resource: a sensor.
 */
@Entity
public class Sensor {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime dateAndTime;
    // TODO check if person goes out or inside the building
    private int totalPeople;

    /**
     * Empty constructor
     */
    public Sensor() {
    }

    /**
     * Constructor with parameters
     * @param id Long
     */
    public Sensor(Long id, LocalDateTime dateAndTime, int totalPeople) {
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

    //TODO
    public void setTotalPeople(int totalPeople) {
        totalPeople ++;
        this.totalPeople = totalPeople;
    }
}
