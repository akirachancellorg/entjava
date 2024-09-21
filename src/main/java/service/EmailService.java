package service;

import dto.Email;

public interface EmailService {

    boolean validate(String email) throws Exception;

}