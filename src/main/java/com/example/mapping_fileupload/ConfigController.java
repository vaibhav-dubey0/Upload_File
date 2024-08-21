package com.example.mapping_fileupload;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

@RestController
public class ConfigController {
    @Autowired
    private Service service;

    @GetMapping("/user")
    public ResponseEntity<List<Clint>> getAllUsers() {
        List<Clint> list = service.getAllUsers();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Clint> getUserById(@PathVariable("id") int id) {
        try {
            Clint u = service.getUserById(id);
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Clint> addUser(@Valid @RequestBody Clint u) {
        try {
            Clint ur = service.addUser(u);
            return ResponseEntity.status(HttpStatus.CREATED).body(ur);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Clint> updateUser(@RequestBody Clint b, @PathVariable("id") int id) {
        try {
            service.updateUser(b, id);
            return ResponseEntity.ok(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        try {
            service.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   
} 
