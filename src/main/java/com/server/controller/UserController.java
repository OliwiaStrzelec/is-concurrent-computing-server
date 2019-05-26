package com.server.controller;

import com.server.exception.ResourceNotFoundException;
import com.server.model.User;
import com.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username)
            throws ResourceNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this username :: " + username));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User newUser) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> getResourceNotFoundException(userId));
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        return ResponseEntity.ok(repository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> getResourceNotFoundException(userId));
        repository.delete(user);
        return ResponseEntity.ok().build();
    }

    private ResourceNotFoundException getResourceNotFoundException(@PathVariable("id") Long userId) {
        return new ResourceNotFoundException("User not found for this id :: " + userId);
    }
}