/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Timestamp;
import static java.time.Instant.now;
import java.util.LinkedList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
public class SOrderDaoTest {

    public SOrderDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class SOrderDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        SOrderDao instance = new SOrderDao();
        List<SOrder> expResult = new LinkedList();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        expResult.add(new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43")));
        expResult.add(new SOrder(2, s2, "delivered", Timestamp.valueOf("2018-11-13 11:04:45")));
        expResult.add(new SOrder(3, s2, "pending", Timestamp.valueOf("2019-08-12 21:02:01")));
        expResult.add(new SOrder(4, s1, "delivered", Timestamp.valueOf("2019-08-16 09:02:43")));
        List<SOrder> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SOrderDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        SOrderDao instance = new SOrderDao();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        SOrder expResult = new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43"));
        SOrder result = instance.getById(id);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of update method, of class SOrderDao.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        SOrder s = null;
//        SOrderDao instance = new SOrderDao();
//        instance.update(s);
//    }
    /**
     * Test of insert method, of class SOrderDao.
     */
    @Test
    public void ctestInsert() {
        System.out.println("insert");
        SOrder so = new SOrder(new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr"), "pending");
        SOrderDao instance = new SOrderDao();
        Timestamp now = Timestamp.from(now());
        instance.insert(so);
        SOrder fromDatabase = instance.getById(5);
        int date = now.getDate();
        System.out.println(date);
        assertEquals(date, fromDatabase.getCreated_at().getDate());
        assertEquals(so.getStatus(), fromDatabase.getStatus());
        assertEquals(so.getSupplier(), fromDatabase.getSupplier());
    }
//
//    /**
//     * Test of bringTheIdOfTheLatestSOrder method, of class SOrderDao.
//     */
//    @Test
//    public void testBringTheIdOfTheLatestSOrder() {
//        System.out.println("bringTheIdOfTheLatestSOrder");
//        SOrderDao instance = new SOrderDao();
//        int expResult = 0;
//        int result = instance.bringTheIdOfTheLatestSOrder();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insertSOrderAndSOrderItems method, of class SOrderDao.
//     */
//    @Test
//    public void testInsertSOrderAndSOrderItems() {
//        System.out.println("insertSOrderAndSOrderItems");
//        SOrder so = null;
//        List<SOrderItem> soi = null;
//        SOrderDao instance = new SOrderDao();
//        instance.insertSOrderAndSOrderItems(so, soi);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateStatus method, of class SOrderDao.
//     */
//    @Test
//    public void testUpdateStatus() {
//        System.out.println("updateStatus");
//        int orderId = 0;
//        String status = "";
//        SOrderDao instance = new SOrderDao();
//        instance.updateStatus(orderId, status);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class SOrderDao.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        int id = 0;
//        SOrderDao instance = new SOrderDao();
//        instance.delete(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
