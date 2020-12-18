package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "genre", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Movie> movieSet = new HashSet<>();
}
