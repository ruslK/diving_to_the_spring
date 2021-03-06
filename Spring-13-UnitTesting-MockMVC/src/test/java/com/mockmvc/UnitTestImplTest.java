package com.mockmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitTestImplTest {

    @Mock
    DataRepository dataRepository;


    @InjectMocks
    UnitTestImpl unitTest;


    @Test
    void calculateSum() {
        int[] arr = {1, 2, 3, 4};
        int actual = unitTest.calculateSum(arr);
        assertEquals(10, actual);
    }


    @Test
    void calculateSumUsingDataService() {
        when(dataRepository.findAll()).thenReturn(new int[]{1, 1, 1});
        int actual = unitTest.calculateSumDataService();
        assertEquals(3, actual);
    }


    @Test
    void calculateSumDataServiceWithParameter() {
        when(dataRepository.findById(anyInt())).thenReturn(new int[]{1, 2, 3});
        int actual = unitTest.calculateSumDataServiceWithParameter();
        assertEquals(6, actual);
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                arguments(5, new int[] {1, 1, 3}),
                arguments(10, new int[] {5, 2, 3}),
                arguments(6, new int[] {1, 2, 3}),
                arguments(0, new int[] {0, 0, 0}),
                arguments(-1, new int[] {0, -1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    void calculateSumDataServiceWithParameter(int res, int[] arr) {
        when(dataRepository.findById(anyInt())).thenReturn(arr);
        int actual = unitTest.calculateSumDataServiceWithParameter();
        assertEquals(res, actual);
        verify(dataRepository, times(1)).findById(anyInt());
    }
}