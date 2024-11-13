package com.example.fbo_event_management_system;

    /*
    we should use a Singleton when we create the admin, to make sure only 1 admin is allowed
    we should make a Factory for StandardUsers
    */

public class User {
    protected String nameOfUser;
    protected String userLoginName;
    private String userLoginCode;
    protected boolean adminPrivilege;
    protected boolean manager;
    //Constructor
    public User(String nameOfUser, String userLoginName, String userLoginCode, boolean adminPrivilege, boolean manager) {
        this.nameOfUser = nameOfUser;
        this.userLoginName = userLoginName;
        this.userLoginCode = userLoginCode;
        this.adminPrivilege = adminPrivilege;
        this.manager = manager;
    }
    public User (String userLoginName, String userLoginCode){
        this.userLoginName = userLoginName;
        this.userLoginCode = userLoginCode;
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

    public String getUserLoginCode() {
        return userLoginCode;
    }

    public void setUserLoginCode(String userLoginCode) {
        this.userLoginCode = userLoginCode;
    }

    public boolean isAdminPrivilege() {
        return adminPrivilege;
    }

    public void setAdminPrivilege(boolean adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
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
