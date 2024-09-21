package service;

import dto.Email;


public interface EmailService {

    Email process(String email) throws Exception;
}
