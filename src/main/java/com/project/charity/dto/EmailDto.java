package com.project.charity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class EmailDto extends AbstractDto {
    @NotBlank
    @Size(min = 2)
    private String name;
    @NotBlank
    @Size(min = 2)
    private String subject;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 10)
    private String message;
}
