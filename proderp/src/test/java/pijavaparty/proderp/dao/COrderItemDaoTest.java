/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pijavaparty.proderp.entity.COrder;
import pijavaparty.proderp.entity.COrderItem;
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author Natalia
 */
public class COrderItemDaoTest {

    public COrderItemDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class COrderItemDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        COrderItemDao instance = new COrderItemDao();
        Customer c = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        COrder cOrder = new COrder(3, c, "delivered", Timestamp.valueOf("2017-02-28 17:02:01"),
                new User("natalia", "nat", "simpleuser"));
        Product p1 = new Product(5, "Scott Volt X20", 50, 1000.0);
        Product p2 = new Product(2, "GT Air 20", 32, 567.34);
        List<COrderItem> expResult = new LinkedList();
        expResult.add(new COrderItem(cOrder, p2, 49));
        expResult.add(new COrderItem(cOrder, p1, 100));

        List<COrderItem> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getByIds method, of class COrderItemDao.
     */
    @Test
    public void testGetByIds() {
        System.out.println("getByIds");
        int coid = 3;
        int prid = 2;
        Customer c = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        COrder cOrder = new COrder(3, c, "delivered", Timestamp.valueOf("2017-02-28 17:02:01"),
                new User("natalia", "nat", "simpleuser"));
        Product p = new Product(2, "GT Air 20", 32, 567.34);
        COrderItemDao instance = new COrderItemDao();
        COrderItem expResult = new COrderItem(cOrder, p, 49);
        COrderItem result = instance.getByIds(coid, prid);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getItemsperCOrder method, of class COrderItemDao.
//     */
//    @Test
//    public void testGetItemsperCOrder() {
//        System.out.println("getItemsperCOrder");
//        int coid = 0;
//        COrderItemDao instance = new COrderItemDao();
//        List<COrderItem> expResult = null;
//        List<COrderItem> result = instance.getItemsperCOrder(coid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insert method, of class COrderItemDao.
//     */
//    @Test
//    public void testInsert() {
//        System.out.println("insert");
//        COrderItem coi = null;
//        COrderItemDao instance = new COrderItemDao();
//        instance.insert(coi);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class COrderItemDao.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        int cordId = 0;
//        int pId = 0;
//        COrderItemDao instance = new COrderItemDao();
//        instance.delete(cordId, pId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
