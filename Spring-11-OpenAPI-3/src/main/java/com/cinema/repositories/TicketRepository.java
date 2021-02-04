package com.cinema.repositories;

import com.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to count how many tickets a user bought
    Integer countAllByUserId(Long id);

    //Write a derived query to list all tickets by specific email
    Optional<Ticket> findAllByUserEmail(String userEmail);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String movieName);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByLocalDateTimeBetween(LocalDateTime d1, LocalDateTime d2);


    // ------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.user.id = :id")
    List<Ticket> getListOfMovieForUser(Long id);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.localDateTime between :d1 and :d2")
    List<Ticket> getTicketsByDateRange(LocalDateTime d1, LocalDateTime d2);

    // -------------------
    // QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from tickets where user_id = :id", nativeQuery = true)
    Integer countBoughtTicketsByUserID (Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*) from tickets where user_id = :id and local_date_time between :d1 and :d2", nativeQuery = true)
    Integer countBoughtTicketInDateRange (Long id, LocalDateTime d1, LocalDateTime d2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "select distinct(m.name) from tickets " +
            "JOIN movie_cinemas mc on mc.id = tickets.move_cinema_id " +
            "JOIN movies m on mc.movie_id = m.id " +
            "where m.name = :movieName", nativeQuery = true)
    List<String> getTicketForMovie(String movieName);

    //Write a native query to find all tickets by user email
    @Query(value = "select * from tickets t " +
            "JOIN user_accounts ua on t.user_id = ua.id " +
            "where ua.email = :email", nativeQuery = true)
    List<Ticket> getAllTicketByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "select * from tickets", nativeQuery = true)
    List<Ticket> getAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "select * from tickets " +
            "JOIN movie_cinemas mc on mc.id = tickets.move_cinema_id " +
            "JOIN movies m on mc.movie_id = m.id " +
            "JOIN user_accounts ua on tickets.user_id = ua.id " +
            "JOIN account_details ad on ua.account_detail_id = ad.id " +
            "where ua.username ILIKE concat('%', :pattern, '%')" +
            "OR ad.name ILIKE concat('%', :pattern, '%')" +
            "OR m.name ILIKE concat('%', :pattern, '%')", nativeQuery = true)
    List<Ticket> getListOfTicketWithSpecificPattern(String pattern);
}
