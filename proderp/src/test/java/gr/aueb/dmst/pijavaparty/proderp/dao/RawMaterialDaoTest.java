package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RawMaterialDaoTest {

    /**
     * An empty conrtuctor
     */
    public RawMaterialDaoTest() {
    }

    /**
     * Test - Set up
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class RawMaterialDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        RawMaterialDao instance = new RawMaterialDao();
        List<RawMaterial> expResult = new ArrayList();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        expResult.add(new RawMaterial(1, "plastic", 47, 0.25, s1));
        expResult.add(new RawMaterial(2, "metal", 32, 1.2, s2));
        expResult.add(new RawMaterial(3, "wood", 17, 3.7, s2));
        expResult.add(new RawMaterial(4, "Plastic", 47, 3.25, s2));
        expResult.add(new RawMaterial(5, "Titanium", 32, 15.2, s1));
        expResult.add(new RawMaterial(6, "Steel", 7, 3.7, s2));
        List<RawMaterial> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class RawMaterialDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        RawMaterialDao instance = new RawMaterialDao();
        RawMaterial expResult = new RawMaterial(1, "plastic", 47, 0.25, s1);
        RawMaterial result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class RawMaterialDao.
     */
    @Test
    public void ctestInsert() {
        System.out.println("insert");
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        RawMaterial r = new RawMaterial("steel", 54, 1.8, s1);
        RawMaterialDao instance = new RawMaterialDao();
        instance.insert(r);
        r.setId(7);
        assertEquals(r, instance.getById(7));
    }

    /**
     * Test of update method, of class RawMaterialDao.
     */
    @Test
    public void dtestUpdate() {
        System.out.println("update");
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        RawMaterial r = new RawMaterial(5, "TitaniumUpdated", 32, 17.2, s1);
        RawMaterialDao instance = new RawMaterialDao();
        instance.update(r);
        assertEquals(r, instance.getById(5));
    }
//
//    /**
//     * Test of update method, of class RawMaterialDao.
//     */
//    @Test
//    public void testUpdate_RawMaterial_int() {
//        System.out.println("update");
//        RawMaterial r = null;
//        int supId = 0;
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.update(r, supId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateName method, of class RawMaterialDao.
//     */
//    @Test
//    public void testUpdateName() {
//        System.out.println("updateName");
//        int id = 0;
//        String name = "";
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.updateName(id, name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateSupplier method, of class RawMaterialDao.
//     */
//    @Test
//    public void testUpdateSupplier_int_Supplier() {
//        System.out.println("updateSupplier");
//        int id = 0;
//        Supplier supplier = null;
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.updateSupplier(id, supplier);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateSupplier method, of class RawMaterialDao.
//     */
//    @Test
//    public void testUpdateSupplier_int_int() {
//        System.out.println("updateSupplier");
//        int id = 0;
//        int supId = 0;
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.updateSupplier(id, supId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

    /**
     * Test of updateQuantity method, of class RawMaterialDao.
     */
    @Test
    public void etestUpdateQuantity() {
        System.out.println("updateQuantity");
        int id = 3;
        int quantity = 12;
        RawMaterialDao instance = new RawMaterialDao();
        instance.updateQuantity(id, quantity);
        RawMaterial fromDataMaterial = instance.getById(3);
        assertEquals(12, fromDataMaterial.getQuantity());
    }
//
//    /**
//     * Test of updatePrice method, of class RawMaterialDao.
//     */
//    @Test
//    public void testUpdatePrice() {
//        System.out.println("updatePrice");
//        int id = 0;
//        double price = 0.0;
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.updatePrice(id, price);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePermanently method, of class RawMaterialDao.
//     */
//    @Test
//    public void testDeletePermanently() {
//        System.out.println("deletePermanently");
//        int id = 0;
//        RawMaterialDao instance = new RawMaterialDao();
//        instance.deletePermanently(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of delete method, of class RawMaterialDao.
     */
    @Test
    public void festDelete() {
        System.out.println("delete");
        int id = 2;
        RawMaterialDao instance = new RawMaterialDao();
        instance.delete(id);
        assertEquals(false, instance.getAll().contains(instance.getById(id)));
    }

}
