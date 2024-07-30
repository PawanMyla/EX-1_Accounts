package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Person {

    private String name;

    @Autowired
    private Address address;

    public void displayInfo() {
        if (address != null) {
            System.out.println("Person Name: " + name);
            System.out.println("Address: " + address.getStreet() + ", " + address.getCity());
        } else {
            System.out.println("Address is not initialized.");
        }
    }
}
