/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.Services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author athina
 */
public class ChecksTest {
    
    /**
     *
     */
    public ChecksTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }

    /**
     * Test of CheckIfRawMaterialIsUsed method, of class Checks.
     */
    @Test
    public void testCheckIfRawMaterialIsUsed() {
        System.out.println("CheckIfRawMaterialIsUsed");
        int id = 1;
        Checks instance = new Checks();
        boolean expResult = true;
        boolean result = instance.checkIfRawMaterialIsUsed(id);
        assertEquals(expResult, result);

    }
    
}
