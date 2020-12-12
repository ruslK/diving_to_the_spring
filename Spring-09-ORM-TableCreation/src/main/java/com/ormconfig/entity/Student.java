package com.ormconfig.entity;

import com.ormconfig.enums.GENDER;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_first_name")
    private String firstName;

    @Column(name = "student_last_name")
    private String lastName;

    @Column(name = "student_email")
    private String email;

    @Transient
    private String city;

    @Column(name = "student_birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @Column(name = "student_birth_time")
    @Temporal(TemporalType.TIME)
    private Date birthTime;

    @Column(name = "student_birth_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;

    @Column(columnDefinition = "TIME")
    private LocalTime localTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private GENDER gender;
}
