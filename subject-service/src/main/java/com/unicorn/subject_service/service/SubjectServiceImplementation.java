package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectDto;
import com.unicorn.subject_service.dto.SubjectSaveDto;
import com.unicorn.subject_service.entity.Subject;
import com.unicorn.subject_service.repository.SubjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService{
    private final SubjectRepository repository;
    private final Integer rowInPage = 10;

    public SubjectServiceImplementation(SubjectRepository repository){
        this.repository = repository;
    }

    @Override
    public List<SubjectDto> get(Integer page) {
        Pageable pagination = PageRequest.of(page-1,rowInPage, Sort.by("id"));
        var subjects = repository.findAll(pagination);
        List<SubjectDto> subjectDtos = new LinkedList<>();
        for(var subject : subjects){
            SubjectDto dto = new SubjectDto();
            dto.setCode(subject.getCode());
            dto.setCost(subject.getCost());
            dto.setDescription(subject.getDescription());
            dto.setLevel(subject.getLevel());
            dto.setId(subject.getId());
            dto.setCreditPoint(subject.getCreditPoint());
            dto.setName(subject.getName());
            dto.setNonActiveDate(subject.getNonActiveDate());
            dto.setMajorId(subject.getMajorId());

            subjectDtos.add(dto);
        }
        return subjectDtos;
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
