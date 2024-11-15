package com.example.fbo_event_management_system;

public class Registration {
    private User user;
    private Event event;

    public Registration(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Reg.report: " + user.getNameOfUser()
                + " is going to event: " + event.getTitle();
    }

}
