/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.services;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalia
 */
public class ValidVariablesTest {
    
    public ValidVariablesTest() {
    }

    /**
     * Test of isStringOnlyAlphabetAndWhiteSpaces method, of class ValidVariables.
     */
    @Test
    public void testIsStringOnlyAlphabetAndWhiteSpaces() {
        System.out.println("isStringOnlyAlphabetAndWhiteSpaces");
        String str = "52374ggs";
        boolean expResult = false;
        boolean result = ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidFullName method, of class ValidVariables.
     */
    @Test
    public void testIsValidFullName() {
        System.out.println("isValidFullName");
        String fullName = "Aliki Manou";
        boolean expResult = true;
        boolean result = ValidVariables.isValidFullName(fullName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isStringOnlyAlphabetAndNumbers method, of class ValidVariables.
     */
    @Test
    public void testIsStringOnlyAlphabetAndNumbers() {
        System.out.println("isStringOnlyAlphabetAndNumbers");
        String fullName = "Ali8";
        boolean expResult = true;
        boolean result = ValidVariables.isStringOnlyAlphabetAndNumbers(fullName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidEmailAddress method, of class ValidVariables.
     */
    @Test
    public void testIsValidEmailAddress() {
        System.out.println("isValidEmailAddress");
        String email = "hg5";
        boolean expResult = false;
        boolean result = ValidVariables.isValidEmailAddress(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidAddress method, of class ValidVariables.
     */
    @Test
    public void testIsValidAddress() {
        System.out.println("isValidAddress");
        String address = "Trion Ierarxon 86, Larissa";
        boolean expResult = true;
        boolean result = ValidVariables.isValidAddress(address);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidPhonenumber method, of class ValidVariables.
     */
    @Test
    public void testIsValidPhonenumber() {
        System.out.println("isValidPhonenumber");
        String phonenumber = "gd566666666666666666666666666666666666666";
        boolean expResult = false;
        boolean result = ValidVariables.isValidPhonenumber(phonenumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidInteger method, of class ValidVariables.
     */
    @Test
    public void testIsValidInteger() {
        System.out.println("isValidInteger");
        String integer = "6.8";
        boolean expResult = false;
        boolean result = ValidVariables.isValidInteger(integer);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDouble method, of class ValidVariables.
     */
    @Test
    public void testIsValidDouble() {
        System.out.println("isValidDouble");
        String double_number = "Mary";
        boolean expResult = false;
        boolean result = ValidVariables.isValidDouble(double_number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidPassword method, of class ValidVariables.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        String input = ".%6gwdye";
        boolean expResult = false;
        boolean result = ValidVariables.isValidPassword(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of isStringOnlyAlphabetAndNumbersAndWhiteSpaces method, of class ValidVariables.
     */
    @Test
    public void testIsStringOnlyAlphabetAndNumbersAndWhiteSpaces() {
        System.out.println("isStringOnlyAlphabetAndNumbersAndWhiteSpaces");
        String input = ".%6gwdye";
        boolean expResult = false;
        boolean result = ValidVariables.isStringOnlyAlphabetAndNumbersAndWhiteSpaces(input);
        assertEquals(expResult, result);
    }
    
}
