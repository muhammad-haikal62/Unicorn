package com.unicorn.subject_service.repository;

import com.unicorn.subject_service.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer>{
}
