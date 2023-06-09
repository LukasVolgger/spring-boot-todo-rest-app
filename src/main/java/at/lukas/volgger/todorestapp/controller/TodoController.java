package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import at.lukas.volgger.todorestapp.models.User;
import at.lukas.volgger.todorestapp.repositories.TodoRepository;
import at.lukas.volgger.todorestapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo(@RequestParam(value = "id") Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (todoOptional.isPresent()) {
            return new ResponseEntity<>(todoOptional.get(), HttpStatus.OK) ;
        } else {
            return new ResponseEntity("Todo with id " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("todo/all")
    public ResponseEntity getAllTodo(@RequestHeader(name = "api-key") String apiKey) {
        Optional<User> user = userRepository.findByApiKey(apiKey);

        if (user.isPresent()) {
            Iterable<Todo> allTodo = todoRepository.findAllByUserId(user.get().getId());

            return new ResponseEntity<>(allTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Entered wrong API-Key!", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoRepository.save(newTodo);

        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @DeleteMapping("/todo")
    public ResponseEntity deleteTodo(@RequestParam(name = "id") int id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            return new ResponseEntity<>("Todo with id " + id + " deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Todo with id " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/todo")
    public ResponseEntity updateTodo(@RequestBody Todo updatedTodo) {
        Optional<Todo> todo = todoRepository.findById(updatedTodo.getId());

        if (todo.isPresent()) {
            Todo savedTodo = todoRepository.save(updatedTodo);
            return new ResponseEntity<>(savedTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Todo with id " + updatedTodo.getId() + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/todo/setDone")
    public ResponseEntity setDone(@RequestParam(name = "id") int id,
                                    @RequestParam(name = "isDone") boolean isDone) {
        Optional<Todo> todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            todo.get().setDone(isDone);
            Todo savedTodo = todoRepository.save(todo.get());

            return new ResponseEntity<>(savedTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Todo with id " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

}
