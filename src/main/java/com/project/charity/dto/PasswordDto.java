package com.project.charity.dto;

import com.project.charity.validation.FieldsValueMatch;
import com.project.charity.validation.ValidPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldsValueMatch(
        field = "password",
        fieldMatch = "matchingPassword")
public class PasswordDto {
    @NotBlank
    @ValidPassword
    private String password;
    @NotBlank
    private String matchingPassword;
}
