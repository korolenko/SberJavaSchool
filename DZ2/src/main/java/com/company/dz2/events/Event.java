package com.company.dz2.events;

/*
абстрактный класс для создания классов-событий ErrorEvent и RestoreEvent
 */
public abstract class Event {
    private int deviceId;
    private int componentId;

    public Event(int deviceId, int componentId){
        this.deviceId = deviceId;
        this.componentId = componentId;
    }
    
    public int getDeviceId() {
        return this.deviceId;
    }

    public int getComponentId() {
        return this.componentId;
    }
}
