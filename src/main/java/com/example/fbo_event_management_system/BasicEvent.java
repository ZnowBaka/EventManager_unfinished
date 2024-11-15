package com.example.fbo_event_management_system;

import java.util.ArrayList;

// Event types: Conference Concert Workshop

public class BasicEvent implements Event {
    protected String eventType;
    protected String eventName;
    protected String dateOfEvent;
    protected String eventLocation;
    protected String eventDescription;
  
    public ArrayList<User> attendents = new ArrayList<>();

    //Constructor for an Event
    public BasicEvent(String eventType, String eventName, String dateOfEvent, String eventLocation, String eventDescription) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.dateOfEvent = dateOfEvent;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.attendents = attendents;
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


    public String getTitle() {
        return eventName;
    }

    @Override
    public String getDetails() {
        return "Event is titled: " + eventName
                + "\nEvent-type: " + eventType
                + "\nEvent description: " + eventDescription
                + "\nIt takes place on " + dateOfEvent
                + "\nAt: " + eventLocation;
    }



}
