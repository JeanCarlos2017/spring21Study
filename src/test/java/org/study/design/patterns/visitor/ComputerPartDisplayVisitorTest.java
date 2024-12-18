package org.study.design.patterns.visitor;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.visitor.concrete.ComputerPartDisplayVisitor;
import org.study.design.patterns.visitor.element.concrete.Computer;
import org.study.design.patterns.visitor.element.ComputerPart;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPartDisplayVisitorTest {
    @Test
    void visit() {
        ComputerPart computer = new Computer();
        ComputerPartVisitor displayVisitor = new ComputerPartDisplayVisitor();

        assertDoesNotThrow(()-> computer.accept(displayVisitor));
    }
}