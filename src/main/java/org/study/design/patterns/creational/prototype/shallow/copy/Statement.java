package org.study.design.patterns.creational.prototype.shallow.copy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Statement implements Cloneable{
    private String sql;
    private List<String> parameters;
    private Record record;

    public Statement(String sql, List<String> parameters, Record record) {
        this.sql = sql;
        this.parameters = parameters;
        this.record = record;
    }



    public Statement clone() {
        try {
            return (Statement) super.clone();
        } catch (CloneNotSupportedException e) {
            e.fillInStackTrace();
        }
        return null;
    }
}
