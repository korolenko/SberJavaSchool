package com.company.Homework3;

public class CustomerError extends RuntimeException {
    private CustomerError(String message){
        super(message);
    }

    static void customerErrorVoid() {
        throw new CustomerError("This is customer runtime exception");
    }
}
