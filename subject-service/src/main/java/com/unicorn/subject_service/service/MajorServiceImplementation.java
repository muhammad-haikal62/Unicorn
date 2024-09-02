package com.unicorn.subject_service.service;

import com.unicorn.subject_service.dto.MajorGrid;
import com.unicorn.subject_service.dto.UpdateInsertMajor;
import com.unicorn.subject_service.entity.Major;
import com.unicorn.subject_service.repository.MajorRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MajorServiceImplementation implements MajorService{
    private final MajorRepository repository;

    public MajorServiceImplementation(MajorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MajorGrid> getMajors() {
        List<Major> majors = repository.getMajors();
        List<MajorGrid> dto = new LinkedList<>();
        for (Major major : majors){
            MajorGrid majorGrid = new MajorGrid();
            majorGrid.setId(major.getMajorId());
            majorGrid.setMajorName(major.getMajorName());
            majorGrid.setLevel(major.getLevel());
            majorGrid.setType(major.getType());
            majorGrid.setNonActiveDate(major.getNonActiveDate());
            majorGrid.setTotalCreditPoint(major.getTotalCreditPoint());
            majorGrid.setDescription(major.getDescription());
            dto.add(majorGrid);
        }
        return dto;
    }

    @Override
    public UpdateInsertMajor editMajor(Integer id) {
        UpdateInsertMajor updateInsertMajor = new UpdateInsertMajor();
        if(id != null){
            Major major = repository.findById(id).orElseThrow();
            updateInsertMajor.setId(major.getMajorId());
            updateInsertMajor.setMajorName(major.getMajorName());
            updateInsertMajor.setLevel(major.getLevel());
            updateInsertMajor.setType(major.getType());
            updateInsertMajor.setNonActiveDate(major.getNonActiveDate());
            updateInsertMajor.setTotalCreditPoint(major.getTotalCreditPoint());
            updateInsertMajor.setDescription(major.getDescription());
        }
        return updateInsertMajor;
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

    @Override
    public MajorGrid getMajorById(Integer id) {
        var major = repository.findById(id).orElseThrow();
        MajorGrid majorGrid = new MajorGrid();
        majorGrid.setId(major.getMajorId());
        majorGrid.setMajorName(major.getMajorName());
        majorGrid.setLevel(major.getLevel());
        majorGrid.setType(major.getType());
        majorGrid.setNonActiveDate(major.getNonActiveDate());
        majorGrid.setTotalCreditPoint(major.getTotalCreditPoint());
        majorGrid.setDescription(major.getDescription());
        return majorGrid;
    }
}
