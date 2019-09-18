package com.company.dz2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Component laptopScreen = new Component(1,"laptopScreen",true);
        Component laptopKeyboard = new Component(2,"keyboard",true);
        Component laptopTouchpad = new Component(3,"laptopTouchpad",true);
        ArrayList<Component> componentList = new ArrayList<>();
        componentList.add(laptopScreen);
        componentList.add(laptopKeyboard);
        componentList.add(laptopTouchpad);
        Device laptop = new Device(1,"Laptop",componentList);
        //laptop.showDeviceInfo();*/
        CoreUtils coreUtils = new CoreUtils();
        coreUtils.createDevice(1);
        coreUtils.createDevice(2);
        //coreUtils.showDevice(1).showDeviceInfo();
        coreUtils.createEvents();
        coreUtils.setComponentStatus();
    }
}
