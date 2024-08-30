package com.Student_Service.repository;

import com.Student_Service.entity.StudentMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMajorRepository extends JpaRepository<StudentMajor,Integer> {
}
