package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {

    @Id
    private long studentId;
    
    // standard constructor, getters, setters
}