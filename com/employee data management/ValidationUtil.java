import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validations for some EmployeeDetails.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class ValidationUtil {

    static String employeeId = "[1-9]+[0-9]*";
    static String namePattern = "([A-Za-z]+)[ ]?([A-Za-z]+)[ ]?([A-Za-z]*)";
    static String phoneNumberPattern = "[6-9][0-9]{9}";
    static String emailPattern = "[a-z0-9_\\.]{8,22}+[@]{1}[a-z]+[\\.]{1}[a-z]{2,3}";
    static String bloodGroupPattern = "(([ABO]|([A][B]))[+-])";

    public static boolean isValidDetail(String pattern, String fieldValue) {	

        return Pattern.matches(pattern, fieldValue);
    }

}