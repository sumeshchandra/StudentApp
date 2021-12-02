package com.example.studentapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class StudentEntity {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int rollNo;

}
