package com.example.mapping_fileupload;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "clint_id")
    @JsonBackReference
    private Clint clint;

    public Manager() {
    }

    public Manager(int id, String name, Clint clint) {
        this.id = id;
        this.name = name;
        this.clint = clint;
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

    public Clint getClint() {
        return clint;
    }

    public void setClint(Clint clint) {
        this.clint = clint;
    }

    @Override
    public String toString() {
        return "Manager [id=" + id + ", name=" + name + ", clint=" + clint + "]";
    }



    
    
}
