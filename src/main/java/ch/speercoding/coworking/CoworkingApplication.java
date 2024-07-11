package ch.speercoding.coworking;

import ch.speercoding.coworking.entities.Reservation;
import ch.speercoding.coworking.entities.Role;
import ch.speercoding.coworking.entities.Room;
import ch.speercoding.coworking.entities.User;
import ch.speercoding.coworking.repositories.ReservationRepository;
import ch.speercoding.coworking.repositories.RoomRepository;
import ch.speercoding.coworking.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class CoworkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoworkingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
		return args -> {
			User user1 = new User(1L, "Jayl1", "$2y$10$h.vpFr0sEU422JQBOV3AluBLEIJviVGN4GMCblxla6iukO0qcrK3O" ,"info@coworking-space.ch", "Jay", "Burton", Role.ADMIN);
			userRepository.save(user1);
			Room room1 = new Room(1L, 20, "Grünerraum", "Bederstrasse 1, 8000 Zürich", new ArrayList<>());
			roomRepository.save(room1);
		};
	}
}
