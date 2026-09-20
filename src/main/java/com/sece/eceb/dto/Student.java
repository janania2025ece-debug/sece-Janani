package com.sece.eceb.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rollNo;
    private String department;

    public Student() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getRollNo() {

        return rollNo;
    }

    public void setRollNo(String rollNo) {

        this.rollNo = rollNo;
    }
    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }
}