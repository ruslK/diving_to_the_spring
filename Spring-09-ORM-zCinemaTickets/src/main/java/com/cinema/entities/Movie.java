package com.cinema.entities;

import com.cinema.enums.MovieState;
import com.cinema.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    private String name;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private BigDecimal duration;
    @Column(columnDefinition = "text")
    private String summary;

    public Movie(String name, LocalDate releaseDate, Integer price, MovieType type, MovieState state, BigDecimal duration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }


    @ManyToMany
    @JoinTable(name = "movies_genres_rel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreSet = new ArrayList<>();

}
