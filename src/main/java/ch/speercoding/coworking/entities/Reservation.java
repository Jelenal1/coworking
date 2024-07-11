package ch.speercoding.coworking.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User booker;
    private boolean stornated;

    public Reservation(LocalDateTime startTime, LocalDateTime endTime, User booker, boolean stornated) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.booker = booker;
        this.stornated = stornated;
    }

}
