package com.company.Homework4;

public class Main {

    public static void main(String[] args) {
        ListClass listClass = new ListClass();
        System.out.println("list has been created: ");
        System.out.println(listClass.toString());
        listClass.deleteWitoutStream();
        System.out.println("list after deleting without streamAPI: ");
        System.out.println(listClass.toString() +"\n");

        ListClass listClass2 = new ListClass();
        System.out.println("another list has been created: ");
        System.out.println(listClass2.toString());
        listClass2.deleteWithStream();
        System.out.println("list after deleting with streamAPI: ");
        System.out.println(listClass2.toString());
    }
}
