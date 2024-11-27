package org.study.design.patterns.structural.flyweight;

import lombok.Data;

public record Book(String name, double price, BookType type) {

}