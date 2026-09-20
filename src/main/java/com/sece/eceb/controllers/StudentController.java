package com.sece.eceb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sece.eceb.Service.StudentService;
import com.sece.eceb.dto.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getStudent() {

        return studentService.getStudent();
    }

    @GetMapping("/student/{id}")
    public Student getOneStudent(@PathVariable Long id) {

        return studentService.getOneStudent(id);
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {

        return studentService.deleteStudent(id);
    }
}