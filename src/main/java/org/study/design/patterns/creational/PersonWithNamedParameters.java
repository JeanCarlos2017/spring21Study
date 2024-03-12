package org.study.design.patterns.creational;

import lombok.Getter;

@Getter
public class PersonWithNamedParameters {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;

    private PersonWithNamedParameters(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public static PersonWithNamedParameters create(String firstName, String lastName) {
        return new PersonWithNamedParameters(firstName, lastName, 0, null);
    }

    public static PersonWithNamedParameters create(String firstName, String lastName, int age) {
        return new PersonWithNamedParameters(firstName, lastName, age, null);
    }

    public static PersonWithNamedParameters create(String firstName, String lastName, String address) {
        return new PersonWithNamedParameters(firstName, lastName, 0, address);
    }

    public static PersonWithNamedParameters create(String firstName, String lastName, int age, String address) {
        return new PersonWithNamedParameters(firstName, lastName, age, address);
    }
}
