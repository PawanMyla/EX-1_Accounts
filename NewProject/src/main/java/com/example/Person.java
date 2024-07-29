package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter // Lombok will generate getter methods
@Setter // Lombok will generate setter methods
@ToString // Lombok will generate a toString method
public class Person {

    private String name;

    @Autowired
    private Address address;

    // Commented out manually defined getters and setters
    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    */

    public void displayInfo() {
        if (address != null) {
            System.out.println("Person Name: " + name);
            System.out.println("Address: " + address.getStreet() + ", " + address.getCity());
        } else {
            System.out.println("Address is not initialized.");
        }
    }
}
