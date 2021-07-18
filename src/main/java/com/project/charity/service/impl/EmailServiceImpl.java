package com.project.charity.service.impl;

import com.project.charity.dto.EmailDto;
import com.project.charity.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${value.email.receiving}")
    private String addressToUs;

    @Override
    public void send(String addressTo, String subject, String msg, String tokenUrl) {
        sender(addressTo, subject, msg, tokenUrl);
    }

    @Override
    public void sendUs(EmailDto dto) {
        String addressFrom = dto.getEmail();
        String subject = "From website:" + dto.getSubject();
        String msg = "Email: " + addressFrom + "\n" + "Name: " + dto.getName() + "\n" + dto.getMessage();
        sender(addressToUs, subject, msg, null);
    }

    private void sender(String addressTo, String subject, String msg, String tokenUrl) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(addressTo);
        email.setSubject(subject);
        email.setText(msg + tokenUrl);
        log.info("Email constructed: {}", email);
        mailSender.send(email);
    }
}
