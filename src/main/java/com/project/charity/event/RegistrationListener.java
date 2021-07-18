package com.project.charity.event;

import com.project.charity.component.MessageComponent;
import com.project.charity.domain.ConfirmationToken;
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
public class RegistrationListener {

    private final UserService userService;
    private final EmailService emailService;
    private final MessageComponent message;

    @EventListener
    public void handleEvent(RegistrationEvent event) {
        User user = event.getUser();
        ConfirmationToken token = userService.createConfirmationTokenForUser(user);
        String confirmationUrl = event.getAppUrl() + "/confirm-account?token=" + token.getToken();
        emailService.send(
                user.getEmail(),
                message.getMessage("email.subject.regSucc"),
                message.getMessage("email.message.regSucc"),
                confirmationUrl
        );
    }
}