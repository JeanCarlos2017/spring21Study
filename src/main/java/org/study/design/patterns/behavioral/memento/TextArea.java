package org.study.design.patterns.behavioral.memento;

import lombok.Getter;

@Getter
public class TextArea {
    private String text;

    public void set(String text) {
        this.text = text;
    }

    public Memento takeSnapshot() {
        return new Memento(this.text);
    }

    public void restore(Memento memento) {
        this.text = memento != null ? memento.getSavedText() : null;
    }

    public static class Memento {
        private final String text;

        private Memento(String textToSave) {
            text = textToSave;
        }

        private String getSavedText() {
            return text;
        }
    }
}
