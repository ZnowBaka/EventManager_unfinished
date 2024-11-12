package com.example.fbo_event_management_system;

import java.util.ArrayList;

// Event types: Conference Concert Workshop

public class Event {
    protected String eventType;
    protected String eventName;
    protected String dateOfEvent;
    protected String eventLocation;
    protected String eventDescription;
    protected String eventManager;
    public ArrayList<User> attendents = new ArrayList<>();

    //Constructor for an Event
    public Event(String eventType, String eventName, String dateOfEvent, String eventLocation, String eventDescription, String eventManager, ArrayList<User> attendents) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.dateOfEvent = dateOfEvent;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventManager = eventManager;
        this.attendents = attendents;
    }
    public Event(){}

    //region Getters and Setters

    public void setEventManager(String eventManager) {
        this.eventManager = eventManager;
    }

    public String getEventManager() {
        return eventManager;
    }

    public void setAttendants(User user) {
        attendents.add(user);
    }

    public void removeAttendants(User user) {
        for (int index = 0; index < attendents.size(); index++) {
            if (user.equals(this)) {
                break;
            }
            attendents.remove(index);
        }
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
    //endregion

}
