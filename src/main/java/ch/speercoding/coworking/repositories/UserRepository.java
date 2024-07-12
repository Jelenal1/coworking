package ch.speercoding.coworking.repositories;

import ch.speercoding.coworking.entities.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Override
    @PreAuthorize("hasRole('ADMIN') or #entity.username == authentication.name")
    <S extends User> S save(S entity);

    @Override
    @PreAuthorize("hasRole('ADMIN') or @userRepository.findById(#id).orElse(new ch.speercoding.coworking.entities.User()).username == authentication.name")
    void deleteById(Long id);

    @Override
    @PreAuthorize("hasRole('ADMIN') or #entity.username == authentication.name")
    void delete(User entity);

}
