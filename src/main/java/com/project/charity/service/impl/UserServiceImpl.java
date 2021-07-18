package com.project.charity.service.impl;

import com.project.charity.domain.ConfirmationToken;
import com.project.charity.domain.PasswordResetToken;
import com.project.charity.domain.Role;
import com.project.charity.domain.User;
import com.project.charity.dto.PasswordDto;
import com.project.charity.dto.ProfileDto;
import com.project.charity.dto.UserDto;
import com.project.charity.event.RegistrationEvent;
import com.project.charity.event.ResetPasswordEvent;
import com.project.charity.mapper.UserMapper;
import com.project.charity.repository.ConfirmationTokenRepository;
import com.project.charity.repository.PasswordResetTokenRepository;
import com.project.charity.repository.UserRepository;
import com.project.charity.service.AuthenticationFacade;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher eventPublisher;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final AuthenticationFacade authenticationFacade;
    private final UserMapper mapper;

    @Override
    public User createUser(UserDto userDto, Role role) {
        User user = mapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singleton(role));
        return userRepository.save(user);
    }

    @Override
    public void createUserAndSendConfirmationToken(UserDto userDto, Role role, String appUrl) {
        User userToConfirm = createUser(userDto, role);
        eventPublisher.publishEvent(new RegistrationEvent(userToConfirm, appUrl));
    }

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> getUsersByRoles(Role role, Sort sort) {
        return mapper.toDtoList(userRepository.findAllByRoles(role, sort));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long id) {
        return mapper.toDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public User getAuthenticatedUser() {
        String name = authenticationFacade.getAuthentication().getName();
        return getUserByEmail(name);
    }

    @Override
    public ProfileDto getProfileAuthenticatedUser() {
        User authenticatedUser = getAuthenticatedUser();
        ProfileDto profileDto = new ProfileDto();
        profileDto.setFirstName(authenticatedUser.getFirstName());
        profileDto.setLastName(authenticatedUser.getLastName());
        profileDto.setEmail(authenticatedUser.getEmail());
        return profileDto;
    }

    @Override
    public void deleteUsers(List<Long> userIds) {
        //todo
        List<User> users = userRepository.findAllById(userIds);
        passwordResetTokenRepository.deleteAllByUserIn(users);
        confirmationTokenRepository.deleteAllByUserIn(users);
        userRepository.deleteAll(users);
    }

    @Override
    public void updateUsersRole(List<Long> usersId, Role role) {
        userRepository.findAllById(usersId)
                .forEach(user -> {
                    user.setRoles(Collections.singleton(role));
                });
    }

    @Override
    public void updateProfile(ProfileDto profileDto) {
        User user = getUserByEmail(profileDto.getEmail());
        if (passwordEncoder.matches(profileDto.getPassword(), user.getPassword())) {
            user.setFirstName(profileDto.getFirstName());
            user.setLastName(profileDto.getLastName());
            updateUser(user);
        }
        //todo add else
    }

    @Override
    public ConfirmationToken createConfirmationTokenForUser(User user) {
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        return confirmationTokenRepository.save(confirmationToken);
    }

    @Override
    public ConfirmationToken getConfirmationToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsPasswordResetToken(String token) {
        return passwordResetTokenRepository.existsByToken(token);
    }

    @Override
    public PasswordResetToken createPasswordResetTokenForUser(User user) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(user);
        return passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public PasswordResetToken getPasswordResetToken(String passwordToken) {
        return passwordResetTokenRepository.findByToken(passwordToken);
    }

    @Override
    public boolean sendPasswordResetToken(String email, String appUrl) {
        User user = getUserByEmail(email);
        if (user == null) {
            return false;
        }
        eventPublisher.publishEvent(new ResetPasswordEvent(user, appUrl));
        return true;
    }

    @Override
    public boolean updateForgotPassword(PasswordDto passwordDto, String token) {
        PasswordResetToken passwordResetToken = getPasswordResetToken(token);
        User user = passwordResetToken.getUser();
        if (user == null) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(passwordDto.getPassword()));
        updateUser(user);
        deletePasswordResetToken(passwordResetToken.getId());
        return true;
    }

    @Override
    public void updatePasswordAuthorizedUser(String newPassword) {
        User authenticatedUser = getAuthenticatedUser();
        authenticatedUser.setPassword(passwordEncoder.encode(newPassword));
        updateUser(authenticatedUser);
    }

    @Override
    public void deleteConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.delete(token);
    }

    @Override
    public void deletePasswordResetToken(Long id) {
        passwordResetTokenRepository.deleteById(id);
    }

    @Override
    public boolean confirmUser(String confirmationToken) {
        ConfirmationToken token = getConfirmationToken(confirmationToken);
        if (token == null) {
            return false;
        }
        User user = getUserByEmail(token.getUser().getEmail());
        deleteConfirmationToken(token);
        user.setEnabled(true);
        return true;
    }
}
