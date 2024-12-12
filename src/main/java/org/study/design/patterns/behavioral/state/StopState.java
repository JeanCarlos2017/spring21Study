package org.study.design.patterns.behavioral.state;

class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Context is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}
