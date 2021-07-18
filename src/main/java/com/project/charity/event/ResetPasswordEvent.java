package com.project.charity.event;

import com.project.charity.domain.User;
import lombok.Getter;


@Getter
public class ResetPasswordEvent {

    private final String appUrl;
    private final User user;

    public ResetPasswordEvent(final User user, final String appUrl) {
        this.user = user;
        this.appUrl = appUrl;
    }
}
