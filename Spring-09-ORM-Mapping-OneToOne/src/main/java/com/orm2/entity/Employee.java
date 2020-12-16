package com.orm2.entity;

import com.orm2.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee extends BaseEntity {

    private String firstName;
    private String latName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private Region region;

    public Employee(String firstName, String latName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.latName = latName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
