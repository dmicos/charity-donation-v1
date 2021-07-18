package com.project.charity.mapper;


import com.project.charity.domain.User;
import com.project.charity.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
