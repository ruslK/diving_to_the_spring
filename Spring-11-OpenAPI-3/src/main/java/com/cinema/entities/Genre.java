package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@Getter
@Setter
public class Genre extends BaseEntity {
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "genreSet")
    private List<Movie> movieSet = new ArrayList<>();
}
