package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.sql.Timestamp;
import static java.time.Instant.now;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SOrderDaoTest {

    /**
     * An empty conrtuctor
     */
    public SOrderDaoTest() {
    }

    /**
     * Test - Set up
     */
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
        List<SOrder> expResult = new ArrayList();
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
     * Test of getAllPendingOrders method, of class SOrderDao.
     */
    @Test
    public void btestgetAllPendingOrders() {
        System.out.println("getAllPendingOrders");
        SOrderDao instance = new SOrderDao();
        List<SOrder> expResult = new ArrayList();
        Supplier s1 = new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        expResult.add(new SOrder(1, s1, "pending", Timestamp.valueOf("2019-12-14 20:02:43")));
        expResult.add(new SOrder(3, s2, "pending", Timestamp.valueOf("2019-08-12 21:02:01")));
        List<SOrder> result = instance.getAllPendingOrders();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SOrderDao.
     */
    @Test
    public void ctestGetById() {
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
    public void dtestInsert() {
        System.out.println("insert");
        SOrder so = new SOrder(new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr"), "pending");
        SOrderDao instance = new SOrderDao();
        Timestamp now = Timestamp.from(now());
        instance.insert(so);
        SOrder fromDatabase = instance.getById(5);
        int date = now.getDate();
        assertEquals(date, fromDatabase.getCreated_at().getDate());
        assertEquals(so.getStatus(), fromDatabase.getStatus());
        assertEquals(so.getSupplier(), fromDatabase.getSupplier());
    }

    /**
     * Test of bringTheIdOfTheLatestSOrder method, of class SOrderDao.
     */
    @Test
    public void etestBringTheIdOfTheLatestSOrder() {
        System.out.println("bringTheIdOfTheLatestSOrder");
        SOrderDao instance = new SOrderDao();
        int expResult = 5;
        int result = instance.bringTheIdOfTheLatestSOrder();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertSOrderAndSOrderItems method, of class SOrderDao.
     */
    @Test
    public void ftestInsertSOrderAndSOrderItems() {
        System.out.println("insertSOrderAndSOrderItems");
        Supplier s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        RawMaterial rm1 = new RawMaterial(2, "metal", 32, 1.2, s2);
        RawMaterial rm2 = new RawMaterial(3, "wood", 17, 3.7, s2);
        SOrder so = new SOrder(s2);
        SOrderItemDao dao = new SOrderItemDao();
        SOrderItem orderItem1 = new SOrderItem(so, rm1, 11);
        SOrderItem orderItem2 = new SOrderItem(so, rm2, 17);
        List<SOrderItem> soi = Arrays.asList(orderItem1, orderItem2);
        SOrderDao instance = new SOrderDao();
        instance.insertSOrderAndSOrderItems(so, soi);
        SOrder fromDatabase = instance.getById(6);
        so.setCreated_at(Timestamp.from(now()));
        so.setId(6);
        assertEquals(so.getCreated_at().getDate(), fromDatabase.getCreated_at().getDate());
        assertEquals(so.getSupplier(), fromDatabase.getSupplier());
        assertEquals(so.getStatus(), fromDatabase.getStatus());
        assertEquals(orderItem1.getRawmaterial(), dao.getByIds(6, rm1.getId()).getRawmaterial());
        assertEquals(orderItem1.getQuantity(), dao.getByIds(6, rm1.getId()).getQuantity());
        assertEquals(orderItem2.getRawmaterial(), dao.getByIds(6, rm2.getId()).getRawmaterial());
        assertEquals(orderItem2.getQuantity(), dao.getByIds(6, rm2.getId()).getQuantity());
    }

    /**
     * Test of updateStatus method, of class SOrderDao.
     */
    @Test
    public void gtestUpdateStatus() {
        System.out.println("updateStatus");
        int orderId = 5;
        String status = "delivered";
        SOrderDao instance = new SOrderDao();
        instance.updateStatus(5, status);
        assertEquals(status, instance.getById(orderId).getStatus());
    }

    /**
     * Test of delete method, of class SOrderDao.
     */
    @Test
    public void htestDelete() {
        System.out.println("delete");
        int id = 5;
        SOrderDao instance = new SOrderDao();
        instance.delete(id);
        assertEquals(null, instance.getById(id));
    }

}
