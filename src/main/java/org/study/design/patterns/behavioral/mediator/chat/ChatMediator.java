package org.study.design.patterns.behavioral.mediator.chat;

public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
