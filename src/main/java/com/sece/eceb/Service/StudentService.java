package com.sece.eceb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sece.eceb.dto.Student;
import com.sece.eceb.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // Create Student
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

    // Get One Student
    public Student getOneStudent(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    // Update AStudent
    public Student updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setRollNo(student.getRollNo());
            existing.setDepartment(student.getDepartment());

            return studentRepository.save(existing);
        }

        return null;
    }

    // Delete Student
    public String deleteStudent(Long id) {

        studentRepository.deleteById(id);

        return "Student deleted successfully";
    }
}