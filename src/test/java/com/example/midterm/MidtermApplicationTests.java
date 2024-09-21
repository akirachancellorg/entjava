package com.example.midterm;

import dto.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;
import service.NameService;


@SpringBootTest
class MidtermApplicationTests {

    @Autowired
    private NameService nameService;

    @Test
    public void simple() throws Exception {

        AssertionErrors.assertEquals("APC User", new Name(), nameService.process("APC User"));
        AssertionErrors.assertEquals("User, APC", new Name(), nameService.process("User, APC"));
        AssertionErrors.assertEquals("APC     User", new Name(), nameService.process(" APC     User "));
    }

    @Test
    public void surname() throws Exception {
        // With Prefix Surname
        AssertionErrors.assertEquals("APC John Del User", new Name(),
                nameService.process("APC John Del User"));
    }

    @Test
    public void remove() throws Exception {
        AssertionErrors.assertEquals("Csar APC User", new Name(), nameService.process("Csar APC User"));
        AssertionErrors.assertEquals("Dr APC User", new Name(), nameService.process("Dr APC User"));
        AssertionErrors.assertEquals("D.R. APC User", new Name(), nameService.process("D.R. APC User"));
        AssertionErrors.assertEquals("Rev. APC User", new Name(), nameService.process("Rev. APC User"));
        AssertionErrors.assertEquals("APC (John) User", new Name(),
                nameService.process("APC (John) User"));
        AssertionErrors.assertEquals("APC \"Rambo\" User", new Name(),
                nameService.process("APC \"Rambo\" User"));
        AssertionErrors.assertEquals("APC 'Rambo' User", new Name(),
                nameService.process("APC 'Rambo' User"));
        AssertionErrors.assertEquals("APC User a.k.a The Terminator", new Name(),
                nameService.process("APC User a.k.a The Terminator"));
        AssertionErrors.assertEquals("APC User M.B.A.", new Name(),
                nameService.process("APC User M.BA."));
        AssertionErrors.assertEquals("APC J. R. User", new Name(),
                nameService.process("APC J. R. User"));
        AssertionErrors.assertEquals("APC User, Bsc", new Name(), nameService.process("APC User, Bsc"));
        AssertionErrors.assertEquals("APC User - Bsc", new Name(),
                nameService.process("APC User - Bsc"));
        AssertionErrors.assertEquals("APC User | Bsc", new Name(),
                nameService.process("APC User | Bsc"));
        AssertionErrors.assertEquals("~~ ~APC User ~~~", new Name(),
                nameService.process("~~~ APC User ~~~"));
        AssertionErrors.assertEquals("APC User Certified Professional", new Name(),
                nameService.process("APC User Certified Professional"));
        AssertionErrors.assertEquals("APC User 99", new Name(), nameService.process("APC User 99"));
    }

    @Test
    public void replace() throws Exception {
        AssertionErrors.assertEquals("APC User II.", new Name(), nameService.process("APC User II."));
        AssertionErrors.assertEquals("APC User Jr.", new Name(), nameService.process("APC User Jr."));
    }

    @Test
    public void suffix() throws Exception {
        AssertionErrors.assertEquals("APC User Dip Ed", new Name(),
                nameService.process("APC User Dip Ed"));
        AssertionErrors.assertEquals("APC User DipEd", new Name(),
                nameService.process("APC User DipEd"));
        AssertionErrors.assertEquals("APC R User MSc MPH DRes/PhD", new Name(),
                nameService.process("APC R User MSc MPH DRes/PhD"));
        AssertionErrors.assertEquals("APC User Phd", new Name(), nameService.process("APC User Phd"));
        AssertionErrors.assertEquals("APC User MacA", new Name(), nameService.process("APC User MacA"));
        AssertionErrors.assertEquals("APC User assoc prof", new Name(),
                nameService.process("APC User assoc prof"));
    }

    @Test
    public void badNames_Success() throws Exception {
        AssertionErrors.assertEquals("~~~ APC User ~~~", new Name(),
                nameService.process("~~~ APC User ~~~"));
        AssertionErrors.assertEquals("~~~ APC J User ~~~", new Name(),
                nameService.process("~~~ APC J User ~~~"));
    }

    @Test
    public void capitalisation() throws Exception {
        AssertionErrors.assertEquals("HEMANT AHIRKAR", new Name(), nameService.process("HEMANT AHIRKAR"));
        AssertionErrors.assertEquals("hemant ahirkar", new Name(), nameService.process("hemant ahirkar"));
        AssertionErrors.assertEquals("Hemant deAhirkar", new Name(), nameService.process("Hemant deAhirkar"));
    }


}