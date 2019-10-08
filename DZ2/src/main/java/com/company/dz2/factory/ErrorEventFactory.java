package com.company.dz2.factory;

import com.company.dz2.events.ErrorEvent;
import com.company.dz2.events.Event;

public class ErrorEventFactory extends EventFactory {
    @Override
    public Event createEvent(int deviceId, int componentId) {
        return new ErrorEvent(deviceId,componentId);
    }
}
