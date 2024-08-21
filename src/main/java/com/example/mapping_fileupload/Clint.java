package com.example.mapping_fileupload;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Clint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


     @OneToOne(mappedBy = "clint", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Manager manager;



    public Clint() {
    }

    public Clint(int id, String name, Manager manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {

        return "Clint [id=" + id + ", name=" + name + ", manager=" + manager + "]";
        
    }

    
    

    
}
