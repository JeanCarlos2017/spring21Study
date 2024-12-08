package org.study.design.patterns.behavioral.mediator.chat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatMediatorImplTest {

    @Test
    void mediatorTest() {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "User1");
        User user2 = new UserImpl(mediator, "User2");
        User user3 = new UserImpl(mediator, "User3");
        User user4 = new UserImpl(mediator, "User4");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        assertDoesNotThrow(
                () -> user1.send("Hello, everyone!")
        );
    }

}