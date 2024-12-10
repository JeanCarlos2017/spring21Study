package org.study.design.patterns.behavioral.observer;

public record MobileAppListener(String username) implements Listener {

    @Override
    public String update(Event eventType) {
        // Actually send the push notification to username
        System.out.println("Sending mobile app notification to " + username + " concerning " + eventType);
        return "Sending mobile app notification to " + username + " concerning " + eventType;
    }

}
