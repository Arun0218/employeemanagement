package com.ideas2it.EmployeeDataManagment.exception;

public class CustomException {

    public static class InvalidInputException extends Exception {

        public InvalidInputException(String error) {
            super(error);
        }
    }

    public static class ValueExistException extends Exception {

        public ValueExistException(String error) {
            super(error);
        }
    }
}