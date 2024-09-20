package com.example.midterm;

import dto.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.NameService;
import utility.NameBuilder;

@Component
public class ConcreteNameService implements NameService {
    @Autowired
    private NameBuilder nameBuilder;

    @Override
    public Name process(String name) throws Exception {
        // Use NameBuilder to split the name into first and last names
        String[] fullName = nameBuilder.process(name);

        // If the name cannot be processed, throw an exception or return an empty object
        if (fullName == null || fullName.length < 2) {
            throw new Exception("Invalid name format");
        }

        // Return the Name object with parsed first and last names
        return new Name(fullName[0], fullName[1]);
    }
}
