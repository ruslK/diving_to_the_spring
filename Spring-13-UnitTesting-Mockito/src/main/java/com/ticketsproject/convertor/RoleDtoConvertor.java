package com.ticketsproject.convertor;

import com.ticketsproject.dto.RoleDTO;
import com.ticketsproject.servises.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConvertor implements Converter<String, RoleDTO> {

    RoleService roleService;

    public RoleDtoConvertor(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        Integer id =Integer.parseInt(source);
        return roleService.findById(Long.parseLong(source));
    }
}
