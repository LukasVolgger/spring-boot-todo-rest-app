package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import at.lukas.volgger.todorestapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo(@RequestParam(value = "id") Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (todoOptional.isPresent()) {
            return new ResponseEntity<>(todoOptional.get(), HttpStatus.OK) ;
        } else {
            return new ResponseEntity("Todo with id " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoRepository.save(newTodo);

        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

}
