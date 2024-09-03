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
            WHERE (:citizenshipId IS NULL OR stu.citizenshipId = :citizenshipId)
            """)
    List<Student> getStudent(Pageable pageable,Integer citizenshipId);

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

    @Query(value = """
            SELECT stu
            FROM Student as stu
            WHERE CONCAT(stu.firstName,' ',stu.middleName,' ',stu.lastName) = :fullName
            """)
    Student getStudentByFullName(String fullName);
}
