/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Natalia
 */
public class FillcomboTest {

    public FillcomboTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of fillcomboArray method, of class Fillcombo.
     */
    @Test
    public void testFillcomboArray() {
        System.out.println("fillcomboArray");
        ProductRawMaterialDao prmd = new ProductRawMaterialDao();
        Product prod = new Product(4, "Olmo Graffito 20", 33, 800.99);
        List<ProductRawMaterial> prodraw = prmd.getMaterialsPerProduct(prod.getId());
        Fillcombo instance = new Fillcombo();
        ArrayList<String> expResult = new ArrayList();
        expResult.add("plastic - 1");
        expResult.add("wood - 3");
        expResult.add("Plastic - 4");
        expResult.add("Titanium - 5");
        expResult.add("Steel - 6");
        ArrayList<String> result = instance.fillcomboArray(prodraw, prod);
        assertEquals(expResult, result);
    }

}
