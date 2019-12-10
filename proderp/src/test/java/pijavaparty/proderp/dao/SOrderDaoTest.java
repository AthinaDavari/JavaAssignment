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
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.SOrderItem;

/**
 *
 * @author Natalia
 */
public class SOrderDaoTest {
    
    public SOrderDaoTest() {
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
     * Test of getAll method, of class SOrderDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        SOrderDao instance = new SOrderDao();
        List<SOrder> expResult = null;
        List<SOrder> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class SOrderDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        SOrderDao instance = new SOrderDao();
        SOrder expResult = null;
        SOrder result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SOrderDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        SOrder s = null;
        SOrderDao instance = new SOrderDao();
        instance.update(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class SOrderDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        SOrder so = null;
        SOrderDao instance = new SOrderDao();
        instance.insert(so);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bringTheIdOfTheLatestSOrder method, of class SOrderDao.
     */
    @Test
    public void testBringTheIdOfTheLatestSOrder() {
        System.out.println("bringTheIdOfTheLatestSOrder");
        SOrderDao instance = new SOrderDao();
        int expResult = 0;
        int result = instance.bringTheIdOfTheLatestSOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertSOrderAndSOrderItems method, of class SOrderDao.
     */
    @Test
    public void testInsertSOrderAndSOrderItems() {
        System.out.println("insertSOrderAndSOrderItems");
        SOrder so = null;
        List<SOrderItem> soi = null;
        SOrderDao instance = new SOrderDao();
        instance.insertSOrderAndSOrderItems(so, soi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SOrderDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        SOrderDao instance = new SOrderDao();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
