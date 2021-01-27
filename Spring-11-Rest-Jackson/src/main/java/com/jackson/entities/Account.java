package com.jackson.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jackson.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = {"state", "postalCode", "age"}, ignoreUnknown = true)
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @Enumerated(value = EnumType.STRING)
    private Roles role = Roles.USER;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, Roles role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
