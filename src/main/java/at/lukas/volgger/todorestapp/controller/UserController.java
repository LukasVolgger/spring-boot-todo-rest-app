package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.Todo;
import at.lukas.volgger.todorestapp.models.User;
import at.lukas.volgger.todorestapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody User newUser) {
        User savedUser = userRepository.save(newUser);

        System.out.println(savedUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
