package org.study.design.patterns.behavioral.state;

class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Context is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}
