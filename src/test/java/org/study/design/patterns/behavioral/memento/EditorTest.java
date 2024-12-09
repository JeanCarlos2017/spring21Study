package org.study.design.patterns.behavioral.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {

    @Test
    void testEditor() {
        Editor editor = new Editor();
        editor.write("Like and");
        editor.printText();
        editor.write("Like and Subscribe");
        editor.printText();
        editor.write("Like and Subscribe to Geekific!");
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();
        assertEquals("Like and", editor.printText());
        editor.undo();
        assertNull(editor.printText());
    }

}