package com.Student_Service.repository;

import com.Student_Service.entity.StudentMajor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMajorRepository extends JpaRepository<StudentMajor,Integer> {
    @Query(value = """
            SELECT stm
            FROM StudentMajor as stm
            WHERE stm.studentNumber = :studentNumber
            """)
    List<StudentMajor> getMajorByStudentNumber(String studentNumber);
}
