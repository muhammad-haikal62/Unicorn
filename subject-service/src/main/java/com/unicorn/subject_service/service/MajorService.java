package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.UpdateInsertMajor;

public interface MajorService {
    void save(UpdateInsertMajor dto);
    void delete(Integer id);
}
