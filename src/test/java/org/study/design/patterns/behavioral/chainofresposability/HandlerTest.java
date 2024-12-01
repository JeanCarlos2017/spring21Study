package org.study.design.patterns.behavioral.chainofresposability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    private  Handler handler;

    @BeforeEach
    public void getHandler() {
        //create handler
        OperationalHandler operationalHandler = new OperationalHandler();
        PaymentHandler paymentHandler = new PaymentHandler();
        TIHandler tiHandler = new TIHandler();
        //set nextHandlers
        paymentHandler.setNextHandler(tiHandler);
        operationalHandler.setNextHandler(paymentHandler);

        handler = operationalHandler;
    }

    @Test
    void testTiTicket(){
        assertDoesNotThrow(
                () -> handler.handleRequest(TypeTicket.TI)
        );
    }

    @Test
    void testOperationalTicket(){
        assertDoesNotThrow(
                () -> handler.handleRequest(TypeTicket.OPERATIONAL)
        );
    }

    @Test
    void testPaymentTicket(){
        assertDoesNotThrow(
                () -> handler.handleRequest(TypeTicket.PAYMENT)
        );
    }
}