package com.Student_Service.repository;

import com.Student_Service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value = """
            SELECT stu
            FROM Student as stu
            """)
    List<Student> getStudentByPage(Pageable pageable);
}
