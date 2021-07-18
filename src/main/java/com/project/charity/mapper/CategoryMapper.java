package com.project.charity.mapper;

import com.project.charity.domain.Category;
import com.project.charity.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDto> {
    public CategoryMapper() {
        super(Category.class, CategoryDto.class);
    }
}