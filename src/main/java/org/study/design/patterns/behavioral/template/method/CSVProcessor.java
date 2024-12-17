package org.study.design.patterns.behavioral.template.method;

class CSVProcessor extends DataProcessor {
    @Override
    protected void loadData() {
        System.out.println("Loading data from CSV file");
    }

    @Override
    protected void process() {
        System.out.println("Processing data");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving data to CSV file");
    }
}
