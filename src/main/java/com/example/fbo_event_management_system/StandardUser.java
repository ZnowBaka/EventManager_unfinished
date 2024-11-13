package com.example.fbo_event_management_system;

public class StandardUser extends User{
    public StandardUser(String nameOfUser, String userLoginName, String userLoginCode) {
        super(nameOfUser, userLoginName, userLoginCode);
    }

    public StandardUser(String userLoginName, String userLoginCode) {
        super(userLoginName, userLoginCode);
    }

    @Override
    public void joinEvent(Event event) {
        super.joinEvent(event);
    }
}
