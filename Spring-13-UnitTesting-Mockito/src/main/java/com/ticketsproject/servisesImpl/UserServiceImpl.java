package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.ProjectDTO;
import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.dto.UserDTO;
import com.ticketsproject.entities.User;
import com.ticketsproject.exception.TicketingProjectException;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.UserRepository;
import com.ticketsproject.servises.ProjectService;
import com.ticketsproject.servises.TaskService;
import com.ticketsproject.servises.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;
    private final TaskService taskService;
    private final ProjectService projectService;


    public UserServiceImpl(UserRepository userRepository,
                           MapperUtil mapperUtil, TaskService taskService,
                           @Lazy ProjectService projectService) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        return userRepository.findAll(Sort.by("firstName")).stream()
                .map(obj -> mapperUtil.convert(obj, new UserDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return mapperUtil.convert(userRepository.findByUserName(username), new UserDTO());
    }

    @Override
    public void save(UserDTO dto) {
        User user = userRepository.findByUserName(dto.getUserName());
        if (user != null) {
            Long id = user.getId();
            User updatedUser = mapperUtil.convert(dto, new User());
            updatedUser.setId(id);
            userRepository.save(updatedUser);
        } else {
            userRepository.save(mapperUtil.convert(dto, new User()));
        }
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(String username) throws TicketingProjectException {
        User user = userRepository.findByUserName(username);

        if (user == null) {
            throw new TicketingProjectException("User " + username + " does not Exists in the DB");
        }

        if (!checkIfUserCanBeDelete(user)) {
            throw new TicketingProjectException("User " + username + " can not be delete from UI, " +
                    "It is linked projects or tasks");
        }
        user.setUserName(user.getUserName() + "-" + user.getId());
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username);
    }

    @Override
    public List<UserDTO> findAllManagers() {
        return userRepository.listOfManagers().stream()
                .map(obj -> mapperUtil.convert(obj, new UserDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return userRepository.listOfEmployees().stream()
                .map(obj -> mapperUtil.convert(obj, new UserDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean checkIfUserCanBeDelete(User user) {
        switch (user.getRole().getDescription()) {
            case "Manager":
                List<ProjectDTO> projectDTOS = projectService.getAllByAssignedManager(user);
                return projectDTOS.size() == 0;
            case "Employee":
                List<TaskDTO> tasks = taskService.getAllTaskByEmployee(user);
                return tasks.size() == 0;
            default:
                return true;
        }
    }
}
