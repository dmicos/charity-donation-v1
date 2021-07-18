package com.project.charity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(
        callSuper = true,
        exclude = {"donations", "description"})
@ToString(exclude = "donations")
@Entity
public class Institution extends AbstractEntity {
    @NotBlank
    @Size(min = 2, max = 255)
    @Column(unique = true)
    private String name;
    @Size(max = 1024)
    private String description;
    @OneToMany(mappedBy = "institution")
    private List<Donation> donations = new ArrayList<>();
}
