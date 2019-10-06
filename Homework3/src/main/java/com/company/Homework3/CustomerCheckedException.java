package com.company.Homework3;

public class CustomerCheckedException extends Exception {
    private CustomerCheckedException(String message){
        super(message);
    }

    public static void exception(int index) throws CustomerCheckedException {
        //checked exception
        int[] testArray = {1, 2, 3};
        int number;
        if (index > (testArray.length - 1)){
            throw new CustomerCheckedException("index must be less than the array size");
        }
        else System.out.println(testArray[index]);
    }
}
