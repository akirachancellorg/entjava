package service;

import dto.Email;
import org.springframework.stereotype.Service;;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public boolean validate(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid email input");
        }

        // Trim and normalize multiple spaces
        email = email.trim().replaceAll("\\s+", " ");

        // Split the email into parts
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Email must have exactly one '@' symbol");
        }

        // Check for valid domain
        String domain = parts[1];
        if (domain == null || domain.trim().isEmpty()) {
            throw new IllegalArgumentException("Email domain cannot be empty");
        }

        // Check for valid top-level domain
        String[] domainParts = domain.split("\\.");
        if (domainParts.length < 2) {
            throw new IllegalArgumentException("Email domain must have at least two parts");
        }

        return true;
    }
}