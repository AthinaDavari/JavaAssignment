/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierDaoTest {

    public SupplierDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class SupplierDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        SupplierDao instance = new SupplierDao();
        List<Supplier> expResult = new LinkedList();
        expResult.add(new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr"));
        expResult.add(new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr"));
        List<Supplier> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SupplierDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 2;
        SupplierDao instance = new SupplierDao();
        Supplier expResult = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        Supplier result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getByName method, of class SupplierDao.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "PetaloudaA.E.";
        SupplierDao instance = new SupplierDao();
        List<Supplier> expResult = new LinkedList();
        expResult.add(new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr"));
        List<Supplier> result = instance.getByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class SupplierDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Supplier s = new Supplier(3, "GoldSuppl", "Panepistimiou 27", 2105454554l, "info@gold.gr");
        SupplierDao instance = new SupplierDao();
        instance.insert(s);
        assertEquals(s, instance.getById(3));
    }

    /**
     * Test of update method, of class SupplierDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Supplier s = new Supplier(3, "GoldSupplUpdated", "Panepistimiou 30", 2105454554l, "info@gold.gr");
        SupplierDao instance = new SupplierDao();
        instance.update(s);
        assertEquals(s, instance.getById(3));
    }

    /**
     * Test of delete method, of class SupplierDao.
     */
    @Test
    public void xtestDelete() {
        System.out.println("delete");
        int id = 3;
        SupplierDao instance = new SupplierDao();
        instance.delete(id);
        assertEquals(new Supplier(3, "GoldSupplUpdated", "Panepistimiou 30", -1l, "info@gold.gr"), instance.getById(3));
    }

    /**
     * Test of deletePerm method, of class SupplierDao.
     */
    @Test
    public void ztestDeletePermanently() {
        System.out.println("deletePermanently");
        int id = 3;
        SupplierDao instance = new SupplierDao();
        instance.deletePermanently(id);
        assertEquals(null, instance.getById(3));
    }

}
