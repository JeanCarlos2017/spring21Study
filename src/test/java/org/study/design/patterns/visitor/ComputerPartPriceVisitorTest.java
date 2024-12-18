package org.study.design.patterns.visitor;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.visitor.concrete.ComputerPartPriceVisitor;
import org.study.design.patterns.visitor.element.concrete.Computer;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPartPriceVisitorTest {
    @Test
    void visit() {
        Computer computer = new Computer();
        ComputerPartPriceVisitor visitor = new ComputerPartPriceVisitor();

        assertDoesNotThrow(() -> computer.accept(visitor));
    }

}