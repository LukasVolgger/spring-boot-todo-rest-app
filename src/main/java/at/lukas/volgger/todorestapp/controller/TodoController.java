package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @GetMapping("/todo")
    public ResponseEntity<Todo> getTodo(@RequestParam(value = "id") Integer id) {
        Todo todo = new Todo(id, "Test tile", "Test description", false);

        return new ResponseEntity<>(todo, HttpStatus.OK) ;
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

}
