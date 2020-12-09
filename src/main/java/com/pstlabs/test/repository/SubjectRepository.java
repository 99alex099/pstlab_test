package com.pstlabs.test.repository;

import com.pstlabs.test.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {
    Page<Subject> findAll(Pageable pageable);
}
