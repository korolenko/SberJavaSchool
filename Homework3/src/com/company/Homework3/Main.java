package com.company.Homework3;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Cat> catList = new ArrayList<>();

    public static void serialization() throws IOException, ClassNotFoundException {
        System.out.println("The 1 part: serilization");
        Cat cat1 = new Cat(1,"Васька");
        //serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(cat1);
        ous.close();
        System.out.println("The object has been serialized");
        //deserialize
        ByteArrayInputStream bios = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bios);
        Cat cloneCat1 = (Cat)ois.readObject();
        System.out.println("The object has been deserialized");
        System.out.println("the original object: " + cat1.toString());
        System.out.println("the cloned object: " + cloneCat1.toString());
        System.out.println("==: " + (cat1==cloneCat1));
        System.out.println("equals: " + cat1.equals(cloneCat1));
    }
    public static void exception(int index){
        //checked exception
        int testArray[] = {1,2,3};
        int number;
        if (index > testArray.length - 1){
            throw new ArrayIndexOutOfBoundsException("index must be less than the array size");
        }
        else {
            System.out.println(testArray[index]);
        }
    }


    public static void callStackOverflow() {
        throw new StackOverflowError("You are trying to create stackoverflow");
    }

    public static void getCollectionClass() throws NoSuchFieldException {
        //get collection generic type
        System.out.println("collection generic type:");
        Field stringListField = Main.class.getDeclaredField("catList");
        ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
        Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
        System.out.println(stringListClass);
    }

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
            switch (menu) {
                case (1): {
                    serialization();
                    continue;
                }
                case (2): {
                    try {
                        exception(4);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }finally {
                       continue;
                    }
                }
                case (3): {
                    try {
                        callStackOverflow();
                    }catch (StackOverflowError e){
                        System.out.println(e.getMessage());
                    }finally {
                        continue;
                    }
                }
                case (4): {
                    getCollectionClass();
                    continue;
                }
                case (999): {
                    break;
                }
            }
        }
    }
}
