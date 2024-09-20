package com.example.midterm;

import dto.Name;
import org.springframework.stereotype.Component;
import service.NameService;

import utility.NameBuilder;

@Component
public class ConcreteNameService implements NameService {
    @Override
    public Name process(String name) throws Exception {

        String[] fullName = new NameBuilder().process(name);
        Name res_name = new Name();
        res_name.setFirst(fullName[0]);
        res_name.setLast(fullName[1]);
        
        return res_name;
    }
}
