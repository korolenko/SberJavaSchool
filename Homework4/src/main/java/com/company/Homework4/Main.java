package com.company.Homework4;

public class Main {

    public static void main(String[] args) {
        ListClass listClass = new ListClass();
        System.out.println("list has been created: ");
        System.out.println(listClass.toString());
        System.out.println("list after deleting without streamAPI: ");
        System.out.println(listClass.deleteWitoutStream().toString() +"\n");

        ListClass listClass2 = new ListClass();
        System.out.println("another list has been created: ");
        System.out.println(listClass2.toString());
        System.out.println("list after deleting with streamAPI: ");
        System.out.println(listClass2.deleteWithStream().toString());
    }
}
