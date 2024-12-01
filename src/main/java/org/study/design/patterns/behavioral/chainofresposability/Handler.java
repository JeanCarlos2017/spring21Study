package org.study.design.patterns.behavioral.chainofresposability;

import lombok.Setter;

@Setter
abstract class Handler {
    private Handler nextHandler;

    public void handleRequest(TypeTicket request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
