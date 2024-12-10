package org.study.design.patterns.behavioral.observer;

public record EmailMsgListener(String email) implements Listener {

    @Override
    public String update(Event eventType) {
        // Actually send the mail
        System.out.println("Sending mail to " + email + " concerning " + eventType);
        return "Sending mail to " + email + " concerning " + eventType;
    }

}
