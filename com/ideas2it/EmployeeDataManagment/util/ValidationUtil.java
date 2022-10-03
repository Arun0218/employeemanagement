package com.ideas2it.EmployeeDataManagment.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validations for some EmployeeDetails.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class ValidationUtil {

    public static boolean isValidInput(String pattern, Object fieldValue) {	

        return Pattern.matches(pattern, String.valueOf(fieldValue));
    }
}