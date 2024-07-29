package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter // Lombok will generate getter methods
@Setter // Lombok will generate setter methods
@AllArgsConstructor // Lombok will generate a constructor with all arguments
@NoArgsConstructor // Lombok will generate a no-argument constructor
public class Address {
    private String street;
    private String city;

    // Commented out manually defined getters and setters
    /*
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    */
}
