/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalia
 */
public class SOrderServicesTest {
    
    public SOrderServicesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }
    
    /**
     * Test of rawMaterialsNotIncludedInSuppliersOrder method, of class SOrderServices.
     */
    @Test
    public void testRawMaterialsNotIncludedInSuppliersOrder() {
        System.out.println("rawMaterialsNotIncludedInSuppliersOrder");
        Supplier sup = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        SOrder sorder = new SOrder(sup);
        List<SOrderItem> rawmat = new ArrayList();
        rawmat.add(new SOrderItem(sorder, new RawMaterial(2, "metal", 32, 1.2, sup), 8));
        rawmat.add(new SOrderItem(sorder, new RawMaterial(6, "Steel", 7, 3.7, sup), 12));        
        ArrayList<String> expResult = new ArrayList();
        expResult.add("3-wood");
        expResult.add("4-Plastic");
        ArrayList<String> result = SOrderServices.rawMaterialsNotIncludedInSuppliersOrder(rawmat, sup);
        assertEquals(expResult, result);
    }
    
}
