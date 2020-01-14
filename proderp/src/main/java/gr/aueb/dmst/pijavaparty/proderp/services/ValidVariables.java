package gr.aueb.dmst.pijavaparty.proderp.services;

import java.util.regex.Pattern;

/**
 *
 * @author athinaDavari
 */
public class ValidVariables {

    /**
     *
     * @param str
     * @return
     */
    public static boolean isStringOnlyAlphabetAndWhiteSpaces(String str) {
        String pattern = "^[a-zA-Z]+((\\s[a-zA-Z]+))*$";
        String regex = "^[A-Za-z\\s]{4,}$";
        if (Pattern.matches(pattern, str) && Pattern.matches(regex, str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the string is a valid person's full name.
     *
     * @param fullname -the string we will check if it is a valid full name
     * @return true-string is valid full name, false-string isn't valid full name
     */
    public static boolean isValidFullName(String fullname) {
        String pattern = "([A-Z]([a-z]+){3,})+\\s+" //first name
                + "(([A-Z]([a-z]+){3,})+\\s)?+" //second name (if customer has second name)
                + "([A-Z]([a-z]+){3,})";         //last name  

        if (Pattern.matches(pattern, fullname)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param input 
     * @return
     */
    public static boolean isStringOnlyAlphabetAndNumbers(String input) {
        String pattern = "^[a-zA-Z][a-zA-Z0-9]{2,}$";
        if (Pattern.matches(pattern, input)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the string is a valid email
     *
     * @param email-the string we will check if it is a valid email
     * @return true-string is valid email, false-string isn't valid email
     */
    public static boolean isValidEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9]+" //local-part
                + "(\\.[a-zA-Z0-9]+)?"      //second part of local-part (starts with dot(.), if exists)
                + "@"                       //@
                + "[a-zA-Z0-9]+"            //second-level domain
                + "\\.+[a-zA-Z]{2,4}$";     //top-level domain

        if (Pattern.matches(emailRegex, email)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the string is a valid address
     *
     * @param address-the string we will check if it is a valid address
     * @return true-string is valid address, false-string isn't valid address
     */
    public static boolean isValidAddress(String address) {
        String pattern = "([A-Z]([a-z]+){3,32})+\\s"  //street
                + "+([A-Z][a-z]{3,32}+\\s)?"          //second part of street's name(if exists)
                + "+\\d{1,4}"                         //street number
                + ",{1}\\s[A-Z][a-z]{3,32}";          //city

        if (Pattern.matches(pattern, address)) {
            return true;
        }
        return false;
    }

    /**
     * Check if the string is a valid phonenumber
     * 
     * @param phonenumber-the string we will check if it is a valid phonenumber
     * @return true-string is valid phonenumber, false-string isn't valid phonenumber
     */
    public static boolean isValidPhonenumber(String phonenumber) {
        String PATTERN = "\\d{10}";
        if (phonenumber.matches(PATTERN) == true) {
            return true;
        } else {
            return false;

        }

    }

    /**
     * Check if the string is a integer
     * 
     * @param integer-the string we will check if it is a integer
     * @return true-string is integer, false-string isn't integer
     */
    public static boolean isValidInteger(String integer) {
        String pattern = "^[1-9]\\d*$";
        if (Pattern.matches(pattern, integer)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Check if the string is a double value
     * 
     * @param double_number-the string we will check if it is a
     * @return true-string is double, false-string isn't double
     */
    public static boolean isValidDouble(String double_number) {
        String pattern = "[0-9]+(\\.){1}[0-9]+";
        if (Pattern.matches(pattern, double_number)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the string is a valid password
     * 
     * @param password -the string we will check if it is a valid password
     * @return true-string is valid password, false-string isn't valid password
     */
    public static boolean isValidPassword(String password) {
        String pattern = "[A-Za-z0-9]{7,32}";

        if (Pattern.matches(pattern, password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean isStringOnlyAlphabetAndNumbersAndWhiteSpaces(String input) {
        String pattern = "^[a-zA-Z]+((\\s[a-zA-Z0-9]+))*$";
        String regex = "^[A-Za-z0-9\\s]{4,}$";
        if (Pattern.matches(pattern, input) && Pattern.matches(regex, input)) {
            return true;
        } else {
            return false;
        }
    }
}
