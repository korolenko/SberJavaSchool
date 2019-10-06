package com.company.Homework3;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.company.Homework3.CustomerCheckedException.exception;
import static com.company.Homework3.CustomerError.customerErrorVoid;
import static com.company.Homework3.GetCollectionClass.getCollection;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException {
        System.out.println("Welcome to Homework3!");
        int menu = 0;
        while (menu!=999){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1-serialization");
            System.out.println("2-checked exception");
            System.out.println("3-unchecked exception");
            System.out.println("4-collection generic type");
            System.out.println("999-exit");
            System.out.println("Enter command number:..");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try {
                Scanner menuScaner = new Scanner(System.in);
                menu = menuScaner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Please,enter a number 1,2,3,4 or 999");
            }
            try {
                switch (menu) {
                    case (1): {
                        SerializationClass.serialization();
                        continue;
                    }
                    case (2): {
                        exception(4);
                    }
                    case (3): {
                        customerErrorVoid();
                    }
                    case (4): {
                        getCollection();
                        continue;
                    }
                    case (999): {
                        break;
                    }
                }
            }catch (CustomerError | CustomerCheckedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
