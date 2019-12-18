/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import pijavaparty.proderp.entity.COrder;
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class COrderDaoTest {

    public COrderDaoTest() {
    }

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
     * Test of getById method, of class COrderDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        COrderDao instance = new COrderDao();
        Customer c1 = new Customer(3, "BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        COrder expResult = new COrder(1, c1, "preparing", Timestamp.valueOf("2019-01-12 08:02:01"), u);
        COrder result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class COrderDao.
     */
    @Test
    public void ctestInsert() {
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
     * Test of delete method, of class COrderDao.
     */
    @Test
    public void dtestDelete() {
        System.out.println("delete");
        int id = 2;
        COrderDao instance = new COrderDao();
        instance.delete(id);
        assertEquals(null, instance.getById(2));
    }
    
}
