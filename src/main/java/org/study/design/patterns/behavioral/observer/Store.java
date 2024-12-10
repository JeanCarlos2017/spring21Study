package org.study.design.patterns.behavioral.observer;

import java.util.List;

import static org.study.design.patterns.behavioral.observer.Event.NEW_ITEM;
import static org.study.design.patterns.behavioral.observer.Event.SALE;

public class Store {

    private final NotificationService notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    public List<String> newItemPromotion() {
        return notificationService.notifyCustomers(NEW_ITEM);
    }

    public List<String> salePromotion() {
        return notificationService.notifyCustomers(SALE);
    }

    public void subscribeOnNotificationStore(Event eventType, Listener listener){
        this.notificationService.subscribe(eventType, listener);
    }

    public void unSubscribeOnNotificationStore(Event eventType, Listener listener){
        this.notificationService.unsubscribe(eventType, listener);
    }

}