/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Timestamp;
import static java.time.Instant.now;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class COrderDaoTest {

    /**
     *
     */
    public COrderDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }
    private final static User u = new User("natalia", "nat", "simpleuser");

    /**
     * Test of getAll method, of class COrderDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        COrderDao instance = new COrderDao();
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        Customer c2 = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        List<COrder> expResult = new LinkedList();
        expResult.add(new COrder(1, c1, "preparing", Timestamp.valueOf("2019-01-12 08:02:01"), u));
        expResult.add(new COrder(2, c2, "ready", Timestamp.valueOf("2019-05-12 11:02:59"), u));
        expResult.add(new COrder(3, c2, "delivered", Timestamp.valueOf("2017-02-28 17:02:01"), u));
        List<COrder> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllExceptFromDelivered method, of class COrderDao.
     */
    @Test
    public void btestGetAllExceptFromDelivered() {
        System.out.println("getAllExceptFromDelivered");
        COrderDao instance = new COrderDao();
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        Customer c2 = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        List<COrder> expResult = new LinkedList();
        expResult.add(new COrder(1, c1, "preparing", Timestamp.valueOf("2019-01-12 08:02:01"), u));
        expResult.add(new COrder(2, c2, "ready", Timestamp.valueOf("2019-05-12 11:02:59"), u));
        List<COrder> result = instance.getAllExceptFromDelivered();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class COrderDao.
     */
    @Test
    public void ctestGetById() {
        System.out.println("getById");
        int id = 1;
        COrderDao instance = new COrderDao();
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        COrder expResult = new COrder(1, c1, "preparing", Timestamp.valueOf("2019-01-12 08:02:01"), u);
        COrder result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test updateStatus method, of class COrderDao
     */
    @Test
    public void dtestUpdateStatus() {
        System.out.println("updateStatus");
        COrderDao instance = new COrderDao();
        int orderId = 2;
        String status = "deliverd";
        try {
            instance.updateStatus(orderId, status);
        } catch (Exception e) {
            System.out.println("Could not update staus to " + status);
        }
        status = "delivered";
        instance.updateStatus(orderId, status);
        assertEquals(status, instance.getById(2).getStatus());
    }

    /**
     * Test of insert method, of class COrderDao.
     */
    @Test
    public void etestInsert() {
        System.out.println("insert");
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        COrder co = new COrder(c1, u);
        COrderDao instance = new COrderDao();
        instance.insert(co);
        co.setId(4);
        COrder fromDatabase = instance.getById(4);
        fromDatabase.setCreated_at(null); // default Timestamp has already been tested for SOrder
        assertEquals(co, fromDatabase);
    }

    /**
     * Test of insertCOrderAndCOrderItems method, of class COrderDao.
     */
    @Test
    public void ftestInsertCOrderAndCOrderItems() {
        System.out.println("insertCOrderAndCOrderItems");
        COrderDao instance = new COrderDao();
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        Product p1 = new Product(1, "Orient City Classic", 10, 479.65);
        Product p2 = new Product(3, "Bullet Freestyle 20", 25, 235.69);
        COrder cOrder = new COrder(c1, u);
        COrderItem orderItem1 = new COrderItem(cOrder, p1, 12);
        COrderItem orderItem2 = new COrderItem(cOrder, p2, 18);
        List<COrderItem> orderItemsList = Arrays.asList(orderItem1, orderItem2);
        instance.insertCOrderAndCOrderItems(cOrder, orderItemsList);
        COrder fromDatabase = instance.getById(5);
        cOrder.setCreated_at(Timestamp.from(now()));
        cOrder.setId(5);
        assertEquals(cOrder.getCreated_at().getDate(), fromDatabase.getCreated_at().getDate());
        assertEquals(cOrder.getCustomer(), fromDatabase.getCustomer());
        assertEquals(cOrder.getStatus(), fromDatabase.getStatus());
        assertEquals(cOrder.getUser(), fromDatabase.getUser());
        COrderItemDao cOrderItemDao = new COrderItemDao();
        assertEquals(orderItem1.getProduct(), cOrderItemDao.getByIds(5, p1.getId()).getProduct());
        assertEquals(orderItem1.getQuantity(), cOrderItemDao.getByIds(5, p1.getId()).getQuantity());
        assertEquals(orderItem2.getProduct(), cOrderItemDao.getByIds(5, p2.getId()).getProduct());
        assertEquals(orderItem2.getQuantity(), cOrderItemDao.getByIds(5, p2.getId()).getQuantity());

    }

    /**
     * Test of bringTheIdOfTheLatestCOrder method, of class COrderDao.
     */
    @Test
    public void gtestBringTheIdOfTheLatestCOrder() {
        System.out.println("bringTheIdOfTheLatestCOrder");
        COrderDao instance = new COrderDao();
        int expResult = 5;
        int result = instance.bringTheIdOfTheLatestCOrder();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class COrderDao.
     */
    @Test
    public void htestDelete() {
        System.out.println("delete");
        int id = 2;
        COrderDao instance = new COrderDao();
        instance.delete(id);
        assertEquals(null, instance.getById(2));
    }

}
