package com.ticketsproject.convertor;

import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.servises.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConvertor implements Converter<String, UserDTO> {

    UserService userService;

    public UserDtoConvertor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}
