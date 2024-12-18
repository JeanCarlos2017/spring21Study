package org.study.design.patterns.visitor.concrete;

import org.study.design.patterns.visitor.ComputerPartVisitor;
import org.study.design.patterns.visitor.element.concrete.Computer;
import org.study.design.patterns.visitor.element.concrete.Keyboard;
import org.study.design.patterns.visitor.element.concrete.Monitor;
import org.study.design.patterns.visitor.element.concrete.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }
}

