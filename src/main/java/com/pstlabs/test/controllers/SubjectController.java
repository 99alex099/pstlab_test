package com.pstlabs.test.controllers;

import com.pstlabs.test.entities.Subject;
import com.pstlabs.test.services.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/page")
    @ResponseStatus(HttpStatus.OK)
    public Page<Subject> findByPage(@RequestParam(name = "pageNumber") int pageNumber,
                                       @RequestParam(name = "subjectCountInPage") int subjectCountInPage) {
        return subjectService.findByPage(pageNumber, subjectCountInPage);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Subject> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subject findById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Subject add(@RequestBody Subject subject) {
        return subjectService.addEntity(subject);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subject upd(@RequestBody Subject subject, @PathVariable Long id) {
        subject.setSubjectId(id);
        return subjectService.updateEntity(subject);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable Long id) {
        subjectService.deleteEntity(id);
    }
}
