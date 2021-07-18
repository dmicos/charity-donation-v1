package com.project.charity.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Slf4j
@Component
public class MessageComponent {

    private MessageSource messageSource;
    private MessageSourceAccessor accessor;
    private Locale locale;


    public MessageComponent(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    private void initialize() {
        accessor = new MessageSourceAccessor(messageSource, locale);
    }

    public String getMessage(String key) {
        return accessor.getMessage(key);
    }

    public String getMessage(String key, String[] params) {
        return accessor.getMessage(key, params);
    }
}
