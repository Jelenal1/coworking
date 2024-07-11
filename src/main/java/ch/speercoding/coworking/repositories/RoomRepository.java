package ch.speercoding.coworking.repositories;

import ch.speercoding.coworking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "room")
public interface RoomRepository extends JpaRepository<Room, Long> {
}
