package com.ticketsproject.dto;

import com.ticketsproject.enums.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String password;
    private boolean enabled;
    private Gender gender;
    private RoleDTO role;
}
