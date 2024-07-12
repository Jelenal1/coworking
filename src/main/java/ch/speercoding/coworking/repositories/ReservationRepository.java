package ch.speercoding.coworking.repositories;

import ch.speercoding.coworking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(path = "reservations")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Override
    @PreAuthorize("hasRole('ADMIN') or #entity.user.username == authentication.name")
    <S extends Reservation> S save(S entity);

    @Override
    @PreAuthorize("hasRole('ADMIN') or @reservationRepository.isUserOwner(#id, authentication.name)")
    void deleteById(Long id);

    @Override
    @PreAuthorize("hasRole('ADMIN') or #entity.user.username == authentication.name")
    void delete(Reservation entity);

    default boolean isUserOwner(Long id, String username) {
        return findById(id)
                .map(reservation -> reservation.getUser().getUsername().equals(username))
                .orElse(false);
    }


}
