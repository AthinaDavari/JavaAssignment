/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
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
//        List<Supplier> expResult = null;
        List<Supplier> result = instance.getAll();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class SupplierDao.
     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        int id = 0;
//        SupplierDao instance = new SupplierDao();
//        Supplier expResult = null;
//        Supplier result = instance.getById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getByName method, of class SupplierDao.
//     */
//    @Test
//    public void testGetByName() {
//        System.out.println("getByName");
//        String name = "";
//        SupplierDao instance = new SupplierDao();
//        List<Supplier> expResult = null;
//        List<Supplier> result = instance.getByName(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insert method, of class SupplierDao.
//     */
//    @Test
//    public void testInsert() {
//        System.out.println("insert");
//        Supplier s = null;
//        SupplierDao instance = new SupplierDao();
//        instance.insert(s);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class SupplierDao.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Supplier s = null;
//        SupplierDao instance = new SupplierDao();
//        instance.update(s);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePerm method, of class SupplierDao.
//     */
//    @Test
//    public void testDeletePerm() {
//        System.out.println("deletePerm");
//        int id = 0;
//        SupplierDao instance = new SupplierDao();
//        instance.deletePerm(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class SupplierDao.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        int id = 0;
//        SupplierDao instance = new SupplierDao();
//        instance.delete(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}