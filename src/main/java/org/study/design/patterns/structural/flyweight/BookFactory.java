package org.study.design.patterns.structural.flyweight;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BookFactory {

    private static final Map<String, BookType> bookTypes = new HashMap<>();

    public static BookType getBookType(String type, String distributor, String otherData) {
        if (bookTypes.get(type) == null) {
            bookTypes.put(type, new BookType(type, distributor, otherData));
            log.info("Book type " + type + " created");
        }
        return bookTypes.get(type);
    }

}
