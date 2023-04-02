package at.lukas.volgger.todorestapp.repositories;

import at.lukas.volgger.todorestapp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
