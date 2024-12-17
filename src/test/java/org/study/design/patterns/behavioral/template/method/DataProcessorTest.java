package org.study.design.patterns.behavioral.template.method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    @Test
    void testCSVProcessor(){
        DataProcessor csvProcessor = new CSVProcessor();
        assertDoesNotThrow(csvProcessor::processData);
    }

    @Test
    void testDatabaseProcessor(){
        DataProcessor databaseProcessor = new DatabaseProcessor();
        assertDoesNotThrow(databaseProcessor::processData);
    }
}