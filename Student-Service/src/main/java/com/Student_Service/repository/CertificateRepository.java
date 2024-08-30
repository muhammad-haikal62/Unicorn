package com.Student_Service.repository;

import com.Student_Service.dto.CertificateDto;
import com.Student_Service.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    @Query("""
            SELECT new com.Student_Service.dto.CertificateDto(cer.id, cer.studentNumber, cer.graduateDate,
            cer.totalMark, cer.grade, cer.academicTitle, cer.level)
            FROM Certificate cer
            WHERE cer.studentNumber =:studentNumber
            """)
    CertificateDto getCertificate(String studentNumber);
}
