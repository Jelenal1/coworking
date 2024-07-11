package ch.speercoding.coworking;

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
			User user1 = new User("jelenal1", "123", "Jelena", "Speer", "jelena.speer@posteo.de", "0774537200", "Katharina-Sulzer-Platz 12", Role.ADMIN);
			User user2 = new User("nono", "123", "Jelena", "Blabla", "blabla@posteo.de", "077860934", "Super toll nice 3", Role.MEMBER);
			userRepository.save(user1);
			userRepository.save(user2);
			Room room1 = new Room("Room 1", "Room 1", );


		};
	}
}
