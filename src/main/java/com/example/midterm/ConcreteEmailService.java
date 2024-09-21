package com.example.midterm;

import org.springframework.stereotype.Component;
import dto.Email;
import service.EmailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ConcreteEmailService implements EmailService {
    @Override
    public Email process(String email) throws Exception {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        email = matcher.replaceAll(email);
        return new Email(email);
    }
}
