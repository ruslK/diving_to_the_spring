package com.jackson.repositories;


import com.jackson.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query that return all genres
    @Query("select g from Genre g")
    List<Genre> getAllGenres();

    // ------------------- Native QUERIES ------------------- //
    //Write a native query that returns genres by containing name
    @Query(value = "select * from genres where name ILIKE concat('%', :pattern, '%')", nativeQuery = true)
    List<Genre> genresByName(String pattern);
}
