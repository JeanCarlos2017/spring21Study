package org.study.design.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.study.design.patterns.behavioral.observer.Event.NEW_ITEM;
import static org.study.design.patterns.behavioral.observer.Event.SALE;
/*
    these examples are from https://github.com/geekific-official/geekific-youtube/tree/main/design-patterns/behavioral-observer/src/main/java/com/youtube/geekific
 */

class StoreTest {
    @Test
    void testNewItemPromotion(){
        Store store = new Store();
        store.subscribeOnNotificationStore(NEW_ITEM, new EmailMsgListener("geekific@like.com"));
        store.subscribeOnNotificationStore(NEW_ITEM, new MobileAppListener("GeekificLnS"));

        List<String> newItemPromotionMessages= store.newItemPromotion();

        assertEquals(2, newItemPromotionMessages.size());
    }

    @Test
    void testSalesPromotion(){
        Store store = new Store();
        store.subscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@like.com"));
        store.subscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@subs.com"));
        store.subscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@members.com"));

        List<String> salePromotionMessages= store.salePromotion();

        assertEquals(3, salePromotionMessages.size());
    }

    @Test
    void test_subscribeStore() {
        Store store = new Store();
        store.subscribeOnNotificationStore(NEW_ITEM, new EmailMsgListener("geekific@like.com"));
        store.subscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@like.com"));
        store.subscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@subs.com"));
        store.subscribeOnNotificationStore(NEW_ITEM, new MobileAppListener("GeekificLnS"));

        List<String> newItemPromotionMessages= store.newItemPromotion();
        assertEquals(2, newItemPromotionMessages.size());

        System.out.println("==========================================");

        List<String> salePromotionMessages= store.salePromotion();
        assertEquals(2, salePromotionMessages.size());

        System.out.println("==========================================");

        store.unSubscribeOnNotificationStore(SALE, new EmailMsgListener("geekific@like.com"));
        salePromotionMessages= store.salePromotion();
        assertEquals(1, salePromotionMessages.size());
    }

}