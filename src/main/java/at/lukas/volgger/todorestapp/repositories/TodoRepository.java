package at.lukas.volgger.todorestapp.repositories;

import at.lukas.volgger.todorestapp.models.Todo;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Id> {

}
