package com.freelance.skc.application.mediator;

public class ChatService {

    private ChatRepo chatRepo;

    public ChatService(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    public ChatComponent joinChat(String chatId){
        return chatRepo.chatComponent(chatId);
    }

}
