package at.lukas.volgger.todorestapp.controller;

import at.lukas.volgger.todorestapp.models.User;
import at.lukas.volgger.todorestapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody User newUser) {

        newUser.setApiKey(UUID.randomUUID().toString());
        User savedUser = userRepository.save(newUser);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity getUser(@RequestParam(name = "id") int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with id " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/validate")
    public ResponseEntity<String> validate(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        Optional<User> validUser = userRepository.findByEmailAndPassword(email, password);

        if (validUser.isPresent()) {
            return new ResponseEntity<>("API Key: " + validUser.get().getApiKey(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong credentials / NO user found!", HttpStatus.NOT_FOUND);
        }
    }

}
