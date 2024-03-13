package org.study.design.patterns.creational.prototype;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.creational.prototype.shallow.copy.Record;
import org.study.design.patterns.creational.prototype.shallow.copy.Statement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {
    @Test
    void shalllowCopy(){
        String sql = "select * from movies where title = ?";
        List<String> parameters = new ArrayList<>();
        parameters.add("Star wars");
        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);
        Statement secondStatement = firstStatement.clone();

        assertEquals(firstStatement.getSql(), secondStatement.getSql());
        assertEquals(firstStatement.getParameters(), secondStatement.getParameters());
        assertEquals(firstStatement.getRecord(), secondStatement.getRecord());
    }
}
