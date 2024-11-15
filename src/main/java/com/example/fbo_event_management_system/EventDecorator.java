package com.example.fbo_event_management_system;

abstract class EventDecorator implements Event {
    protected Event decoratedEvent;

    public EventDecorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    @Override
    public String getDetails() {
        return decoratedEvent.getDetails();
    }

    @Override
    public String getTitle() {
        return decoratedEvent.getTitle();
    }

}
