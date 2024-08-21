package com.example.mapping_fileupload;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {

    @Autowired
    private ClintRepo userRepo;

    public List<Clint> getAllUsers() {
        return (List<Clint>) userRepo.findAll();
    }

    public Clint getUserById(int id) {
        Optional<Clint> optionalUser = userRepo.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("Clint not found"));
    }

    public Clint addUser(Clint u) {
        return userRepo.save(u);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void updateUser(Clint u, int id) {
        u.setId(id);
        userRepo.save(u);
    }


} 
