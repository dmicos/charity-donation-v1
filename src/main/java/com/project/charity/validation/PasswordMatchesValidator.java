package com.project.charity.validation;

import com.project.charity.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

   public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDto> {
   public void initialize(PasswordMatches constraint) {
   }

   @Override
   public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
      return userDto.getPassword().equals(userDto.getMatchingPassword());
   }
}
