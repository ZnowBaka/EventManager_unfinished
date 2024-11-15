package com.example.fbo_event_management_system;

public class User {
    private String profileName;
    private String loginName;
    private String loginCode;
    private boolean adminPrivilege = false;

    //Constructor
    public User(String username, String email, boolean isAdmin) {
        this.profileName = profileName;
        this.loginName = loginName;
        this.loginCode = loginCode;
    }

    public User (String userLoginName, String userLoginCode){
        this.loginName = userLoginName;
        this.loginCode = userLoginCode;
    }

    public User(String nameOfUser, String userLoginName, String userLoginCode) {

    }


    //region Sets and Gets
    public String getNameOfUser() {
        return profileName;
    }

    public void setNameOfUser(String nameOfUser) {
        this.profileName = nameOfUser;
    }

    public String getUserLoginName() {
        return loginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.loginName = userLoginName;
    }

    protected String getUserLoginCode() {
        return loginCode;
    }

    protected void setUserLoginCode(String userLoginCode) {
        this.loginCode = userLoginCode;
    }

    public boolean getAdminPrivilege() {
        return adminPrivilege;
    }

    //endregion

    protected void joinEvent(BasicEvent event) {
        event.setAttendants(this);
    }

    protected void leaveEvent(BasicEvent event) {
        event.removeAttendants(this);
    }
}
