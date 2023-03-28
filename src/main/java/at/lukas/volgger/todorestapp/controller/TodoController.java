package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import at.lukas.volgger.todorestapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo(@RequestParam(value = "id") Integer id) {
        Todo todo = new Todo(id, "Test tile", "Test description", false);

        return new ResponseEntity<>(todo, HttpStatus.OK) ;
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todoRepository.save(newTodo);

        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

}
