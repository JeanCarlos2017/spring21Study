package org.study.design.patterns.creational;

import lombok.Getter;

@Getter
public class PersonWithBuilder {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;


    // Construtor privado para evitar instâncias diretas da classe
    private PersonWithBuilder(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }


    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder() {
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        // Método para construir a instância de Person
        public PersonWithBuilder build() {
            return new PersonWithBuilder(this);
        }
    }
}
