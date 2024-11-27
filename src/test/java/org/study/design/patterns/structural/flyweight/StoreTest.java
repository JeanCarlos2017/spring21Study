package org.study.design.patterns.structural.flyweight;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    private static final int BOOK_TYPES = 2;
    private static final int BOOKS_TO_INSERT = 10_000_000;

    @Test
    void testAdd10_000_000Books() {
        Store store = new Store();

        assertDoesNotThrow(
                () -> addBooksInStore(store)
        );

        verifyCOuntBookTypes(store);

        System.out.println("==========================================");
        System.out.println(BOOKS_TO_INSERT + " Books Inserted");
        System.out.println("==========================================");
        System.out.println("Memory Usage: ");
        System.out.println("Book Size (20 bytes) * " + BOOKS_TO_INSERT + " + BookTypes Size (30 bytes) * " + BOOK_TYPES + "");
        System.out.println("==========================================");
        System.out.println("Total: " + ((BOOKS_TO_INSERT * 20 + BOOK_TYPES * 30) / 1024 / 1024) + "MB (instead of " + ((BOOKS_TO_INSERT * 50) / 1024 / 1024) + "MB)");


    }

    private static void addBooksInStore(Store store) {
        //note that only two BookTypes were created
        for (int i = 0; i < BOOKS_TO_INSERT / BOOK_TYPES; i++) {
            store.storeBook(getRandomName(), getRandomPrice(), "Action", "Follett", "Stuff");
            store.storeBook(getRandomName(), getRandomPrice(), "Fantasy", "Ingram", "Extra");
        }


    }

    private static String getRandomName() {
        List<String> books = List.of("book_1", "book_2", "book_3", "book_4", "book_5", "book_6", "book_7", "book_8", "book_9", "book_10");
        return books.get(new Random().nextInt(books.size()));
    }

    private static double getRandomPrice() {
        return new Random().nextDouble(10, 200);
    }

    private static void verifyCOuntBookTypes(Store store) {
        Set<Integer> bookItemIdsHash = new HashSet<>();

        for (Book books: store.getBooks()){
            bookItemIdsHash.add(books.type().hashCode());
        }


        System.out.println("==========================================");
        System.out.println("Hash code of bookItensHash");
        bookItemIdsHash.stream().forEach(System.out::println);
        System.out.println("==========================================");

        assertEquals(BOOK_TYPES, bookItemIdsHash.size());
    }

}