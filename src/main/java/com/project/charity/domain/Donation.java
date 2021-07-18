package com.project.charity.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
public class Donation extends AbstractEntity {
    @NotNull
    private Integer quantity;
    @NotNull
    @ManyToMany
    private Set<Category> categories = new HashSet<>();
    @NotNull
    @ManyToOne
    @JoinColumn
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
    @ManyToOne
    @JoinColumn
    private User user;
}

