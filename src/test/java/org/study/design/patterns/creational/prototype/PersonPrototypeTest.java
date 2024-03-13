package org.study.design.patterns.creational.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.study.design.patterns.creational.prototype.deep.copy.Address;
import org.study.design.patterns.creational.prototype.deep.copy.Person;
import org.study.design.patterns.creational.prototype.deep.copy.PersonPrototype;

public class PersonPrototypeTest {

    @Test
    public void testDeepCopy() {
        // Criando um objeto Address que será compartilhado
        Address originalAddress = new Address("123 Main St", "City");

        // Criando um objeto Person que será o protótipo
        Person john = new Person("John", 30, originalAddress);

        // Criando uma instância de PersonPrototype com o protótipo
        PersonPrototype prototype = new PersonPrototype(john);

        // Realizando uma cópia profunda
        Person johnCopy = prototype.clone();

        // Verificando se os valores da cópia são os mesmos do protótipo
        assertEquals(john.getName(), johnCopy.getName());
        assertEquals(john.getAge(), johnCopy.getAge());
        assertEquals(john.getAddress().getStreet(), johnCopy.getAddress().getStreet());
        assertEquals(john.getAddress().getCity(), johnCopy.getAddress().getCity());

        // Modificando a cópia
        johnCopy.setName("Jane");
        johnCopy.setAge(25);
        johnCopy.getAddress().setStreet("456 Elm St");
        johnCopy.getAddress().setCity("New City");

        // Verificando se as alterações na cópia não afetam o protótipo
        assertEquals("John", john.getName());
        assertEquals(30, john.getAge());
        assertEquals("123 Main St", john.getAddress().getStreet());
        assertEquals("City", john.getAddress().getCity());
    }
}
