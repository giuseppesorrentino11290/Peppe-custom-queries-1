package co.develhope.customqueries1.entities;

import co.develhope.customqueries1.entities.FlightStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Descrizione")
    private String description;

    @Column(name = "Arriva_da")
    private String from_Airoport;

    @Column(name = "Diretto")
    private String toAiroport;

    @Column(name = "Stato")
    @Enumerated(EnumType.STRING)
    private FlightStatus status;


    public Flight() {
    }

    public Flight(Long id, String description, String from_Airoport, String toAiroport, FlightStatus status) {
        this.id = id;
        this.description = description;
        this.from_Airoport = from_Airoport;
        this.toAiroport = toAiroport;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom_Airoport() {
        return from_Airoport;
    }

    public void setFrom_Airoport(String from_Airoport) {
        this.from_Airoport = from_Airoport;
    }

    public String getToAiroport() {
        return toAiroport;
    }

    public void setToAiroport(String toAiroport) {
        this.toAiroport = toAiroport;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }


}