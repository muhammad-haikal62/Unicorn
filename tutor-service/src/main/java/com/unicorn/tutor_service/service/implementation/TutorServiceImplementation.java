package com.unicorn.tutor_service.service.implementation;

import com.unicorn.tutor_service.dto.TutorGridDto;
import com.unicorn.tutor_service.dto.UpdateInsertTutor;
import com.unicorn.tutor_service.entity.Tutor;
import com.unicorn.tutor_service.repository.TutorRepository;
import com.unicorn.tutor_service.service.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TutorServiceImplementation implements TutorService {
    private final TutorRepository repository;
    private final int rowInPage=10;

    @Autowired
    public TutorServiceImplementation(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TutorGridDto> getAllTutor(int page) {
        List<TutorGridDto> tutorGridDtos = new LinkedList<>();
        List<Tutor> tutors = repository.getALlTutor();

        for(Tutor tutor : tutors){
            TutorGridDto tutorGridDto = new TutorGridDto();
            tutorGridDto.setFullName(tutor.getFirstName() + tutor.getMiddleName() + tutor.getLastName());
            tutorGridDto.setGender(tutor.getGender());
            tutorGridDto.setBirthDate(tutor.getBirthDate());
            tutorGridDtos.add(tutorGridDto);
        }
        return tutorGridDtos;
    }

    @Override
    public TutorGridDto getTutorById(String id) {
        Tutor tutor = repository.findById(id).orElseThrow();
        TutorGridDto tutorGridDto = new TutorGridDto();
        tutorGridDto.setFullName(tutor.getFirstName() + tutor.getMiddleName() + tutor.getLastName());
        tutorGridDto.setGender(tutor.getGender());
        tutorGridDto.setBirthDate(tutor.getBirthDate());
        return tutorGridDto;
    }

    @Override
    public TutorGridDto getTutorByName(String name) {
        Tutor tutor = repository.getTutorByName(name);
        TutorGridDto tutorGridDto = new TutorGridDto();
        tutorGridDto.setFullName(tutor.getFirstName() + tutor.getMiddleName() + tutor.getLastName());
        tutorGridDto.setGender(tutor.getGender());
        tutorGridDto.setBirthDate(tutor.getBirthDate());
        return tutorGridDto;
    }

    @Override
    public int getTotalPage() {
        return (int)(Math.ceil(((double) repository.count())/ rowInPage));
    }

    @Override
    public void save(UpdateInsertTutor updateInsertTutor) {
        try{
            Tutor tutor = repository.findById(updateInsertTutor.getStaffNumber()).orElseThrow();
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
        }catch (Exception exception){
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
    }

    @Override
    public void delete(String staffNumber) {
        Tutor tutor = repository.findById(staffNumber).orElseThrow();
        repository.delete(tutor);
    }
}
