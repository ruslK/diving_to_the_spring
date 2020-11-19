package com.forms.model;

import com.forms.datagenerator.DataGenerator;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private String dob;
    private long age;
    private String email;
    private String password;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

    public long getAge() {
        LocalDate dd = LocalDate.parse(dob);
        LocalDate cd = LocalDate.now();
        this.age = cd.getYear() - dd.getYear();
        return age;
    }

    public String getStateName() {
        return DataGenerator.mapOfUSStates.get(this.state);
    }
}
