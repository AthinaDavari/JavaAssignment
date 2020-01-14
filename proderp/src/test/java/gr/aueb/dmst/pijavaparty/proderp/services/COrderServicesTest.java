/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Customer;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalia
 */
public class COrderServicesTest {
    /**
     * An empty conrtuctor
     */    
    public COrderServicesTest() {
    }
    /**
     * Test - Set up
     */    
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of rawMaterialsNotIncludedInSuppliersOrder method, of class COrderServices.
     */
    @Test
    public void testRawMaterialsNotIncludedInSuppliersOrder() {
        System.out.println("rawMaterialsNotIncludedInSuppliersOrder");
        List<COrderItem> prod = new ArrayList();
        COrder cOrder = new COrder(new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com"), 
                new User("Natalia", "nat", "simpleuser"));
        prod.add(new COrderItem(cOrder, new Product(2, "GT Air 20", 32, 567.34), 16));
        prod.add(new COrderItem(cOrder, new Product(4, "Olmo Graffito 20", 33, 800.99), 3));
        ArrayList<String> expResult = new ArrayList();
        expResult.add("1-Orient City Classic");
        expResult.add("3-Bullet Freestyle 20");
        expResult.add("5-Scott Volt X20");
        ArrayList<String> result = COrderServices.rawMaterialsNotIncludedInSuppliersOrder(prod);
        assertEquals(expResult, result);
    }
    
}
