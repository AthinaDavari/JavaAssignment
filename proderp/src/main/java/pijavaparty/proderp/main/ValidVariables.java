/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.main;

import java.util.regex.Pattern;

/**
 *
 * @author athinaDavari
 */

public class ValidVariables {
    public static boolean isStringOnlyAlphabetAndWhiteSpaces(String str)
	{ 
	 if (str == null) {
		 return false;
	 }
	 return ((!str.replace(" " , "").equals("")
		            && (str.replace(" " , "").chars().allMatch(Character::isLetter))));
		
	}
 
 public static boolean isValidEmailAddress(String email)
 { //Έλεγχος αν το String είναι μία έγκυρη διεύθυνση email.
     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                         "[a-zA-Z0-9_+&*-]+)*@" +
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                         "A-Z]{2,7}$";
                           
     Pattern pat = Pattern.compile(emailRegex);
     if (email == null)
         return false;
     return pat.matcher(email).matches();
 }
}