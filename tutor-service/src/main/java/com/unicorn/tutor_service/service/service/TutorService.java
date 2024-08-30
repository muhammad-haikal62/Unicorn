package com.unicorn.tutor_service.service.service;

import com.unicorn.tutor_service.dto.UpdateInsertTutor;

public interface TutorService {
    void save(UpdateInsertTutor updateInsertTutor);
    void delete(String staffNumber);
}
