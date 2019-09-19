package com.company.dz2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {

        int menu = 0;
        int deviceCounter = 0;
        System.out.println("~~~~Homework2~~~~");
        CoreUtils coreUtils = new CoreUtils();

        while (menu!=999){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1-add device");
            System.out.println("2-show device info");
            System.out.println("3-create events and change statuses");
            System.out.println("999 - exit");
            System.out.println("Enter number of action:..");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try {
                Scanner menuScaner = new Scanner(System.in);
                menu = menuScaner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Please,enter a number 1,2,3 or 999");

            }
            switch (menu){
                case (1):{
                    try {
                        coreUtils.createDevice(deviceCounter++);
                        continue;
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input");
                        continue;
                    }
                }
                case (2):{
                    if(coreUtils.getDeviceListSize() + 1< 1){
                        System.out.println("Create devices!");
                        continue;
                    }
                    else {
                        System.out.println("Enter device id (from 0 to " + coreUtils.getDeviceListSize() + "):..");
                        try {
                            Scanner deviceIdScanner = new Scanner(System.in);
                            coreUtils.showDevice(deviceIdScanner.nextInt());
                            continue;
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input");
                            continue;
                        }
                    }
                }
                case (3):{
                    if(coreUtils.getDeviceListSize() + 1< 1){
                        System.out.println("Create devices!");
                        continue;
                    }
                    else {
                        System.out.println("Enter number of events:..");
                        try {
                            Scanner eventNumberScanner = new Scanner(System.in);
                            coreUtils.createEvents(eventNumberScanner.nextInt());
                            continue;
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input");
                            continue;
                        }
                    }
                }
                case (999):{
                    break;
                }
                case (0):{
                    continue;
                }
            }
        }
    }
}
