package org.study.design.patterns.creational.prototype.deep.copy;

public class PersonPrototype {
    private final Person prototype;

    public PersonPrototype(Person prototype) {
        this.prototype = prototype;
    }

    public Person clone() {
        Address originalAddress = prototype.getAddress();
        Address clonedAddress = new Address(originalAddress.getStreet(), originalAddress.getCity());
        return new Person(prototype.getName(), prototype.getAge(), clonedAddress);
    }
}

