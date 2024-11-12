package com.example.fbo_event_management_system;

public class AdminUser extends User implements AdminActions{

    //Constructor
    public AdminUser(String nameOfUser, String userLoginName, String userLoginCode, boolean adminPrivilege, boolean manager) {
        super(nameOfUser, userLoginName, userLoginCode, adminPrivilege, manager);
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

    @Override
    public void joinEvent(Event event) {
        super.joinEvent(event);
    }
}
