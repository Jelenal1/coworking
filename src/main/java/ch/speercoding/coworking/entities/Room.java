package ch.speercoding.coworking.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer maxcapacity;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @OneToMany
    private List<Reservation> reservations;

    public Room(Integer maxcapacity, String name, String location, List<Reservation> reservations) {
        this.maxcapacity = maxcapacity;
        this.name = name;
        this.location = location;
        this.reservations = reservations;
    }

}
