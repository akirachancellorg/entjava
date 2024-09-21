package dto;

import lombok.Data;

@Data
public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email()
    {

    }
}
