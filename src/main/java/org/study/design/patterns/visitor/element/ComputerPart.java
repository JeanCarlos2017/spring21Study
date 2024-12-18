package org.study.design.patterns.visitor.element;

import org.study.design.patterns.visitor.ComputerPartVisitor;

public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
