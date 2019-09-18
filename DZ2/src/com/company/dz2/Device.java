package com.company.dz2;

import java.util.ArrayList;

public class Device {
    private int id;
    private String name;
    private ArrayList<Component> components;
    private statuses status;

    //конструктор Device
    public Device(int id, String name,ArrayList<Component> components){
        this.id = id;
        this.name = name;
        this.components = components;
        this.status = statuses.NORMAL;
    }

    public void showDeviceInfo(){
        System.out.println("Device " + this.name + " info:");
        System.out.println("id: " + this.id);
        System.out.println("status: " + this.status);
        System.out.println("number of components: " +this.components.size());
        for (Component component:components) {
            System.out.println(component.toString());
        }
    }

    public Component getComponent(int componentId){
        return this.components.get(componentId);
    }

    public int getComponentsNumber(){
        return this.components.size();
    }

    public void showStatusChanged(){
        System.out.println("status of device " + this.name + "has changed on " + this.status);
    }
    public void setDeviceState(){
        int falseStatus = 0;
        //считываем информацию с компонентов
        for (Component component: components) {
            if (!component.getStatus()){
                falseStatus ++;
            }
        }

        // меняем статус девайса
        if(falseStatus == 0 && this.status!=statuses.NORMAL){
            this.status = statuses.NORMAL;
            showStatusChanged();
        }
        else if (falseStatus < this.components.size()% 2 && this.status!=statuses.WARNING){
            this.status = statuses.WARNING;
            showStatusChanged();
        }
        else if ( falseStatus>= this.components.size()% 2 && this.status!=statuses.ERROR){
            this.status = statuses.ERROR;
            showStatusChanged();
        }
    }
}


