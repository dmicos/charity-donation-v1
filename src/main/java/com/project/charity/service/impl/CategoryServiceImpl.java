package com.project.charity.service.impl;

import com.project.charity.dto.CategoryDto;
import com.project.charity.mapper.CategoryMapper;
import com.project.charity.repository.CategoryRepository;
import com.project.charity.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryDto> getAll() {
        return mapper.toDtoList(categoryRepository.findAll());
    }
}
