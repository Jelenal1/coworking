package ch.speercoding.coworking.repositories;

import ch.speercoding.coworking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reservations")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
