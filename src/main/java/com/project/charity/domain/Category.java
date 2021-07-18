package com.project.charity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "donations")
@EqualsAndHashCode(
        callSuper = true,
        exclude = {"donations"})
@Entity
public class Category extends AbstractEntity {
    @NotBlank
    @Size(min = 2, max = 255)
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Donation> donations = new HashSet<>();
}
