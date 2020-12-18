package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cinemaHalls")
@NoArgsConstructor
@Getter
@Setter
public class CinemaHall extends BaseEntity {
    private String name;
    private String sponsoredName;

    public CinemaHall(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "cinemaHall", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<MovieCinema> movieCinemaList;
}
