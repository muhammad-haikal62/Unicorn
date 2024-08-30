package com.unicorn.tutor_service.service.implementation;

import com.unicorn.tutor_service.dto.UpdateInsertTutor;
import com.unicorn.tutor_service.entity.Tutor;
import com.unicorn.tutor_service.repository.TutorRepository;
import com.unicorn.tutor_service.service.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImplementation implements TutorService {
    private final TutorRepository repository;
    @Autowired
    public TutorServiceImplementation(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UpdateInsertTutor updateInsertTutor) {
        Tutor tutor = new Tutor();
        tutor.setStaffNumber(updateInsertTutor.getStaffNumber());
        tutor.setUsername(updateInsertTutor.getUsername());
        tutor.setPassword(updateInsertTutor.getPassword());
        tutor.setTitle(updateInsertTutor.getTitle());
        tutor.setFirstName(updateInsertTutor.getFirstName());
        tutor.setMiddleName(updateInsertTutor.getMiddleName());
        tutor.setLastName(updateInsertTutor.getLastName());
        tutor.setGender(updateInsertTutor.getGender());
        tutor.setBirthDate(updateInsertTutor.getBirthDate());
        tutor.setBirthCountryId(updateInsertTutor.getBirthCountryId());
        tutor.setBirthCityId(updateInsertTutor.getBirthCityId());
        tutor.setCitizenshipId(updateInsertTutor.getCitizenshipId());
        tutor.setAddress(updateInsertTutor.getAddress());
        tutor.setHireDate(updateInsertTutor.getHireDate());
        tutor.setBasicSalary(updateInsertTutor.getBasicSalary());
        tutor.setAllowance(updateInsertTutor.getAllowance());
        tutor.setEmployeeType(updateInsertTutor.getEmployeeType());
        repository.save(tutor);
    }

    @Override
    public void delete(String staffNumber) {
        Tutor tutor = repository.findById(staffNumber).orElseThrow();
        repository.delete(tutor);
    }
}
