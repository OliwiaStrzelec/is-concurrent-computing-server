package com.controller;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping()
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> getResourceNotFoundException(userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping()
    public User createUser(@Valid @RequestBody User user) {
        return repository.save(user);
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
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> getResourceNotFoundException(userId));
        repository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private ResourceNotFoundException getResourceNotFoundException(@PathVariable("id") Long userId) {
        return new ResourceNotFoundException("User not found for this id :: " + userId);
    }
}