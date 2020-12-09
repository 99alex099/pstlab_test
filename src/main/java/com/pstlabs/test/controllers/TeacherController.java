package com.pstlabs.test.controllers;

import com.pstlabs.test.entities.Student;
import com.pstlabs.test.entities.Teacher;
import com.pstlabs.test.services.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherService.addEntity(teacher);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher upd(@RequestBody Teacher teacher, @PathVariable Long id) {
        teacher.setTeacherId(id);
        return teacherService.updateEntity(teacher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteEntity(id);
    }
}
