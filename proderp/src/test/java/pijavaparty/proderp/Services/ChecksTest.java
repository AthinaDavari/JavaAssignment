/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static pijavaparty.proderp.dao.TestUtilities.runTestScript;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author athina
 */
public class ChecksTest {

    public ChecksTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }

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

    /**
     * Test of checkRawQuantities method, of class Checks.
     */
    @Test
    public void testCheckRawQuantities() {
        System.out.println("checkRawQuantities");
        Checks instance = new Checks();
        List<RawMaterial> expResult = new LinkedList();
        Supplier s = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");

        expResult.add(new RawMaterial(3, "wood", 17, 3.7, s));
        expResult.add(new RawMaterial(6, "Steel", 7, 3.7, s));
        List<RawMaterial> result = instance.checkRawQuantities();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkProductQuantities method, of class Checks.
     */
    @Test
    public void testCheckProductQuantities() {
        System.out.println("checkProductQuantities");
        Checks instance = new Checks();
        List<Product> expResult = new LinkedList();
        expResult.add(new Product(1, "Orient City Classic", 10, 479.65));
        List<Product> result = instance.checkProductQuantities();
        assertEquals(expResult, result);
    }

}
