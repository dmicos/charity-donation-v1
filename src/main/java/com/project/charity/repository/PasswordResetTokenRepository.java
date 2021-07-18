package com.project.charity.repository;

import com.project.charity.domain.PasswordResetToken;
import com.project.charity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    boolean existsByToken(String token);

    void deleteAllByUserIn(List<User> user);
}
