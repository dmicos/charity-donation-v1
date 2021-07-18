package com.project.charity.service;

import com.project.charity.dto.EmailDto;

public interface EmailService {
    void send(String addressTo, String subject, String msg, String tokenUrl);

    void sendUs(EmailDto emailDto);
}
