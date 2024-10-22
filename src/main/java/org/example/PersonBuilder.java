package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age; // Используем Integer для проверки на null
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Name and surname must be set");
        }
        Person person;
        if (age != null) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }
}