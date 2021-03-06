package com.mockmvc;

import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository {
    int[] findAll();
    int [] findById(int id);
}
