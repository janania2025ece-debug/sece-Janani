package com.sece.eceb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sece.eceb.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
}