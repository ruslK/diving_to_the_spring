package com.jackson.repositories;

import com.jackson.entities.Movie;
import com.jackson.enums.MovieState;
import com.jackson.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //Write a derived query to read a movie with a name
    Movie findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(Integer in1, Integer in2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<BigDecimal> durations);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);


    // ------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between :p1 and :p2")
    List<Movie> listOfMovieInRagePrice(Integer p1, Integer p2);

    //Write a JPQL query that returns all movie names
    @Query("select m.name from Movie m")
    List<String> getAllMovieNames();

// ------------------- Native QUERIES ------------------- //
    //Write a native query that returns a movie by name
    @Query(value = "select * from movies where name = :name", nativeQuery = true)
    Movie getMovieByName (String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from movies where price between :p1 and :p2", nativeQuery = true)
    List<Movie> getListOfMovieInPriceRange(Integer p1, Integer p2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from movies where duration IN :d1 and :d2", nativeQuery = true)
    List<Movie> getMoviesInDurationRange (BigDecimal d1, BigDecimal d2);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select * from movies order by price DESC LIMIT 5", nativeQuery = true)
    List<Movie> getFiveTopExpensiveMovies();


}
