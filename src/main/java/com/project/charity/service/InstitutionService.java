package com.project.charity.service;

import com.project.charity.dto.InstitutionDto;
import javassist.NotFoundException;

import java.util.List;

public interface InstitutionService {
    List<InstitutionDto> getAll();

    InstitutionDto getById(Long id) throws NotFoundException;

    void saveOrUpdate(InstitutionDto institution);

    void delete(Long id);

    Long getQuantity();
}
