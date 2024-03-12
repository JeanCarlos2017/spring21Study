package org.study.design.patterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonBuilderTest {
    @Test
    public void testBuildPersonWithAllFields() {
        PersonWithBuilder person = new PersonWithBuilder.Builder("John", "Doe")
                .age(30)
                .address("123 Main St")
                .build();

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("123 Main St", person.getAddress());
    }

    @Test
    public void testBuildPersonWithPartialFields() {
        PersonWithBuilder person = new PersonWithBuilder.Builder()
                .firstName("Jane")
                .lastName("Smith")
                .build();

        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals(0, person.getAge());
        assertNull(person.getAddress());
    }
}
