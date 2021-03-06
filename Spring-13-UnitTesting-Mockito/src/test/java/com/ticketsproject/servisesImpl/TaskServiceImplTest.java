package com.ticketsproject.servisesImpl;

import com.ticketsproject.dto.TaskDTO;
import com.ticketsproject.entities.Task;
import com.ticketsproject.mapper.MapperUtil;
import com.ticketsproject.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById() {

        Task task = new Task();

        when(taskRepository.findById(2L)).thenReturn(Optional.of(task));
        when(mapperUtil.convert(any(),any())).thenReturn(any());

        taskService.findTaskById(2L);

        verify(taskRepository).findById(2L);
    }

    @Test
    void findById_BDD_Test() {
        // given
        Task task = new Task();
        given(taskRepository.findById(Mockito.anyLong())).willReturn(Optional.of(task));
        given(mapperUtil.convert(any(), any())).willReturn(any());
        // when
        taskService.findTaskById(Mockito.anyLong());
        // then
        then(taskRepository).should().findById(Mockito.anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }
}