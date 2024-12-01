package org.study.design.patterns.behavioral.chainofresposability;

public class OperationalHandler extends Handler {
    public void handleRequest(TypeTicket typeTicket) {
        super.handleRequest(typeTicket);

        if(TypeTicket.OPERATIONAL.equals(typeTicket)){
            System.out.println("SupportOperationalHandler handleRequest");
        }

    }
}
