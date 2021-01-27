package com.jackson.repositories;

import com.jackson.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    // Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);


    // ------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id = :id")
    String cinemaName(Integer id);

    // ------------------- Native QUERIES ------------------- //
    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinemas c JOIN locations l on c.location_id = l.id where l.country = :country", nativeQuery = true)
    List<Cinema> allCinemasByCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinemas WHERE name ILIKE ('%', :pattern, '%') OR sponsored_name ILIKE concat('%', :pattern, '%')", nativeQuery = true)
    List<Cinema> getAllCinemasBySpecificPattern(String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinemas order by name", nativeQuery = true)
    List<Cinema> getListSortedByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT DISTINCT sponsored_name FROM cinemas", nativeQuery = true)
    List<Cinema> getDistinctBySponsoredName();
}
