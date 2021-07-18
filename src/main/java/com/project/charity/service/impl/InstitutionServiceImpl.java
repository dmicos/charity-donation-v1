package com.project.charity.service.impl;

import com.project.charity.dto.InstitutionDto;
import com.project.charity.mapper.InstitutionMapper;
import com.project.charity.repository.InstitutionRepository;
import com.project.charity.service.InstitutionService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class InstitutionServiceImpl implements InstitutionService {
    private final InstitutionRepository institutionRepository;
    private final InstitutionMapper mapper;

    @Override
    public List<InstitutionDto> getAll() {
        return mapper.toDtoList(institutionRepository.findAll());
    }

    @Override
    public Long getQuantity() {
        return institutionRepository.count();
    }

    @Override
    public InstitutionDto getById(Long id) throws NotFoundException {
        return mapper.toDto(
                institutionRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Unable to get institution " + id)));
    }

    @Override
    public void saveOrUpdate(InstitutionDto institution) {
        institutionRepository.save(mapper.toEntity(institution));
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }
}
