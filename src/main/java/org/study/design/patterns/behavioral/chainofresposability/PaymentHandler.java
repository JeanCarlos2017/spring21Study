package org.study.design.patterns.behavioral.chainofresposability;

public class PaymentHandler extends Handler{

    public void handleRequest(TypeTicket typeTicket) {
        super.handleRequest(typeTicket);

        if(TypeTicket.PAYMENT.equals(typeTicket)){
            System.out.println("SupportPaymentHandler handleRequest");
        }

    }
}
