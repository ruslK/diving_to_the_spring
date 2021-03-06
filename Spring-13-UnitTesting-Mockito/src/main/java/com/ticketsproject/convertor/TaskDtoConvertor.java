package com.ticketsproject.convertor;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.servises.TaskService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDtoConvertor implements Converter<Long, TaskDTO> {

    TaskService taskService;

    public TaskDtoConvertor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDTO convert(Long id) {
        return taskService.findTaskById(id);
    }
}
