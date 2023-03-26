package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>("Hello " + name + "!", HttpStatus.OK) ;
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

}
