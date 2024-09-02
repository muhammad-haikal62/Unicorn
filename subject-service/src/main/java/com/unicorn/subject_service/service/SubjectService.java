package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectDto;
import com.unicorn.subject_service.dto.SubjectSaveDto;

import java.util.List;

public interface SubjectService {

    List<SubjectDto> getSubject(Integer page, Integer subjectId, Integer majorId, Integer prerequisiteId);
    void save(SubjectSaveDto dto);
    void delete(Integer id);

}
