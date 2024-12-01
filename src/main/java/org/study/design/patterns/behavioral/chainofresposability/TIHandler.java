package org.study.design.patterns.behavioral.chainofresposability;

public class TIHandler extends Handler {
    public void handleRequest(TypeTicket typeTicket) {
        super.handleRequest(typeTicket);

        if(TypeTicket.TI.equals(typeTicket)){
            System.out.println("SupportTIHandler handleRequest");
        }

    }



}
