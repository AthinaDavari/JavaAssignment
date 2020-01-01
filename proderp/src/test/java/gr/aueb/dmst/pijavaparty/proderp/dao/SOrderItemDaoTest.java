/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.sql.Timestamp;
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
public class SOrderItemDaoTest {

    public SOrderItemDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class SOrderItemDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        SOrderItemDao instance = new SOrderItemDao();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        SOrder sOrder1 = new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43"));
        SOrder sOrder2 = new SOrder(3, s2, "pending", Timestamp.valueOf("2019-08-12 21:02:01"));
        List<SOrderItem> expResult = new ArrayList();
        expResult.add(new SOrderItem(sOrder1, new RawMaterial(1, "plastic", 47, 0.25, s1), 35));
        expResult.add(new SOrderItem(sOrder1, new RawMaterial(5, "Titanium", 32, 15.2, s1), 48));
        expResult.add(new SOrderItem(sOrder2, new RawMaterial(4, "Plastic", 47, 3.25, s2), 12));
        List<SOrderItem> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getByIds method, of class SOrderItemDao.
     */
    @Test
    public void btestGetByIds() {
        System.out.println("getByIds");
        int soid = 1;
        int rmid = 5;
        SOrderItemDao instance = new SOrderItemDao();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        SOrder sOrder1 = new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43"));
        SOrderItem expResult = new SOrderItem(sOrder1, new RawMaterial(5, "Titanium", 32, 15.2, s1), 48);
        SOrderItem result = instance.getByIds(soid, rmid);
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemsperSOrder method, of class SOrderItemDao.
     */
    @Test
    public void ctestGetItemsperSOrder() {
        System.out.println("getItemsperSOrder");
        int soid = 1;
        SOrderItemDao instance = new SOrderItemDao();
        List<SOrderItem> expResult = new ArrayList();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        SOrder sOrder1 = new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43"));
        expResult.add(new SOrderItem(sOrder1, new RawMaterial(1, "plastic", 47, 0.25, s1), 35));
        expResult.add(new SOrderItem(sOrder1, new RawMaterial(5, "Titanium", 32, 15.2, s1), 48));
        List<SOrderItem> result = instance.getItemsperSOrder(soid);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class SOrderItemDao.
     */
    @Test
    public void dtestInsert() {
        System.out.println("insert");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        SOrder sOrder2 = new SOrder(3, s2, "pending", Timestamp.valueOf("2019-08-12 21:02:01"));
        SOrderItem soi = new SOrderItem(sOrder2, new RawMaterial(3, "wood", 17, 3.7, s2), 17);
        SOrderItemDao instance = new SOrderItemDao();
        instance.insert(soi);
        assertEquals(soi, instance.getByIds(sOrder2.getId(), soi.getRawmaterial().getId()));
    }

    /**
     * Test of increaseQuantities method, of class SOrderItemDao.
     */
    @Test
    public void etestIncreaseQuantities() {
        System.out.println("increaseQuantities");
        RawMaterialDao rmd = new RawMaterialDao();
        int orderId = 1;
        int item1Quantity = rmd.getById(1).getQuantity();
        int item5Quantity = rmd.getById(5).getQuantity();
        SOrderItemDao instance = new SOrderItemDao();
        instance.increaseQuantities(orderId);
        assertEquals(item1Quantity + 35, rmd.getById(1).getQuantity());
        assertEquals(item5Quantity + 48, rmd.getById(5).getQuantity());
    }

    /**
     * Test of delete method, of class SOrderItemDao.
     */
    @Test
    public void ftestDelete() {
        System.out.println("delete");
        int sordId = 3;
        int rawMId = 4;
        SOrderItemDao instance = new SOrderItemDao();
        instance.delete(sordId, rawMId);
        assertEquals(null, instance.getByIds(sordId, rawMId));
    }
}
