package com.company.dz2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Device {
    private int id;
    private String name;
    private ArrayList<Component> components;
    private statuses status;
    private Logger logger = LoggerFactory.getLogger(Device.class);

    public Device(int id, String name,ArrayList<Component> components){
        this.id = id;
        this.name = name;
        this.components = components;
        setDeviceState();
    }

    public void showDeviceInfo(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
        logger.info("Device id = " + this.id + " , name = " + this.name + " has changed status on " + this.status);
    }
    public void setDeviceState(){
        int falseStatus = 0;
        //считываем информацию с компонентов
        for (Component component: components) {
            if (!component.getStatus()){
                falseStatus ++;
            }
        }

        // меняем статус девайса по заданным правилам
        if(falseStatus == 0 && this.status!=statuses.NORMAL){
            this.status = statuses.NORMAL;
            showStatusChanged();
        }
        else if (falseStatus < this.components.size()/ 2.0 && this.status!=statuses.WARNING){
            this.status = statuses.WARNING;
            showStatusChanged();
        }
        else if ( falseStatus>= this.components.size()/ 2.0 && this.status!=statuses.ERROR){
            this.status = statuses.ERROR;
            showStatusChanged();
        }
    }
}


