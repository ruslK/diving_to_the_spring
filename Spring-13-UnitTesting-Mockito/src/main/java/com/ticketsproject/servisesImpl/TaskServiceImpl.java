package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.entities.Project;
import com.ticketsproject.entities.Task;
import com.ticketsproject.entities.User;
import com.ticketsproject.enums.Status;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.TaskRepository;
import com.ticketsproject.repository.UserRepository;
import com.ticketsproject.servises.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final MapperUtil mapperUtil;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(MapperUtil mapperUtil, TaskRepository taskRepository,
                           UserRepository userRepository) {
        this.mapperUtil = mapperUtil;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO findTaskById(Long id) {
        return mapperUtil.convert(
                taskRepository.findById(id).get(), new TaskDTO());
    }

    @Override
    public List<TaskDTO> listOfTasks() {
        return taskRepository.findAll(Sort.by("id"))
                .stream()
                .map(task -> mapperUtil.convert(task, new TaskDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO dto) {
        Task taskFomUI = mapperUtil.convert(dto, new Task());
        if (dto.getId() == null) {
            taskFomUI.setAssignedDate(LocalDate.now());
            taskFomUI.setStatus(Status.OPEN);
        } else {
            Task task = taskRepository.findById(taskFomUI.getId()).get();
            if (taskFomUI.getStatus() == null) {
                taskFomUI.setStatus(task.getStatus());
            }
            taskFomUI.setLastUpdateDate(LocalDate.now());
            taskFomUI.setAssignedDate(task.getAssignedDate());
        }
        taskRepository.save(taskFomUI);
    }

    @Override
    public void deleteByID(Long id) {
        Task task = taskRepository.findById(id).get();
        task.setIsDeleted(true);
        taskRepository.save(task);
    }

    @Override
    public int totalNonCompletedTask(String projectCode) {
        return taskRepository.totalNonCompletedTask(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTask(projectCode);
    }

    @Override
    public void deleteByProject(Project project) {
        List<TaskDTO> tasks = taskRepository.findAllByProjectProjectCode(project.getProjectCode())
                .stream().map(task -> mapperUtil.convert(task, new TaskDTO())).collect(Collectors.toList());
        for (TaskDTO t : tasks) this.deleteByID(t.getId());
    }

    @Override
    public List<TaskDTO> listAllTaskByStatusIsNot(Status status) {
        User user = userRepository.findByUserName("migibomyvy");
        List<Task> list = taskRepository.findAllByStatusIsNotAndAssignedEmployee(status, user);
        return list.stream().map(task -> mapperUtil.convert(task, new TaskDTO())).collect(Collectors.toList());
    }


    @Override
    public List<TaskDTO> listAllTaskByProjectManager() {
        User user = userRepository.findByUserName("ruslan@kasymov");
        List<Task> tasks = taskRepository.findAllByProjectAssignedManager(user);
        return tasks.stream().map(task -> mapperUtil.convert(task, new TaskDTO())).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTaskByStatus(Status status) {
        User user = userRepository.findByUserName("migibomyvy");
        List<Task> list = taskRepository.findAllByStatusIsAndAssignedEmployee(status, user);
        return list.stream().map(task -> mapperUtil.convert(task, new TaskDTO())).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getAllTaskByEmployee(User user) {
        return taskRepository.findAllByAssignedEmployee(user)
                .stream().map(task -> mapperUtil.convert(task, new TaskDTO())).collect(Collectors.toList());
    }
}
