package com.example.midterm;
import dto.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import service.EmailService;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class EmailValidationControllerTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void emailTest() throws Exception {
        assertEquals("chancellor.galiza@upd.edu.ph", new Email("chancellor.galiza@upd.edu.ph"), emailService.process("chancellor.galiza@upd.edu.ph"));
    }


}
