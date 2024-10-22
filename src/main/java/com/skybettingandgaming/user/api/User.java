package com.skybettingandgaming.user.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    private String email;
    private String password;
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        return "User {" +
                "Email: '" + email + '\'' +
                ", Password: " + password +
                ", Date of Birth: '" + dateOfBirth + '\'' +
                '}';
    }

}
