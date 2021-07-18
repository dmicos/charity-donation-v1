package com.project.charity.validation;

import com.project.charity.repository.CategoryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private final CategoryRepository categoryRepository;

    public UniqueNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initialize(UniqueName constraint) {
    }

    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name != null && !categoryRepository.findByName(name).isPresent();
    }

}