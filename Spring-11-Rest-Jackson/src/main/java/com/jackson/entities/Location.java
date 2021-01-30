package com.jackson.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernate_Lazy_Initializer"},ignoreUnknown = true)
public class Location extends BaseEntity {

    private String name;
    private BigDecimal latitude;
    private BigDecimal langitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;

    public Location(String name, BigDecimal latitude, BigDecimal langitude, String postalCode, String country, String state, String city, String address) {
        this.name = name;
        this.latitude = latitude;
        this.langitude = langitude;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
    }
}
