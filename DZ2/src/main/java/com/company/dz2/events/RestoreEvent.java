package com.company.dz2.events;

import com.company.dz2.events.Event;

public class RestoreEvent extends Event {
    public RestoreEvent(int deviceId, int componentId){
        super(deviceId, componentId);
    }
}
