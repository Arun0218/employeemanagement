package com.ideas2it.EmployeeDataManagment.custom;

public class InvalidInputException extends Exception {

    public InvalidInputException(String error) {
        super(error);
    }
}