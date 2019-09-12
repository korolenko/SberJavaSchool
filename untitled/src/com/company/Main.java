package com.company;

public class Main {

    public static void createFibonacciNumbers(int amount){
        int a,b,next;
        a = 0;
        b = 1;
        System.out.print(a + ", ");
        System.out.print(b + ", ");
        for (int i=0; i<amount; i++){
            next = a + b;
            System.out.print(next + ", ");
            a = b;
            b = next;
        }
    }
    public static void main(String[] args) {
        createFibonacciNumbers(5);
    }
}
