package com.pstlabs.test.services.implementations;

import com.pstlabs.test.entities.Student;
import com.pstlabs.test.entities.Teacher;
import com.pstlabs.test.repository.TeacherRepository;
import com.pstlabs.test.services.exceptions.EntityIdNotFoundException;
import com.pstlabs.test.services.exceptions.TextIsEmptyException;
import com.pstlabs.test.services.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) throws EntityIdNotFoundException {
        return teacherRepository.findById(id).orElseThrow(
                () -> new EntityIdNotFoundException(id)
        );
    }

    @Override
    public Teacher addEntity(Teacher teacher) throws TextIsEmptyException {
        checkTeacherInfo(teacher);

        teacher.setTeacherId(null);

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateEntity(Teacher teacher) throws TextIsEmptyException {
        checkTeacherInfo(teacher);
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteEntity(Long id) throws EntityIdNotFoundException {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        } else {
            throw new EntityIdNotFoundException(id);
        }
    }

    private void checkTeacherInfo(Teacher teacher) {
        if (teacher.getFullName() == null) throw new TextIsEmptyException("teacher name wasn't filled");
    }
}
