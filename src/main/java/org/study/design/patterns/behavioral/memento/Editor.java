package org.study.design.patterns.behavioral.memento;

import java.util.Deque;
import java.util.LinkedList;

public class Editor {

    private final TextArea textArea;
    private final Deque<TextArea.Memento> stateHistory;

    public Editor() {
        textArea = new TextArea();
        stateHistory = new LinkedList<>();
    }

    public void write(String text) {
        textArea.set(text);
        stateHistory.offer(textArea.takeSnapshot());
    }

    public void undo() {
        if (stateHistory.isEmpty()) {
            return;
        }
        stateHistory.pollLast();
        textArea.restore(stateHistory.peekLast());
    }

    public String printText() {
        System.out.println(textArea.getText());
        return textArea.getText();
    }

}
