package com.project.charity.mapper;

import com.project.charity.domain.Institution;
import com.project.charity.dto.InstitutionDto;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMapper extends AbstractMapper<Institution,InstitutionDto> {

    public InstitutionMapper() {
        super(Institution.class, InstitutionDto.class);
    }
}
