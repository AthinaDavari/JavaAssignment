package gr.aueb.dmst.pijavaparty.proderp.services;

import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

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
        List<RawMaterial> expResult = new ArrayList();
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
        List<Product> expResult = new ArrayList();
        expResult.add(new Product(1, "Orient City Classic", 10, 479.65));
        List<Product> result = instance.checkProductQuantities();
        assertEquals(expResult, result);
    }

}
