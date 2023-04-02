package at.lukas.volgger.todorestapp.repositories;

import at.lukas.volgger.todorestapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByApiKey(String apiKey);
}
