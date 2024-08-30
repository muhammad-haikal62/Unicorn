package com.unicorn.tutor_service.service.service;

import com.unicorn.tutor_service.dto.TutorGridDto;
import com.unicorn.tutor_service.dto.UpdateInsertTutor;

import java.util.List;

public interface TutorService {
    List<TutorGridDto> getAllTutor(int page);
    TutorGridDto getTutorById(String id);
    TutorGridDto getTutorByName(String name);
    int getTotalPage();
    void save(UpdateInsertTutor updateInsertTutor);
    void delete(String staffNumber);
}
