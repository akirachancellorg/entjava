package com.example.midterm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.NameService;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("parse")
public class ParseController {
    
    @CrossOrigin(origins = "*")
    @GetMapping("/name")
    public ResponseEntity<?> processName(@RequestParam String name) {
        NameService nameService = new ConcreteNameService();
        try {
            return ResponseEntity.ok(nameService.process(name));
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("name", name);
            errorResponse.put("error", "supplied name can't be parsed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}