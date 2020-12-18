package com.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @OneToMany(mappedBy = "user", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private List<Ticket> ticketList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserAccount userAccount;
}
