package com.project.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionDto extends AbstractDto {
    @NotBlank
    @Size(min = 2, max = 255)
    private String name;
    @Size(max = 1024)
    private String description;
}
