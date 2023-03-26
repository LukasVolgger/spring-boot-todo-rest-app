package at.lukas.volgger.todorestapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello World!";
    }

}
