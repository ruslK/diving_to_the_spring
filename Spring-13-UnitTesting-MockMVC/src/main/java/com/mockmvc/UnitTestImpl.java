package com.mockmvc;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;


@NoArgsConstructor
public class UnitTestImpl {

    DataRepository dataRepository;

    public UnitTestImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public int calculateSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public int calculateSumDataService() {
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumDataServiceWithParameter() {
        return Arrays.stream(dataRepository.findById(2)).sum();
    }
}
