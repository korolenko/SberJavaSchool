package com.company.dz2.events;

import com.company.dz2.events.Event;

public class ErrorEvent extends Event {
    public ErrorEvent(int deviceId, int componentId) {
        super(deviceId, componentId);
    }
}
