package com.company.dz2.factory;

import com.company.dz2.events.Event;

public abstract class EventFactory {
    public abstract Event createEvent(int deviceId, int componentId);
}
