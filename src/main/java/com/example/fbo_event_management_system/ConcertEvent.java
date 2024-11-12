package com.example.fbo_event_management_system;

import java.util.ArrayList;

public class ConcertEvent extends Event{

    public ConcertEvent(String eventType, String eventName, String dateOfEvent, String eventLocation, String eventDescription, String eventManager, ArrayList<User> attendents) {
        super(eventType, eventName, dateOfEvent, eventLocation, eventDescription, eventManager, attendents);
    }

    public ConcertEvent() {
        super();
    }

    @Override
    public void setEventManager(String eventManager) {
        super.setEventManager(eventManager);
    }

    @Override
    public String getEventManager() {
        return super.getEventManager();
    }

    @Override
    public void setAttendants(User user) {
        super.setAttendants(user);
    }

    @Override
    public void removeAttendants(User user) {
        super.removeAttendants(user);
    }

    @Override
    public void setEventDescription(String eventDescription) {
        super.setEventDescription(eventDescription);
    }

    @Override
    public String getEventDescription() {
        return super.getEventDescription();
    }

    @Override
    public void setEventLocation(String eventLocation) {
        super.setEventLocation(eventLocation);
    }

    @Override
    public String getEventLocation() {
        return super.getEventLocation();
    }

    @Override
    public void setDateOfEvent(String dateOfEvent) {
        super.setDateOfEvent(dateOfEvent);
    }

    @Override
    public String getDateOfEvent() {
        return super.getDateOfEvent();
    }

    @Override
    public void setEventName(String eventName) {
        super.setEventName(eventName);
    }

    @Override
    public String getEventName() {
        return super.getEventName();
    }

    @Override
    public void setEventType(String eventType) {
        super.setEventType(eventType);
    }

    @Override
    public String getEventType() {
        return super.getEventType();
    }
}
