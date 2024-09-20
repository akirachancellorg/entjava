package com.example.midterm;

import dto.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.NameService;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
class MidtermApplicationTests {

    @Autowired
    private NameService nameService;

    @Test
    public void simple() throws Exception {

        assertEquals("APC User", new Name("APC", "User"), nameService.process("APC User"));
        assertEquals("User, APC", new Name("APC", "User"), nameService.process("User, APC"));
        assertEquals("APC     User", new Name("APC", "User"), nameService.process(" APC     User "));
    }

    @Test
    public void surname() throws Exception {
        // With Prefix Surname
        assertEquals("APC John Del User", new Name("APC", "Del User"),
                nameService.process("APC John Del User"));
    }

    @Test
    public void remove() throws Exception {
        assertEquals("Csar APC User", new Name("APC", "User"), nameService.process("Csar APC User"));
        assertEquals("Dr APC User", new Name("APC", "User"), nameService.process("Dr APC User"));
        assertEquals("D.R. APC User", new Name("APC", "User"), nameService.process("D.R. APC User"));
        assertEquals("Rev. APC User", new Name("APC", "User"), nameService.process("Rev. APC User"));
        assertEquals("APC (John) User", new Name("APC", "User"),
                nameService.process("APC (John) User"));
        assertEquals("APC \"Rambo\" User", new Name("APC", "User"),
                nameService.process("APC \"Rambo\" User"));
        assertEquals("APC 'Rambo' User", new Name("APC", "User"),
                nameService.process("APC 'Rambo' User"));
        assertEquals("APC User a.k.a The Terminator", new Name("APC", "User"),
                nameService.process("APC User a.k.a The Terminator"));
        assertEquals("APC User M.B.A.", new Name("APC", "User"),
                nameService.process("APC User M.BA."));
        assertEquals("APC J. R. User", new Name("APC", "User"),
                nameService.process("APC J. R. User"));
        assertEquals("APC User, Bsc", new Name("APC", "User"), nameService.process("APC User, Bsc"));
        assertEquals("APC User - Bsc", new Name("APC", "User"),
                nameService.process("APC User - Bsc"));
        assertEquals("APC User | Bsc", new Name("APC", "User"),
                nameService.process("APC User | Bsc"));
        assertEquals("~~ ~APC User ~~~", new Name("APC", "User"),
                nameService.process("~~~ APC User ~~~"));
        assertEquals("APC User Certified Professional", new Name("APC", "User"),
                nameService.process("APC User Certified Professional"));
        assertEquals("APC User 99", new Name("APC", "User"), nameService.process("APC User 99"));
    }

    @Test
    public void replace() throws Exception {
        assertEquals("APC User II.", new Name("APC", "User"), nameService.process("APC User II."));
        assertEquals("APC User Jr.", new Name("APC", "User"), nameService.process("APC User Jr."));
    }

    @Test
    public void suffix() throws Exception {
        assertEquals("APC User Dip Ed", new Name("APC", "User"),
                nameService.process("APC User Dip Ed"));
        assertEquals("APC User DipEd", new Name("APC", "User"),
                nameService.process("APC User DipEd"));
        assertEquals("APC R User MSc MPH DRes/PhD", new Name("APC", "User"),
                nameService.process("APC R User MSc MPH DRes/PhD"));
        assertEquals("APC User Phd", new Name("APC", "User"), nameService.process("APC User Phd"));
        assertEquals("APC User MacA", new Name("APC", "User"), nameService.process("APC User MacA"));
        assertEquals("APC User assoc prof", new Name("APC", "User"),
                nameService.process("APC User assoc prof"));
    }

    @Test
    public void badNames_Success() throws Exception {
        assertEquals("~~~ APC User ~~~", new Name("APC", "User"),
                nameService.process("~~~ APC User ~~~"));
        assertEquals("~~~ APC J User ~~~", new Name("APC", "User"),
                nameService.process("~~~ APC J User ~~~"));
    }

    @Test
    public void capitalisation() throws Exception {
        assertEquals("HEMANT AHIRKAR", new Name("Hemant", "Ahirkar"), nameService.process("HEMANT AHIRKAR"));
        assertEquals("hemant ahirkar", new Name("Hemant", "Ahirkar"), nameService.process("hemant ahirkar"));
        // Invalid Expected Name
        assertEquals("Hemant deAhirkar", new Name("Hemant", "deAhirkar"),
                nameService.process("Hemant deAhirkar"));
    }

//    @Test
//    public void nonAlpha() throws Exception {
//        assertEquals(new Name("Hemant", "Ahirkar"), nameService.process("'HEMANT AHIRKAR'"));
//        assertEquals(new Name("Hemant", "Ahirkar"), nameService.process("-hemant ahirkar"));
//    }
}