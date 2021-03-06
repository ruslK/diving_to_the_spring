package com.ticketsproject.servises;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.entities.Project;
import com.ticketsproject.entities.User;
import com.ticketsproject.enums.Status;

import java.util.List;

public interface TaskService {

    TaskDTO findTaskById (Long id);

    void deleteByID (Long id);

    List<TaskDTO> listOfTasks();

    void save(TaskDTO dto);

    int totalNonCompletedTask(String projectCode);

    int totalCompletedTask(String projectCode);

    void deleteByProject(Project project);

    List<TaskDTO> listAllTaskByStatusIsNot(Status status);

    List<TaskDTO> listAllTaskByProjectManager();

    List<TaskDTO> listAllTaskByStatus(Status status);

    List<TaskDTO> getAllTaskByEmployee(User user);
}
