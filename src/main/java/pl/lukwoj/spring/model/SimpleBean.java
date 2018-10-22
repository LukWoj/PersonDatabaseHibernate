package pl.lukwoj.spring.model;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service// tworzenie bean
public class SimpleBean {
    public String generateString() {
        return UUID.randomUUID().toString();
    }
}