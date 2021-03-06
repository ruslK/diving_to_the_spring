package com.ticketsproject.convertor;

import com.ticketsproject.dto.ProjectDTO;
import com.ticketsproject.servises.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConvertor implements Converter<String, ProjectDTO> {

    ProjectService projectService;

    public ProjectDtoConvertor(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String id) {
        return projectService.findByProjectCode(id);
    }
}
