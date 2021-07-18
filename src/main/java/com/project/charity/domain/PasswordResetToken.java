package com.project.charity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PasswordResetToken extends AbstractEntity {
    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;

    public PasswordResetToken(User user) {
        this.token = UUID.randomUUID().toString();
        this.user = user;
    }
}
