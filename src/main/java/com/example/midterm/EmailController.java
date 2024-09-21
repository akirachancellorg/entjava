package com.example.midterm;

import dto.Email;
import service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email/{email}")
    public boolean validateEmail(@PathVariable String email) throws Exception {
        return emailService.validate(email);
    }

    @PostMapping("/process")
    public boolean processEmail(@RequestBody Map<String, String> request) throws Exception {
        String emailInput = request.get("email");
        return emailService.validate(emailInput);
    }
}
