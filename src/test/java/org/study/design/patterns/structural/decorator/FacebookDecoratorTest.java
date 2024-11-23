package org.study.design.patterns.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FacebookDecoratorTest {

    @Test
    void sendMessageToFacebookAndWhatsApp() {
        INotifier notifyAll = new FacebookDecorator(new WhatsAppDecorator(new Notifier("Geekific")));
        assertDoesNotThrow(
                ()-> notifyAll.send("Like and Subscribe!!!")
        );
    }

    @Test
    void sendMessageToFacebook() {
        INotifier notifyFbMail = new FacebookDecorator(new Notifier("Geekific"));
        assertDoesNotThrow(
                ()-> notifyFbMail.send("Like and Subscribe!!!")
        );
    }

}