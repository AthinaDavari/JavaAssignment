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
         String pattern="^[a-zA-Z]+((\\s[a-zA-Z]+))*$";
         String regex="^[A-Za-z\\s]{4,}$";
         if(Pattern.matches(pattern,str) && Pattern.matches(regex,str)){
             return true;
         } else {
             return false;
         }
    }
    
    public static boolean isValidFullName(String str) {
         String pattern="([A-Z]([a-z]+){3,})+\\s+"       //first name
        		+ "(([A-Z]([a-z]+){3,})+\\s)?+"  //second name (if customer has second name)
        		+ "([A-Z]([a-z]+){3,})";         //last name  

        if(Pattern.matches(pattern,str)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isStringOnlyAlphabetAndNumbers(String input) {
        String pattern="^[a-zA-Z][a-zA-Z0-9]{2,}$";
         if(Pattern.matches(pattern,input)){
             return true;
         } else {
             return false;
         }
    }

    /**
     * Check if the string is a valid email 
     * @param email
     * @return true-string is valid email,
     * false-string isn't valid email
     */
    public static boolean isValidEmailAddress(String email) {
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
    
    public static boolean isValidPassword(String str) {
        String pattern= "[A-Za-z0-9]{7,32}";

        if(Pattern.matches(pattern,str)) {
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
