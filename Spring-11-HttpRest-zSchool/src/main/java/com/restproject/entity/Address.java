package com.restproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restproject.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String city;
    private String country;
    private Integer currentTemperature;
    private String postalCode;
    private String state;
    private String Street;

//    @OneToOne(mappedBy = "address")
//    @JsonBackReference
//    private Student student;

//    @OneToOne(mappedBy = "address")
//    @JsonIgnore
//    private Parent parent;

//    @OneToOne(mappedBy = "address")
//    @JsonBackReference
//    private Teacher teacher;

    private Integer getCurrentTemperature (){
        return this.consumeTemp(this.city);
    }

    private Integer consumeTemp(String city) {
        return 5;
    }

}
