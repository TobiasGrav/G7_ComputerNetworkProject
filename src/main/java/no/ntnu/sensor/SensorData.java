package no.ntnu.sensor;

import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents a resource: a sensor.
 */
@Entity
public class SensorData {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    private LocalDate date;
    private LocalTime time;
    private int totalPeople;

    /** Empty constructor */
    public SensorData() {
    }

    /**
     * Constructor with parameters.
     *
     * @param id Long
     */
    public SensorData(Long id, LocalDate date, LocalTime time, int totalPeople) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.totalPeople = totalPeople;

    }

    /** Returns id */
    public Long getId() {
        return id;
    }

    /** Sets id */
    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    /** Returns dateAndTime */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /** Sets datAndTime */
    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

=======
>>>>>>> a46b241afbfd776687e54f714041efde8d1fb5b1
    /** Returns totalPeople */
    public int getTotalPeople() {
        return totalPeople;
    }

    /** Sets totalPeople */
    public void setTotalPeople(int totalPeople) {
        totalPeople ++;
        this.totalPeople = totalPeople;
    }

    /**
     * Transforms sensorData to a String and returns it.
     *
     * <b>String format: yyyy-mm-dd<hh:mm:ss<totalPeople.</b>
     *
     * @return String containing sensorData.
     */
    public String getSensorDataAsString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date);
        stringBuilder.append("<");
        stringBuilder.append(time);
        stringBuilder.append("<");
        stringBuilder.append(totalPeople);
        return stringBuilder.toString();
    }
}
