package com.example.midterm;

import dto.Name;

import org.springframework.stereotype.Component;
import service.NameService;

// Import Regular Expression libraries
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class ConcreteNameService implements NameService {
    @Override
    public Name process(String name) throws Exception {

        // Remove the following:
        // "Csar", "Dr", "D. R.", "Rev.", "a.k.a. (and all the characters after it)", "M.B.A.", "J. R.",
        // "M.BA", "Certified Professional", "II.", "Jr.", "Dip Ed", "DipEd", "MSc", "MPH", "DRes/PhD", "MacA", "assoc prof"
        // anything enclosed in parentheses, quotation marks, single quotes,
        // numbers, extra whitespaces, special characters
        String cleanName = name
                .replaceAll("(?i)(Csar|Dr|D\\.R\\.|Rev\\.|a\\.k\\.a.*|M\\.B\\.A\\.|J\\.|R\\.|, Bsc|Bsc|M\\.BA|Certified|Professional|\\(.*?\\)|\\\".*?\\\"|'[^']*'|\\s*\\d+|II\\.|Jr\\.|Dip|Ed|DipEd|MSc|MPH|es|PhD|MacA|assoc|prof|J)", "")
                .replaceAll("[^a-zA-Z,]", " ")
                .replaceAll("\\s{2,}", " ")
                .trim();
        // Convert cleaned name to title case if it's in all upper or lower case
        cleanName = toTitleCaseIfNecessary(cleanName);

        String[] parts;
        String fname = "", lname = "";
        // Handles the format "Last, First"
        if (cleanName.contains(",")) {
            parts = cleanName.split(",");
            lname = parts[0];
            fname = parts[1];
            //if (cleanName.contains(" ")) {
            //    parts = lname.split(" ");
            //    fname = parts[0];
            //    lname = parts[1];
            //}
            return new Name(fname.trim(), lname.trim());
        }

        parts = cleanName.split(" ");
        if (parts.length == 2) {
            fname = parts[0];
            lname = parts[1];
            return new Name(fname, lname);
        }else if (parts.length > 2) {
            if (parts[1].length() == 1) {
                parts[1] = parts[2];
                parts[2] = "";
            }
            fname = parts[0];
            lname = parts[parts.length - 2] + " " + parts[parts.length - 1];
            return new Name(fname.trim(), lname.trim());
        }

        System.out.println("fname: " + parts[0]);
        System.out.println("lname: " + parts[1]);

        return new Name(fname, lname);


    }
    // Utility function to handle capitalization
    private String toTitleCaseIfNecessary(String name) {
        if (name.equals(name.toUpperCase()) || name.equals(name.toLowerCase())) {
            String[] words = name.split(" ");
            StringBuilder titleCaseName = new StringBuilder();
            for (String word : words) {
                if (word.length() > 1) {
                    titleCaseName.append(word.substring(0, 1).toUpperCase())
                            .append(word.substring(1).toLowerCase()).append(" ");
                } else {
                    titleCaseName.append(word.toUpperCase()).append(" ");
                }
            }
            return titleCaseName.toString().trim();
        }
        return name; // Return the original name if no changes needed
    }
}
