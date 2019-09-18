package com.company.dz2;

public class ErrorEvent extends Event {
    public ErrorEvent(int deviceId, int componentId){
        this.deviceId = deviceId;
        this.componentId = componentId;
    }
}
