package com.example.fbo_event_management_system;

    /*
    we should use a Singleton when we create the admin, to make sure only 1 admin is allowed
    we should make a Factory for StandardUsers
    */

public class User {
    protected String nameOfUser;
    protected String userLoginName;
    private String userLoginCode;
    protected boolean adminPrivilege = false;
    protected boolean manager = false;
    //Constructor
    public User() {
        this.nameOfUser = nameOfUser;
        this.userLoginName = userLoginName;
        this.userLoginCode = userLoginCode;
    }
    public User (String userLoginName, String userLoginCode){
        this.userLoginName = userLoginName;
        this.userLoginCode = userLoginCode;
    }

    public User(String nameOfUser, String userLoginName, String userLoginCode) {

    }


    //region Sets and Gets
    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    protected String getUserLoginCode() {
        return userLoginCode;
    }

    protected void setUserLoginCode(String userLoginCode) {
        this.userLoginCode = userLoginCode;
    }

    public boolean getAdminPrivilege() {
        return adminPrivilege;
    }



    //endregion



    protected void login() {

    }

    // Event types: Conference Concert Workshop
    protected void createEvent(String eventType) {
        switch (eventType){
            case("conference"):
                new ConferenceEvent();
                break;
            case("concert"):
                new ConcertEvent();
                break;
            case("workshop"):
                new WorkshopEvent();
                break;
            default:
        }
    }


    protected void editEvent(Event event) {

    }


    protected void deleteEvent(Event event) {
        if ((this.nameOfUser.equals(event.eventManager)) || this.adminPrivilege){

        } else {

        }
    }


    protected void joinEvent(Event event) {
        event.setAttendants(this);
    }


    protected void leaveEvent(Event event) {
        event.removeAttendants(this);
    }
}
