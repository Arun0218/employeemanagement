package com.ideas2it.EmployeeDataManagment.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validations for some EmployeeDetails.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class ValidationUtil {

    public static String employeeId = "[1-9]+[0-9]*";
    public static String namePattern = "([A-Za-z]+)[ ]?([A-Za-z]+)[ ]?([A-Za-z]*)";
    public static String phoneNumberPattern = "[6-9][0-9]{9}";
    public static String emailPattern = "[a-z0-9_\\.]{2,}+[@]{1}[a-z]+[\\.]{1}([a-z]{2,3}|[a-z]{2,3}[\\.][a-z]{2,3})";
    public static String bloodGroupPattern = "(([ABO]|([A][B]))[+-])";
    public static String experience = "([0123]?[2-9]?[\\.]?[0-9]?[0-9]?)";

    public static boolean isValidDetail(String pattern, String fieldValue) {	

        return Pattern.matches(pattern, fieldValue);
    }

    public static boolean isValidDetail(String pattern, int fieldValue) {	

        return Pattern.matches(pattern, String.valueOf(fieldValue));
    }

    public static boolean isValidDetail(String pattern, long fieldValue) {	

        return Pattern.matches(pattern, String.valueOf(fieldValue));
    }

    public static boolean isValidDetail(String pattern, float fieldValue) {	

        return Pattern.matches(pattern, String.valueOf(fieldValue));
    }
}