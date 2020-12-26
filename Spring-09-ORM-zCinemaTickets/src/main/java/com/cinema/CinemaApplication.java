package com.cinema;

import com.cinema.repositories.AccountRepository;
import com.cinema.repositories.MovieCinemaRepository;
import com.cinema.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaApplication {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MovieCinemaRepository movieCinemaRepository;

    @Autowired
    TicketRepository tr;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @PostConstruct
    public void test() {
        System.out.println(accountRepository.getAllAdmins());
        System.out.println(movieCinemaRepository.getAllMovieCinemasByLocationName("AMC Empire 25"));
        System.out.println(tr.getListOfTicketWithSpecificPattern("The").size());
        System.out.println(tr.getListOfTicketWithSpecificPattern("The"));
    }

}
