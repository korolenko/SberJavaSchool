package com.company.dz2;

/*
абстрактный класс для создания классов-событий ErrorEvent и RestoreEvent
 */
public abstract class Event {
    int deviceId;
    int componentId;

    public int getDeviceId() {
        return deviceId;
    }

    public int getComponentId() {
        return componentId;
    }
}
