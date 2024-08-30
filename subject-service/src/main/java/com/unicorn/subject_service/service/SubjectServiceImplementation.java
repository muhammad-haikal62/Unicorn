package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectSaveDto;
import com.unicorn.subject_service.entity.Subject;
import com.unicorn.subject_service.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImplementation implements SubjectService{
    private final SubjectRepository repository;

    public SubjectServiceImplementation(SubjectRepository repository){
        this.repository = repository;
    }

    @Override
    public void save(SubjectSaveDto dto){
        Subject subject = new Subject();
        subject.setId(dto.getId());
        subject.setCode(dto.getCode());
        subject.setName(dto.getName());
        subject.setMajorId(dto.getMajorId());
        subject.setDescription(dto.getDescription());
        subject.setLevel(dto.getLevel());
        subject.setCreditPoint(dto.getCreditPoint());
        subject.setCost(dto.getCost());
        subject.setNonActiveDate(dto.getNonActiveDate());
        repository.save(subject);
    }

    @Override
    public void delete(Integer id){
        var subject = repository.findById(id).orElseThrow();
        repository.delete(subject);
    }
}
