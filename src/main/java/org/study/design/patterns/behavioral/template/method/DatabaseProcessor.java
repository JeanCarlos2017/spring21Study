package org.study.design.patterns.behavioral.template.method;

class DatabaseProcessor extends DataProcessor {
    @Override
    protected void loadData() {
        System.out.println("Loading data from database");
    }

    @Override
    protected void process() {
        System.out.println("Processing data");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving data to database");
    }
}
