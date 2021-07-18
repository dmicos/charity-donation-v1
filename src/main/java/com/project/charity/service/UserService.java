package com.project.charity.service;

import com.project.charity.domain.ConfirmationToken;
import com.project.charity.domain.PasswordResetToken;
import com.project.charity.domain.Role;
import com.project.charity.domain.User;
import com.project.charity.dto.PasswordDto;
import com.project.charity.dto.ProfileDto;
import com.project.charity.dto.UserDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    User createUser(UserDto userDto, Role role);

    void createUserAndSendConfirmationToken(UserDto userDto, Role role, String appUrl);

    void updateUser(User user);

    UserDto getUserById(Long id);

    User getAuthenticatedUser();

    ProfileDto getProfileAuthenticatedUser();

    User getUserByEmail(String email);

    void deleteUsers(List<Long> userIds);

    void updateUsersRole(List<Long> usersId, Role role);

    void updateProfile(ProfileDto profileDto);

    boolean confirmUser(String confirmationToken);

    boolean updateForgotPassword(PasswordDto passwordDto, String token);

    void updatePasswordAuthorizedUser(String newPassword);

    boolean isEmailAlreadyInUse(String email);

    List<UserDto> getUsersByRoles(Role role, Sort sort);

    List<UserDto> getAllUsers();

    ConfirmationToken createConfirmationTokenForUser(User user);

    ConfirmationToken getConfirmationToken(String confirmationToken);

    void deleteConfirmationToken(ConfirmationToken token);

    PasswordResetToken createPasswordResetTokenForUser(User user);

    PasswordResetToken getPasswordResetToken(String passwordToken);

    boolean sendPasswordResetToken(String email, String appUrl);

    boolean existsPasswordResetToken(String token);

    void deletePasswordResetToken(Long id);
}
