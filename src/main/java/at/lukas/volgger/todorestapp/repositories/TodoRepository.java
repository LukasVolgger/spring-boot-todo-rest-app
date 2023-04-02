package at.lukas.volgger.todorestapp.repositories;

import at.lukas.volgger.todorestapp.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
    Set<Todo> findAllByUserId(int userId);
}
