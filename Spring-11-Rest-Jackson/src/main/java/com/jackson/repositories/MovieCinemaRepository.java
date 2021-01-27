package com.jackson.repositories;


import com.jackson.entities.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovieId(Integer movieID);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByLocalDateTimeAfter(LocalDateTime date);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderByMoviePrice();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinemaLocationName(String Name);

    //------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query to list all movie cinemas with higher than a specific date
//    @Query("select m from MovieCinema m where m.localDateTime > :locaDateTime")
//    List<MovieCinema> getAllMovieAfterSpecificDate(LocalDateTime localDateTime);


    // ------------------- Native QUERIES ------------------- //
    //Write a native query to count all movie cinemas by cinema id
    @Query (value = "select count(*) from movie_cinemas where cinema_id = :id", nativeQuery = true)
    Integer countAllMoviesByCinemaId (Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinemas mc " +
            "JOIN cinemas c on mc.cinema_id = c.id " +
            "JOIN locations l on c.location_id = l.id " +
            "where c.name = :locationName", nativeQuery = true)
    List<MovieCinema> getAllMovieCinemasByLocationName (String locationName);

}
