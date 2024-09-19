package com.freelance.skc.application.mediator;

import java.util.List;

public class GroupChatMediator implements ChatMediator{

    private final List<String> recipientIds;

    public GroupChatMediator(List<String> recipientIds) {
        this.recipientIds = recipientIds;
    }

    @Override
    public void sendMessage() {

    }

}
