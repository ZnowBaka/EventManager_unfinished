package com.example.fbo_event_management_system;

public class MusicDecorator extends EventDecorator {
    public MusicDecorator(Event decoratedEvent) {
        super(decoratedEvent);
    }

    @Override
    public String getDetails() {
        return decoratedEvent.getDetails() + " event has music included";
    }


}
