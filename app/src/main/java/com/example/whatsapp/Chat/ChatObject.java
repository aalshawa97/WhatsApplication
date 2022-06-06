package com.example.whatsapp.Chat;

import com.example.whatsapp.User.UserObject;

import java.util.ArrayList;

public class ChatObject {
    private String chatId, title;

    private ArrayList <UserObject> arrayList = new ArrayList<>();
    public ChatObject(String chatId){
        this.chatId = chatId;
    }
    public String getChatId() { return chatId;}
    public ArrayList<UserObject> getUserObjectArrayList() { return arrayList;}
    public void addUserToArrayList(UserObject mUser){
        arrayList.add(mUser);
    }
}

