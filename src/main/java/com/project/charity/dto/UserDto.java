package com.project.charity.dto;

import com.project.charity.validation.PasswordMatches;
import com.project.charity.validation.UniqueEmail;
import com.project.charity.validation.ValidPassword;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PasswordMatches
public class UserDto extends AbstractDto {
    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @NotBlank
    @UniqueEmail
    @Email
    private String email;
    @NotBlank
    @ValidPassword
    private String password;
    @NotBlank
    private String matchingPassword;
    private LocalDateTime createdOn;
}
