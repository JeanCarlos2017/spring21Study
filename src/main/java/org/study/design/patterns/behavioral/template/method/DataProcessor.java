package org.study.design.patterns.behavioral.template.method;

abstract class DataProcessor {
    // Template method
    public final void processData() {
        loadData();
        process();
        saveData();
    }

    protected abstract void loadData();

    protected abstract void process();

    protected abstract void saveData();
}