package com.restproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restproject.enums.EducationLevel;
import com.restproject.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teacher")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher extends BaseEntity {
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    private String email;
    private String firstName;
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String username;

//        @OneToOne (cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;
}
