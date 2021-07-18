package com.project.charity.dto;

import com.project.charity.validation.UniqueName;
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
public class CategoryDto extends AbstractDto {
    @NotBlank
    @UniqueName
    @Size(min = 2, max = 255)
    private String name;
}
