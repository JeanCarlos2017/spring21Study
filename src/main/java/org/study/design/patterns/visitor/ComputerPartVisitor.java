package org.study.design.patterns.visitor;

import org.study.design.patterns.visitor.element.concrete.Computer;
import org.study.design.patterns.visitor.element.concrete.Keyboard;
import org.study.design.patterns.visitor.element.concrete.Monitor;
import org.study.design.patterns.visitor.element.concrete.Mouse;

public interface ComputerPartVisitor {
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
    void visit(Computer computer);
}
