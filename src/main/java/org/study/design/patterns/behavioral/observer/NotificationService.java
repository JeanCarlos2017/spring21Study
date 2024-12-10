package org.study.design.patterns.behavioral.observer;

import java.util.*;

public class NotificationService {

    private final Map<Event, List<Listener>> customers;

    public NotificationService() {
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, Listener listener) {
        customers.get(eventType).add(listener);
    }

    public void unsubscribe(Event eventType, Listener listener) {
        customers.get(eventType).remove(listener);
    }

    public List<String> notifyCustomers(Event eventType) {
        List<String> messagesFromListeners = new ArrayList<>();
        customers.get(eventType).forEach(listener -> messagesFromListeners.add(listener.update(eventType)));
        return messagesFromListeners;
    }

}
