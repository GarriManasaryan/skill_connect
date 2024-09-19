package com.freelance.skc.application.mediator;

public class ChatRepo {

    public ChatComponent chatComponent(String chatId){
        // из базы по chatId мы из базы понимаем (либо по флагу, либо по числу реципиентов) сразу понимаем, dm или груп
        // new - уже конкретный чат
        return new ChatComponent(new DMChatMediator("Sasha"));
    }

}
