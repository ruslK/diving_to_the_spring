package com.cinema.entities;

import com.cinema.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "userAccounts")
@NoArgsConstructor
@Getter
@Setter
public class UserAccount extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String city;
    private int postalCode;

    @Enumerated(value = EnumType.STRING)
    private Roles role;

    public UserAccount(String name, String address, String country, String city, @Max(5) int postalCode, Roles role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.role = role;
    }

    @OneToOne(mappedBy = "userAccount", fetch = FetchType.LAZY)
    private User user;
}
