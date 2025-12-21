package ba51602.lab10.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;
    
    @Temporal(TemporalType.DATE) 
    private Date date;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public WeatherData() {}

    public WeatherData(double temperature, Date date, Location location) {
        this.temperature = temperature;
        this.date = date;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}