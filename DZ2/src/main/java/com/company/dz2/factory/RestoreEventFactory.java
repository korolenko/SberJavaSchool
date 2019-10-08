package com.company.dz2.factory;

import com.company.dz2.events.Event;
import com.company.dz2.events.RestoreEvent;

public class RestoreEventFactory extends EventFactory {
    @Override
    public Event createEvent(int deviceId, int componentId) {
        return new RestoreEvent(deviceId,componentId);
    }
}
