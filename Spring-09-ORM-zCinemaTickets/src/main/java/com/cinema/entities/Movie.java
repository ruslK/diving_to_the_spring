package com.cinema.entities;

import com.cinema.enums.State;
import com.cinema.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    private String name;
    private Double price;
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate releaseDate;

    private int duration;
    private String summary;

    public Movie(String name, Double price, Type type, State state, LocalDate releaseDate, int duration, String summary) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.state = state;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.summary = summary;
    }

    @OneToMany(mappedBy = "movie", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<MovieCinema> movieCinema;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre_rel",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Set<Genre> genreSet = new HashSet<>();

}
