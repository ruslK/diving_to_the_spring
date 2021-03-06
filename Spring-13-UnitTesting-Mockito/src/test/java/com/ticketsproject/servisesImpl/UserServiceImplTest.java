package com.ticketsproject.servisesImpl;

import com.ticketsproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @Test
    void deleteByUserName() {
        userService.deleteByUserName("test@test.com");

        // Verification
//        verify(userRepository).deleteByUserName("test@test.com");
        verify(userRepository, times(1)).deleteByUserName("test@test.com");
        verify(userRepository, atLeastOnce()).deleteByUserName("test@test.com");
        verify(userRepository, atMostOnce()).deleteByUserName("test@test.com");
    }
}