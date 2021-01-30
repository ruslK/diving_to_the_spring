package com.jackson.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernate_Lazy_Initializer"},ignoreUnknown = true)
public class MovieCinema extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public MovieCinema(LocalDateTime dateTime) {
        this.localDateTime = dateTime;
    }

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + localDateTime +
                '}';
    }
}
