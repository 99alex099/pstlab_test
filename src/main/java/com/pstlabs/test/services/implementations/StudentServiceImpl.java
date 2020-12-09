package com.pstlabs.test.services.implementations;

import com.pstlabs.test.entities.Student;
import com.pstlabs.test.repository.StudentRepository;
import com.pstlabs.test.services.exceptions.EntityIdNotFoundException;
import com.pstlabs.test.services.exceptions.TextIsEmptyException;
import com.pstlabs.test.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) throws EntityIdNotFoundException {
        return studentRepository.findById(id).orElseThrow(
                () -> new EntityIdNotFoundException(id)
        );
    }

    @Override
    public Student addEntity(Student student) throws TextIsEmptyException {
        checkStudentInfo(student);

        student.setStudentId(null);

        return studentRepository.save(student);
    }

    @Override
    public Student updateEntity(Student student) throws TextIsEmptyException {
        checkStudentInfo(student);

        return studentRepository.save(student);
    }

    @Override
    public void deleteEntity(Long id) throws EntityIdNotFoundException {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new EntityIdNotFoundException(id);
        }
    }

    private void checkStudentInfo(Student student) {
        if (student.getGroupName() == null || student.getPersonData().getAge() == null
        || student.getPersonData().getFullName() == null) throw new TextIsEmptyException();
    }
}
