package com.Student_Service.service.implemention;

import com.Student_Service.dto.CertificateDto;
import com.Student_Service.dto.StudentDto;
import com.Student_Service.dto.StudentMajorDto;
import com.Student_Service.dto.StudentUpsertDto;
import com.Student_Service.entity.Student;
import com.Student_Service.repository.MajorRepository;
import com.Student_Service.repository.StudentMajorRepository;
import com.Student_Service.repository.CertificateRepository;
import com.Student_Service.repository.StudentRepository;
import com.Student_Service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImplemention implements StudentService {
    private final StudentRepository repository;
    private final StudentMajorRepository studentMajorRepository;
    private final MajorRepository majorRepository;
    private final CertificateRepository certificateRepository;


    @Autowired
    public StudentServiceImplemention(StudentRepository repository, StudentMajorRepository studentMajorRepository, MajorRepository majorRepository, CertificateRepository certificateRepository) {
        this.repository = repository;
        this.studentMajorRepository = studentMajorRepository;
        this.majorRepository = majorRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    public List<StudentDto> getAllStudentPage(Integer page) {
        Pageable pageable = PageRequest.of(page-1, 5, Sort.by("id"));
        List<Student> students = repository.getStudentByPage(pageable);
        List<StudentDto> gridStudents = new LinkedList<>();
        for (var stu : students){
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentNumber(stu.getStudentNumber());
            studentDto.setUsername(stu.getUsername());
            studentDto.setPassword(stu.getPassword());
            studentDto.setTitle(stu.getTitle());
            studentDto.setFirstName(stu.getFirstName());
            studentDto.setMiddleName(stu.getMiddleName());
            studentDto.setLastName(stu.getLastName());
            studentDto.setGender(stu.getGender());
            studentDto.setBirthDate(stu.getBirthDate());
            studentDto.setBirthCountryId(stu.getBirthCountryId());
            studentDto.setBirthCityId(stu.getBirthCityId());
            studentDto.setCitizenshipId(stu.getCitizenshipId());
            studentDto.setAddress(stu.getAddress());
            studentDto.setRegisterDate(stu.getRegisterDate());
            studentDto.setTotalCreditPoint(stu.getTotalCreditPoint());
            gridStudents.add(studentDto);
        }
        return gridStudents;
    }

    @Override
    public void saveStudent(StudentUpsertDto dto) {
        Student student = new Student();
        student.setStudentNumber(dto.getStudentNumber());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        student.setTitle(dto.getTitle());
        student.setFirstName(dto.getFirstName());
        student.setMiddleName(dto.getMiddleName().isEmpty() ? null:dto.getMiddleName());
        student.setLastName(dto.getLastName().isEmpty() ? null:dto.getLastName());
        student.setGender(dto.getGender());
        student.setBirthDate(dto.getBirthDate());
        student.setBirthCountryId(dto.getBirthCountryId());
        student.setBirthCityId(dto.getBirthCityId());
        student.setCitizenshipId(dto.getCitizenshipId());
        student.setAddress(dto.getAddress());
        student.setRegisterDate(dto.getRegisterDate());
        student.setTotalCreditPoint(dto.getTotalCreditPoint());
        repository.save(student);
    }

    @Override
    public StudentDto getStudentByStudentNumber(String studentNumber) {
        Student stu = repository.getStudentByNumber(studentNumber);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNumber(stu.getStudentNumber());
        studentDto.setUsername(stu.getUsername());
        studentDto.setPassword(stu.getPassword());
        studentDto.setTitle(stu.getTitle());
        studentDto.setFirstName(stu.getFirstName());
        studentDto.setMiddleName(stu.getMiddleName());
        studentDto.setLastName(stu.getLastName());
        studentDto.setGender(stu.getGender());
        studentDto.setBirthDate(stu.getBirthDate());
        studentDto.setBirthCountryId(stu.getBirthCountryId());
        studentDto.setBirthCityId(stu.getBirthCityId());
        studentDto.setCitizenshipId(stu.getCitizenshipId());
        studentDto.setAddress(stu.getAddress());
        studentDto.setRegisterDate(stu.getRegisterDate());
        studentDto.setTotalCreditPoint(stu.getTotalCreditPoint());
        return studentDto;
    }

    @Override
    public StudentDto getStudentByFullName(String fullName) {
        Student stu = repository.getStudentByFullName(fullName);
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentNumber(stu.getStudentNumber());
        studentDto.setUsername(stu.getUsername());
        studentDto.setPassword(stu.getPassword());
        studentDto.setTitle(stu.getTitle());
        studentDto.setFirstName(stu.getFirstName());
        studentDto.setMiddleName(stu.getMiddleName());
        studentDto.setLastName(stu.getLastName());
        studentDto.setGender(stu.getGender());
        studentDto.setBirthDate(stu.getBirthDate());
        studentDto.setBirthCountryId(stu.getBirthCountryId());
        studentDto.setBirthCityId(stu.getBirthCityId());
        studentDto.setCitizenshipId(stu.getCitizenshipId());
        studentDto.setAddress(stu.getAddress());
        studentDto.setRegisterDate(stu.getRegisterDate());
        studentDto.setTotalCreditPoint(stu.getTotalCreditPoint());
        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentByCitizenshipID(Integer citizenshipId) {
        List<Student> students = repository.getStudentByCitizenshipID(citizenshipId);
        List<StudentDto> gridStudents = new LinkedList<>();
        for (var stu : students){
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentNumber(stu.getStudentNumber());
            studentDto.setUsername(stu.getUsername());
            studentDto.setPassword(stu.getPassword());
            studentDto.setTitle(stu.getTitle());
            studentDto.setFirstName(stu.getFirstName());
            studentDto.setMiddleName(stu.getMiddleName());
            studentDto.setLastName(stu.getLastName());
            studentDto.setGender(stu.getGender());
            studentDto.setBirthDate(stu.getBirthDate());
            studentDto.setBirthCountryId(stu.getBirthCountryId());
            studentDto.setBirthCityId(stu.getBirthCityId());
            studentDto.setCitizenshipId(stu.getCitizenshipId());
            studentDto.setAddress(stu.getAddress());
            studentDto.setRegisterDate(stu.getRegisterDate());
            studentDto.setTotalCreditPoint(stu.getTotalCreditPoint());
            gridStudents.add(studentDto);
        }
        return gridStudents;
    }

    @Override
    public Integer totalPage(){
        int total = repository.getTotal();
        int hasil = 0;
        if(total %5==0 ){
            hasil = total/5;
        }else {
            int sisa = total%5;
            hasil = (total-sisa)/5;
            hasil = hasil + 1;
        }
        hasil = hasil == 0 ? hasil : 1;
        return hasil;
    }

    @Override
    public void editStudent(StudentUpsertDto dto) {
        var student = repository.findById(dto.getStudentNumber()).orElseThrow();
        student.setStudentNumber(student.getStudentNumber());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        student.setTitle(dto.getTitle());
        student.setFirstName(dto.getFirstName());
        student.setMiddleName(dto.getMiddleName().isEmpty() ? null:dto.getMiddleName());
        student.setLastName(dto.getLastName().isEmpty() ? null:dto.getLastName());
        student.setGender(dto.getGender());
        student.setBirthDate(dto.getBirthDate());
        student.setBirthCountryId(dto.getBirthCountryId());
        student.setBirthCityId(dto.getBirthCityId());
        student.setCitizenshipId(dto.getCitizenshipId());
        student.setAddress(dto.getAddress());
        student.setRegisterDate(dto.getRegisterDate());
        student.setTotalCreditPoint(dto.getTotalCreditPoint());
        repository.save(student);
    }

    @Override
    public void deleteStudent(String studentNumber) {
        var student = repository.findById(studentNumber).orElseThrow();
        repository.delete(student);
    }

    @Override
    public List<StudentMajorDto> getMajorByStudentNumber(String studentNumber) {
        var majorsList = new LinkedList<StudentMajorDto>();
        for(var major : studentMajorRepository.getMajorByStudentNumber(studentNumber)) {
            var majorDetail = majorRepository.findById(major.getMajorId()).orElseThrow();
            var majors = new StudentMajorDto();
            majors.setName(majorDetail.getName());
            majors.setType(majorDetail.getType());
            majors.setLevel(majorDetail.getLevel());
            majors.setDescription(majorDetail.getDescription());
            majorsList.add(majors);
        }
        return majorsList;
    }

    @Override
    public CertificateDto getCertificate(String studentNumber) {
        return this.certificateRepository.getCertificate(studentNumber);
    }
}
