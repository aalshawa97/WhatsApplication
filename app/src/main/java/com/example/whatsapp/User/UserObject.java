package com.example.whatsapp.User;

public class UserObject {
    private String uid, name,phone, notificationKey;

    public UserObject(String uid, String name, String phone, String notificationKey){
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.notificationKey = notificationKey;
    }

    public UserObject(String uid){
        this.uid = uid;
    }

    public UserObject(String key, String name, String phone) {
    }

    public String getPhone() {
        return phone;
    }

    public String getName(){
        return name;
    }

    public String getUid(){
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
