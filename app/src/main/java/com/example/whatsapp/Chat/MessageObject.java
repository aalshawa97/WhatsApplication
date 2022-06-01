package com.example.whatsapp.Chat;

public class MessageObject {
    String messageId, text, senderId, message;
    public MessageObject (String messageId, String senderId, String message){
        this.messageId = messageId;
        this.senderId = senderId;
        this.message = message;
    }
    public String getMessageId() {
        return messageId;
    }

    public String getSenderId(){
        return senderId;
    }

    public String getMessage(){
        return message;
    }
}
