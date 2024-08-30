package com.Student_Service.repository;

import com.Student_Service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.ValidationAnnotationUtils;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value = """
            SELECT stu
            FROM Student as stu
            """)
    List<Student> getStudentByPage(Pageable pageable);

    @Query(value = """
            SELECT count(stu)
            FROM Student as stu
            """)
    Integer getTotal();

    @Query(value = """
            SELECT stu
            FROM Student as stu
            WHERE stu.studentNumber = :studentNumber
            """)
    Student getStudentByNumber(String studentNumber);
}
