package at.lukas.volgger.todorestapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>("Hello " + name + "!", HttpStatus.OK) ;
    }

}
