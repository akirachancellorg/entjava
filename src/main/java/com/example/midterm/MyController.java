package com.example.midterm;

import dto.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import utility.ValidateEmail;

import java.util.regex.Pattern;

@RestController
@RequestMapping("validate")
public class MyController {

    @GetMapping("/email/{email}")
    public boolean validateEmail(@PathVariable String email) {
//        Validate Email with ValidateEmail Utility
        return ValidateEmail.isValidEmail(email);
    }
    @Autowired
    private ConcreteNameService nameService;
    @GetMapping("/name/{name}")
    public Name processName(@PathVariable String name) throws Exception {
        // Use the ConcreteNameService to handle name processing
        return nameService.process(name);
    }


}
