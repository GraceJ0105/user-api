package com.skybettingandgaming.user.api;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ValidationService {

    public boolean checkEmail(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean checkPassword(String password){
        return password.matches("^[A-Za-z0-9]{8}$");
    }

    public boolean checkDateOfBirth(LocalDate dateOfBirth){
        return dateOfBirth.isBefore(LocalDate.now().minusYears(18));
    }
}
