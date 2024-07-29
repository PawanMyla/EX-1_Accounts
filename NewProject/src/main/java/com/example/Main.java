package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person1 = context.getBean(Person.class);
        person1.setName("Alice");
        person1.displayInfo();

        Person person2 = context.getBean(Person.class);
        person2.setName("Bob");
        person2.displayInfo();

        System.out.println("Are person1 and person2 the same instance? " + (person1 == person2));

        context.close();
    }
}
