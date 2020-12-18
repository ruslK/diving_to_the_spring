package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
@Setter
public class Location extends BaseEntity {

    private String name;
    private String latitude;
    private String longitude;

    public Location(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "location", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<CinemaHall> cinemaHall;
}
