package com.pstlabs.test.controllers;

import com.pstlabs.test.entities.Student;
import com.pstlabs.test.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Student> findStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student findStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Student addStudent(@RequestBody Student student) {
        return studentService.addEntity(student);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        student.setStudentId(id);
        return studentService.updateEntity(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteEntity(id);
    }
}
