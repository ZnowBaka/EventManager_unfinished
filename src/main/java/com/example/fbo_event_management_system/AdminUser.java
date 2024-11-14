package com.example.fbo_event_management_system;

public class AdminUser extends User implements AdminActions{
    private static AdminUser instance;
    // Constructor

    public AdminUser(String nameOfUser, String userLoginName, String userLoginCode, boolean adminPrivilege, boolean manager) {
        super();
    }
    public AdminUser(){
        super();
    }

    @Override
    public String toString() {
        return super.nameOfUser.toString();
    }

    // Singleton Pattern
    public static AdminUser getInstance() {
        if (instance == null) {
            instance = new AdminUser();
        }
        return instance;
    }
    @Override
    public void joinEvent(Event event) {
        super.joinEvent(event);
    }

    @Override
    public void addUser() {

    }

    @Override
    public void removeUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public String generateRapport() {
        return "";
    }

}
