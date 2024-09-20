package service;

import dto.Name;
import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {

    @Override
    public Name process(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name input");
        }

        // Trim and normalize multiple spaces
        name = name.trim().replaceAll("\\s+", " ");

        // Split the name into parts
        String[] parts = name.split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Name must have at least two parts");
        }

        // Capitalize first and last names correctly
        String first = capitalize(parts[0]);
        String last = capitalize(parts[parts.length - 1]);

        return new Name();
    }

    // Helper method to capitalize only the first letter of a name
    private String capitalize(String namePart) {
        if (namePart == null || namePart.isEmpty()) {
            return namePart;
        }
        return namePart.substring(0, 1).toUpperCase() + namePart.substring(1).toLowerCase();
    }
}
