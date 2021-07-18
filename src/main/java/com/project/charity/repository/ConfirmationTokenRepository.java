package com.project.charity.repository;

import com.project.charity.domain.ConfirmationToken;
import com.project.charity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findByToken(String token);

    void removeAllByUser(User user);

    void deleteAllByUserIn(List<User> users);
}
