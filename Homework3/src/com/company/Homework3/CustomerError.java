package com.company.Homework3;

public class CustomerError extends RuntimeException {
    CustomerError(String message){
        super(message);
    }
}
