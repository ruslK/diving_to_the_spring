package com.ormoneyomany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "person")
    private List<Address> address;

//    @OneToMany (cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
//    @JoinColumn(name = "person_id")
//    private List<Address> address;
}
