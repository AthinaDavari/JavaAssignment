/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pijavaparty.proderp.entity.COrder;
import pijavaparty.proderp.entity.COrderItem;
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class COrderItemDaoTest {

    /**
     *
     */
    public COrderItemDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class COrderItemDao.
     */
    @Test
    public void atestGetAll() {
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
    public void btestGetByIds() {
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

    /**
     * Test of getItemsPerCOrder method, of class COrderItemDao.
     */
    @Test
    public void ctestGetItemsperCOrder() {
        System.out.println("getItemsPerCOrder");
        int coid = 3;
        Product p1 = new Product(5, "Scott Volt X20", 50, 1000.0);
        Product p2 = new Product(2, "GT Air 20", 32, 567.34);
        COrderItemDao instance = new COrderItemDao();
        List<COrderItem> expResult = new LinkedList();
        Customer c = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        COrder cOrder = new COrder(3, c, "delivered", Timestamp.valueOf("2017-02-28 17:02:01"),
                new User("natalia", "nat", "simpleuser"));
        expResult.add(new COrderItem(cOrder, p2, 49));
        expResult.add(new COrderItem(cOrder, p1, 100));
        List<COrderItem> result = instance.getItemsPerCOrder(coid);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class COrderItemDao.
     */
    @Test
    public void dtestInsert() {
        System.out.println("insert");
        Customer c = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        User u = new User("natalia", "nat", "simpleuser");
        Product p = new Product(3, "Bullet Freestyle 20", 25, 235.69);
        COrderItem coi = new COrderItem(new COrder(2, c, "ready", Timestamp.valueOf("2019-05-12 11:02:59"), u), p, 17);
        COrderItemDao instance = new COrderItemDao();
        instance.insert(coi);
        assertEquals(coi, instance.getByIds(2, 3));
    }

    /**
     * Test of delete method, of class COrderItemDao.
     */
    @Test
    public void etestDelete() {
        System.out.println("delete");
        int cordId = 3;
        int pId = 2;
        COrderItemDao instance = new COrderItemDao();
        instance.delete(cordId, pId);
        assertEquals(null, instance.getByIds(cordId, pId));
    }
}
