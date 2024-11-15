package com.example.fbo_event_management_system;

public class FoodDecorator extends EventDecorator {

    public FoodDecorator(Event decoratedEvent) {
        super(decoratedEvent);
    }

    @Override
    public String getDetails() {
        return decoratedEvent.getDetails() + " event has food included";
    }


}
