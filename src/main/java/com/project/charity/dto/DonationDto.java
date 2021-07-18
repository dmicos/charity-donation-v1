package com.project.charity.dto;

import com.project.charity.domain.Category;
import com.project.charity.domain.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationDto extends AbstractDto {
    @NotNull
    private Integer quantity;
    @NotNull
    private Set<Category> categories = new HashSet<>();
    @NotNull
    private Institution institution;
    @NotBlank
    @Size(min = 2, max = 255)
    private String street;
    @NotBlank
    @Size(min = 2, max = 255)
    private String city;
    @NotBlank
    @Pattern(regexp = "^([0-9]{2})(-[0-9]{3})?$")
    private String zipcode;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;
    @Size(max = 1024)
    private String pickUpComment;
    private LocalDateTime createdOn;
}
