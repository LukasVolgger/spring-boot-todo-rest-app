package at.lukas.volgger.todorestapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

}
