package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@Getter
@Setter
public class Ticket extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;
    private Integer rowNumber;
    private Integer seatNumber;

    public Ticket(int rowNumber, int seatNumber, LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_cinema_id")
    private MovieCinema movieCinema;
}
