package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.ProjectDTO;
import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.entities.Project;
import com.ticketsproject.entities.User;
import com.ticketsproject.enums.Status;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.ProjectRepository;
import com.ticketsproject.servises.ProjectService;
import com.ticketsproject.servises.TaskService;
import com.ticketsproject.servises.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserService userService;
    private final TaskService taskService;
    private final MapperUtil mapper;


    public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService,
                              TaskService taskService, MapperUtil mapper) {
        this.projectRepository = projectRepository;
        this.userService = userService;
        this.taskService = taskService;
        this.mapper = mapper;
    }

    @Override
    public List<ProjectDTO> listOfProjects() {
        return projectRepository.findAll(Sort.by("projectCode"))
                .stream()
                .map(project -> mapper.convert(project, new ProjectDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {
        Project project = projectRepository.findAllByProjectCode(dto.getProjectCode());

        if (project != null) {
            Long id = project.getId();
            Project updatedProject = mapper.convert(dto, new Project());
            updatedProject.setProjectStatus(project.getProjectStatus());
            updatedProject.setId(id);
            projectRepository.save(updatedProject);
        } else {
            Project project1 = mapper.convert(dto, new Project());
            project1.setProjectStatus(Status.OPEN);
            projectRepository.save(project1);
        }
    }

    @Override
    public void deleteByProjectCode(String projectCode) {
        Project project = projectRepository.findAllByProjectCode(projectCode);
        project.setIsDeleted(true);
        project.setProjectCode(project.getProjectCode() + "-" + project.getId());
        projectRepository.save(project);

        taskService.deleteByProject(project);
    }

    @Override
    public ProjectDTO findByProjectCode(String projectCode) {
        return mapper.convert(projectRepository.findAllByProjectCode(projectCode), new ProjectDTO());
    }

    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findAllByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> getAllProjectByManagerId() {
        UserDTO manager = userService.findByUserName("ruslan@kasymov");
        return projectRepository.findAllByManagerId(manager.getId()).stream()
                .map(project -> {
                    ProjectDTO obj = mapper.convert(project, new ProjectDTO());
                    obj.setCompleteCount(taskService.totalCompletedTask(obj.getProjectCode()));
                    obj.setInCompleteCount(taskService.totalNonCompletedTask(obj.getProjectCode()));
                    return obj;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> listOfProjectsNonComplete() {
        return projectRepository.findAllByProjectStatusIsNot(Status.COMPLETE)
                .stream().map(project -> mapper.convert(project, new ProjectDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getAllByAssignedManager(User user) {
        return projectRepository.findAllByManagerId(user.getId())
                .stream().map(project -> mapper.convert(project, new ProjectDTO())).collect(Collectors.toList());
    }
}
