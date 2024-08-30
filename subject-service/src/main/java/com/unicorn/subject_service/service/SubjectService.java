package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectDto;
import com.unicorn.subject_service.entity.Subject;
import com.unicorn.subject_service.repository.PrerequisiteRepository;
import com.unicorn.subject_service.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository repository;
    private final PrerequisiteRepository prerequisiteRepository;

    @Autowired
    public SubjectService(SubjectRepository repository, PrerequisiteRepository prerequisiteRepository) {
        this.repository = repository;
        this.prerequisiteRepository = prerequisiteRepository;
    }

    public List<SubjectDto> getSubject(Integer subjectId, Integer majorId, Integer prerequisiteId){
        var subjects = repository.getSubjects(subjectId,majorId);
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
}
