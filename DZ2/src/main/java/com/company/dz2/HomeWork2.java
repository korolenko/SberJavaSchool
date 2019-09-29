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
            try {
                switch (menu) {
                    case (1): {
                        coreUtils.createDevice(deviceCounter++);
                        //continue;
                    }
                    case (2): {
                        coreUtils.showDevice();
                        //continue;
                    }
                    case (3): {
                        coreUtils.createEvents();
                        //continue;
                    }
                    case (999): {
                        break;
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("wrong input");
            }
        }
    }
}
