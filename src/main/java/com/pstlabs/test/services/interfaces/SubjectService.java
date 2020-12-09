package com.pstlabs.test.services.interfaces;

import com.pstlabs.test.entities.Subject;
import org.springframework.data.domain.Page;

public interface SubjectService extends EntityService<Subject> {
    Page<Subject> findByPage(int pageNumber, int subjectCountInPage);
}
