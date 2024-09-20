package com.example.midterm;

import dto.Name; // Import your Name DTO
import service.NameService; // Import your NameService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NameController {

    @Autowired
    private NameService nameService;

    // Serve the main HTML page
    @GetMapping("/")
    public String index() {
        return "index"; // This will serve the index.html file from static resources
    }

    // Process the name input from the frontend
    @PostMapping("/process")
    public Name processName(@RequestBody Map<String, String> request) throws Exception {
        String nameInput = request.get("name");
        return nameService.process(nameInput);
    }
}
