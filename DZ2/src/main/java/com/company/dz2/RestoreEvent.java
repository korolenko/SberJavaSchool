package com.company.dz2;

public class RestoreEvent extends Event {
    public RestoreEvent(int deviceId, int componentId){
        this.deviceId = deviceId;
        this.componentId = componentId;
    }
}
