package org.study.design.patterns.creational.named.parameters;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.creational.named.parameters.PersonWithNamedParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonWithNamedParametersTest {
    @Test
    public void testCreatePersonWithNamedParameters() {
        PersonWithNamedParameters PersonWithNamedParameters1 = PersonWithNamedParameters.create("John", "Doe");
        PersonWithNamedParameters PersonWithNamedParameters2 = PersonWithNamedParameters.create("Jane", "Smith", 30);
        PersonWithNamedParameters PersonWithNamedParameters3 = PersonWithNamedParameters.create("Alice", "Jones", "123 Main St");
        PersonWithNamedParameters PersonWithNamedParameters4 = PersonWithNamedParameters.create("Bob", "Brown", 25, "456 Elm St");

        assertEquals("John", PersonWithNamedParameters1.getFirstName());
        assertEquals("Doe", PersonWithNamedParameters1.getLastName());
        assertEquals(0, PersonWithNamedParameters1.getAge());
        assertNull(PersonWithNamedParameters1.getAddress());

        assertEquals("Jane", PersonWithNamedParameters2.getFirstName());
        assertEquals("Smith", PersonWithNamedParameters2.getLastName());
        assertEquals(30, PersonWithNamedParameters2.getAge());
        assertNull(PersonWithNamedParameters2.getAddress());

        assertEquals("Alice", PersonWithNamedParameters3.getFirstName());
        assertEquals("Jones", PersonWithNamedParameters3.getLastName());
        assertEquals(0, PersonWithNamedParameters3.getAge());
        assertEquals("123 Main St", PersonWithNamedParameters3.getAddress());

        assertEquals("Bob", PersonWithNamedParameters4.getFirstName());
        assertEquals("Brown", PersonWithNamedParameters4.getLastName());
        assertEquals(25, PersonWithNamedParameters4.getAge());
        assertEquals("456 Elm St", PersonWithNamedParameters4.getAddress());
    }
}
