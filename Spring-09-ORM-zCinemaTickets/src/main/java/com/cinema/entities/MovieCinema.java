package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "movieCinemas")
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    public MovieCinema(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @OneToMany(mappedBy = "movieCinema", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
