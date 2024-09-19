package com.freelance.skc.application.mediator;

public class ChatComponent {

    private ChatMediator chatMediator;

    public ChatComponent(ChatMediator chatMediator) {
        // мы же не можем интерфейс загружать, сюда при создании обхъекта сразу пойжет конкретный GRoupChat или DM
        this.chatMediator = chatMediator;
    }

    public void buildSendMessage(){
        this.chatMediator.sendMessage();
    }

}
