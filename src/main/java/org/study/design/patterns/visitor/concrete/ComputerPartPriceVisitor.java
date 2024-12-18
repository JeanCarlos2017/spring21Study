package org.study.design.patterns.visitor.concrete;

import org.study.design.patterns.visitor.ComputerPartVisitor;
import org.study.design.patterns.visitor.element.concrete.Computer;
import org.study.design.patterns.visitor.element.concrete.Keyboard;
import org.study.design.patterns.visitor.element.concrete.Monitor;
import org.study.design.patterns.visitor.element.concrete.Mouse;

import java.math.BigDecimal;

public class ComputerPartPriceVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        BigDecimal value = BigDecimal.valueOf(20.2);
        System.out.println("Price Keyboard $"+value);
    }

    @Override
    public void visit(Monitor monitor) {
        BigDecimal value = BigDecimal.valueOf(300.59);
        System.out.println("Price monitor $"+value);
    }

    @Override
    public void visit(Mouse mouse) {
        BigDecimal value = BigDecimal.valueOf(5.99);
        System.out.println("Price mouse $"+value);
    }

    @Override
    public void visit(Computer computer) {
        BigDecimal value = BigDecimal.valueOf(2999.99);
        System.out.println("Price computer $"+value);
    }
}