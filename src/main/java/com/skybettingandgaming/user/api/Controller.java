package com.skybettingandgaming.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin(origins = "http://localhost:*")
public class Controller {

    @Autowired
    private final ValidationService validationService;

    @PostMapping("/register")
    public ResponseEntity<String> getUserDetails(@RequestBody User user){
        User newUser =  new User();
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setDateOfBirth(user.getDateOfBirth());

        System.out.println(validationService.checkEmail(newUser.getEmail()));
        System.out.println(validationService.checkPassword(newUser.getPassword()));
        System.out.println(validationService.checkDateOfBirth(newUser.getDateOfBirth()));
        System.out.println(newUser.toString());

        if (validationService.checkEmail(newUser.getEmail()) && validationService.checkPassword(newUser.getPassword()) && validationService.checkDateOfBirth(newUser.getDateOfBirth())) {
            return ResponseEntity.ok("Registration successful");
        }
        if (!validationService.checkEmail(newUser.getEmail())) {
            return ResponseEntity.badRequest().body("Please provide a valid email address"); }

        if (!validationService.checkPassword(newUser.getPassword())) {
            return ResponseEntity.badRequest().body("Please provide a valid password");
        }
        if (!validationService.checkDateOfBirth(newUser.getDateOfBirth())) {
            return ResponseEntity.badRequest().body("You must be at least 18 years old");
        }

        return ResponseEntity.badRequest().body("User details not correct");

    }

}


