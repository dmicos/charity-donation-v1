package com.project.charity.event;

import com.project.charity.component.MessageComponent;
import com.project.charity.domain.PasswordResetToken;
import com.project.charity.domain.User;
import com.project.charity.service.EmailService;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ResetPasswordListener {

    private final UserService userService;
    private final EmailService emailService;
    private final MessageComponent message;

    @EventListener
    public void handleEvent(ResetPasswordEvent event) {
        User user = event.getUser();
        PasswordResetToken token = userService.createPasswordResetTokenForUser(user);
        String passwordResetUrl = event.getAppUrl() + "/change-password?token=" + token.getToken();
        emailService.send(
                user.getEmail(),
                message.getMessage("email.subject.resPass"),
                message.getMessage("email.message.resPass"),
                passwordResetUrl
        );
    }
}