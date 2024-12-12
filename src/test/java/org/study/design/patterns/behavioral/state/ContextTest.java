package org.study.design.patterns.behavioral.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextTest {
    @Test
    void getContext() {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        assertEquals("Start State", context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        assertEquals("Stop State", context.getState().toString());
    }
}