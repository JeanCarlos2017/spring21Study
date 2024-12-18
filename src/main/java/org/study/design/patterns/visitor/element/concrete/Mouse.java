package org.study.design.patterns.visitor.element.concrete;

import org.study.design.patterns.visitor.element.ComputerPart;
import org.study.design.patterns.visitor.ComputerPartVisitor;

public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}