package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.SubjectSaveDto;

public interface SubjectService{
    void save(SubjectSaveDto dto);
    void delete(Integer id);
}
