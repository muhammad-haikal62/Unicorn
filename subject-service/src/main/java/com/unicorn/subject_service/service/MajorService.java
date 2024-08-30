package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.MajorGrid;
import com.unicorn.subject_service.dto.UpdateInsertMajor;

import java.util.List;

public interface MajorService {
    List<MajorGrid> getMajors();
    UpdateInsertMajor editMajor(Integer id);
    void save(UpdateInsertMajor dto);
    void delete(Integer id);
    MajorGrid getMajorById(Integer id);
}
