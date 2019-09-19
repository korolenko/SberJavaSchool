package com.company.dz2;

/*
абстрактный класс для создания классов-событий ErrorEvent и RestoreEvent
 */
public abstract class Event {
    private int deviceId;
    private int componentId;

    Event(int deviceId, int componentId){
        this.deviceId = deviceId;
        this.componentId = componentId;
    }
    
    public int getDeviceId() {
        return deviceId;
    }

    public int getComponentId() {
        return componentId;
    }
}
