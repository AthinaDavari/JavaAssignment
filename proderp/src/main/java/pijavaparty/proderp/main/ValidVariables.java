/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.main;

import java.util.regex.Matcher;
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
        if (str == null) {
            return false;
        }
        return ((!str.replace(" ", "").equals("")
                && (str.replace(" ", "").chars().allMatch(Character::isLetter))));

    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(String email) { //Έλεγχος αν το String είναι μία έγκυρη διεύθυνση email.
        String emailRegex = "^[a-zA-Z0-9]+(?:\\."
                + "[a-zA-Z0-9]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    /**
     *
     * @param phonenumber
     * @return
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
     *
     * @param integer
     * @return
     */
    public static boolean isValidInteger(String integer){
       String pattern = "^[1-9]\\d*$";
       if (Pattern.matches(pattern, integer)){
           return true;
       } else {
           return false;
       }
        
    }

    /**
     *
     * @param double_number
     * @return
     */
    public static boolean isValidDouble(String double_number){
         String pattern="[0-9]+(\\.){1}[0-9]+";
          if (Pattern.matches(pattern, double_number)){
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
    public static boolean isStringOnlyAlphabetAndNumbersAndWhiteSpaces(String input){
         String pattern="^[a-zA-Z]+((\\s[a-zA-Z0-9]+))*$";
         String regex="^[A-Za-z0-9\\s]{4,}$";
         if(Pattern.matches(pattern,input) && Pattern.matches(regex,input)){
             return true;
         } else {
             return false;
         }
     }
}
