package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.ProjectDTO;
import com.ticketsproject.entities.Project;
import com.ticketsproject.exception.TicketingProjectException;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    MapperUtil mapperUtil;
    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectServiceImpl projectService;


    @Test
    void findByProjectCode() {
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findAllByProjectCode("PR01")).thenReturn(project);
//        when(mapperUtil.convert(project, new ProjectDTO())).thenReturn(projectDTO);

        ProjectDTO projectDTO1 = projectService.findByProjectCode("PR01");

        verify(projectRepository).findAllByProjectCode(Mockito.anyString());
        verify(mapperUtil).convert(Mockito.any(Project.class), new ProjectDTO());

        assertNotNull(projectDTO1);
    }

    @Test
    void findByProjectCodeExceptionTest() {
        when(projectRepository.findAllByProjectCode("")).thenThrow(new RuntimeException("Project now found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.findByProjectCode(""));

        verify(projectRepository).findAllByProjectCode(Mockito.anyString());
        assertEquals(exception.getMessage(), "Project now found");
    }

    @Test
    void save() {
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

//        when(projectRepository.findAllByProjectCode(projectDTO.getProjectCode())).thenReturn(project);
        when(mapperUtil.convert(projectDTO, new Project())).thenReturn(project);
//        when(mapperUtil.convert(project, new ProjectDTO())).thenReturn(projectDTO);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
    }
}