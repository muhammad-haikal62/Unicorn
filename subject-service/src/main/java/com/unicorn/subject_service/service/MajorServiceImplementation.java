package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.UpdateInsertMajor;
import com.unicorn.subject_service.entity.Major;
import com.unicorn.subject_service.repository.MajorRepository;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImplementation implements MajorService{
    private final MajorRepository repository;

    public MajorServiceImplementation(MajorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UpdateInsertMajor dto) {
        Major major = new Major();
        major.setMajorId(dto.getId());
        major.setMajorName(dto.getMajorName());
        major.setLevel(dto.getLevel());
        major.setType(dto.getType());
        major.setDescription(dto.getDescription());
        major.setTotalCreditPoint(dto.getTotalCreditPoint());
        major.setNonActiveDate(dto.getNonActiveDate());
        repository.save(major);
    }

    @Override
    public void delete(Integer id) {
        var major = repository.findById(id).orElseThrow();
        repository.delete(major);
    }
}
