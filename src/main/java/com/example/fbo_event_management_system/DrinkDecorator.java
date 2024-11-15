package com.example.fbo_event_management_system;

public class DrinkDecorator extends EventDecorator{

    public DrinkDecorator(Event decoratedEvent) {
        super(decoratedEvent);
    }

    @Override
    public String getDetails() {
        return decoratedEvent.getDetails() + " event has drinks included";
    }

}
