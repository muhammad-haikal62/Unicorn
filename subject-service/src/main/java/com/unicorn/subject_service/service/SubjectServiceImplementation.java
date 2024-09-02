package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectDto;
import com.unicorn.subject_service.dto.SubjectSaveDto;
import com.unicorn.subject_service.entity.Subject;
import com.unicorn.subject_service.repository.PrerequisiteRepository;
import com.unicorn.subject_service.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService{
    private final SubjectRepository repository;
    private final PrerequisiteRepository prerequisiteRepository;
    private final Integer rowInPage = 10;

    @Autowired
    public SubjectServiceImplementation(SubjectRepository repository, PrerequisiteRepository prerequisiteRepository) {
        this.repository = repository;
        this.prerequisiteRepository = prerequisiteRepository;
    }

    @Override
    public List<SubjectDto> getSubject(Integer page, Integer subjectId, Integer majorId, Integer prerequisiteId) {
        Pageable pagination = PageRequest.of(page-1,rowInPage, Sort.by("id"));
        var subjects = repository.getSubjects(pagination, subjectId,majorId);
        List<Integer> subjectPrerequisiteIds = prerequisiteId == 0? new LinkedList<>() : prerequisiteRepository.getSubjectId(prerequisiteId);
        List<SubjectDto> dtoList = new LinkedList<>();
        if (subjectPrerequisiteIds.size()==0){
            for (var subject : subjects) {
                var dto = populateDto(subject);
                dtoList.add(dto);
            }
        }
        else {
            for (var subjectIdPrerequisite :subjectPrerequisiteIds){
                for (var subject : subjects) {
                    if (subjectIdPrerequisite != subject.getId()) {
                        continue;
                    }
                    var dto = populateDto(subject);
                    dtoList.add(dto);
                }
            }
        }
        return dtoList;
    }

    private SubjectDto populateDto(Subject subject){
        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setCode(subject.getCode());
        dto.setName(subject.getName());
        dto.setMajorId(subject.getMajorId());
        dto.setDescription(subject.getDescription());
        dto.setLevel(subject.getLevel());
        dto.setCreditPoint(subject.getCreditPoint());
        dto.setCost(subject.getCost());
        dto.setNonActiveDate(subject.getNonActiveDate());
        return dto;
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
