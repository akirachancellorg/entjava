package com.example.midterm;

import dto.Name;
import java.util.Objects;

import org.springframework.stereotype.Component;
import service.NameService;

@Component
public class ConcreteNameService implements NameService {
    @Override
    public Name process(String name) throws Exception {

        // Clean up extra spaces
        name = name.trim().replaceAll("\\s+", " ");

        // Handle the format "First Last"
        String[] parts = name.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];


        // Handles the format "Last, First"
        if (name.contains(",")) {
            parts = name.split(",");
            lastName = parts[0].trim();
            firstName = parts[1].trim();
            return new Name(firstName, lastName);
        }

        return new Name(firstName, lastName);
    }
}
