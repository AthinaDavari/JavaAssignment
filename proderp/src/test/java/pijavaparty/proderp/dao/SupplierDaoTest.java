/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierDaoTest {

    /**
     *
     */
    public SupplierDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class SupplierDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        SupplierDao instance = new SupplierDao();
        List<Supplier> expResult = new ArrayList();
        expResult.add(new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr"));
        expResult.add(new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr"));
        expResult.add(new Supplier(3, "Titanium Fabrication Corporation", "Palaiologou 156", 2103789023l, "info@tfc.gr"));
        List<Supplier> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SupplierDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        SupplierDao instance = new SupplierDao();
        Supplier expResult = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        Supplier result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRawMaterialsPerSupplier, of class SupplierDao.
     */
    @Test
    public void ctestGetRawMaterialsPerSupplier() {
        System.out.println("getRawMaterialsPerSupplier");
        int id = 1;
        SupplierDao instance = new SupplierDao();
        List<RawMaterial> expResult = new ArrayList();
        Supplier s = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        expResult.add(new RawMaterial(1, "plastic", 47, 0.25, s));
        expResult.add(new RawMaterial(5, "Titanium", 32, 15.2, s));
        List<RawMaterial> result = instance.getRawMaterialsPerSupplier(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class SupplierDao.
     */
    @Test
    public void dtestInsert() {
        System.out.println("insert");
        Supplier s = new Supplier("GoldSuppl", "Panepistimiou 27", 2105454554l, "info@gold.gr");
        SupplierDao instance = new SupplierDao();
        instance.insert(s);
        s.setId(4);
        assertEquals(s, instance.getById(4));
    }

    /**
     * Test of update method, of class SupplierDao.
     */
    @Test
    public void etestUpdate() {
        System.out.println("update");
        Supplier s = new Supplier(2, "PetaloudUpdatedaA.E.", "Palaiologou 156", 2103789023l, "info@petalnew.gr");
        SupplierDao instance = new SupplierDao();
        instance.update(s);
        assertEquals(s, instance.getById(2));
    }

    /**
     * Test of delete method, of class SupplierDao.
     */
    @Test
    public void ftestDelete() {
        System.out.println("delete");
        int id = 3;
        SupplierDao instance = new SupplierDao();
        instance.delete(id);
        assertEquals(false, instance.getAll().contains(instance.getById(3)));
    }

//    /**
//     * Test of deletePerm method, of class SupplierDao.
//     */
//    @Test
//    public void ftestDeletePermanently() {
//        System.out.println("deletePermanently");
//        int id = 3;
//        SupplierDao instance = new SupplierDao();
//        instance.deletePermanently(id);
//        assertEquals(null, instance.getById(3));
//    }
}
