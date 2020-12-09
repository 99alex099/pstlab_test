package com.pstlabs.test.services.implementations;

import com.pstlabs.test.entities.Subject;
import com.pstlabs.test.repository.SubjectRepository;
import com.pstlabs.test.services.exceptions.EntityIdNotFoundException;
import com.pstlabs.test.services.exceptions.TextIsEmptyException;
import com.pstlabs.test.services.interfaces.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) throws EntityIdNotFoundException {
        return subjectRepository.findById(id).orElseThrow(
                () -> new EntityIdNotFoundException(id)
        );
    }

    @Override
    public Subject addEntity(Subject subject) throws TextIsEmptyException {
        checkSubjectInfo(subject);

        subject.setSubjectId(null);

        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateEntity(Subject subject) throws TextIsEmptyException {
        checkSubjectInfo(subject);

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteEntity(Long id) throws EntityIdNotFoundException {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
        } else {
            throw new EntityIdNotFoundException(id);
        }
    }

    private void checkSubjectInfo(Subject subject) {
        if (subject.getName() == null) throw new TextIsEmptyException("subject name wasn't filled");
    }

    @Override
    public Page<Subject> findByPage(int pageNumber, int subjectCountInPage) {
        Pageable pageable = PageRequest.of(pageNumber, subjectCountInPage, Sort.by("name").ascending());
        return subjectRepository.findAll(pageable);
    }
}
