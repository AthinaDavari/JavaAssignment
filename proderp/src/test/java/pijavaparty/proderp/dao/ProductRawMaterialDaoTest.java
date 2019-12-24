package pijavaparty.proderp.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static pijavaparty.proderp.dao.TestUtilities.runTestScript;
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author Athina Davari
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductRawMaterialDaoTest {

    private ProductDao pdao = new ProductDao();
    private RawMaterialDao rmdao = new RawMaterialDao();

    public ProductRawMaterialDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }

//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
    /**
     * Test of getAll method, of class ProductRawMaterialDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        List<ProductRawMaterial> expResult = new ArrayList<>();
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(3), 180));
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(4), 20));
        expResult.add(new ProductRawMaterial(pdao.getById(2), rmdao.getById(1), 78));
        expResult.add(new ProductRawMaterial(pdao.getById(3), rmdao.getById(4), 50));
        expResult.add(new ProductRawMaterial(pdao.getById(4), rmdao.getById(2), 39));
        List<ProductRawMaterial> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaterialsPerProduct method, of class ProductRawMaterialDao.
     */
    @Test
    public void btestGetMaterialsPerProduct() {
        System.out.println("getMaterialsPerProduct");
        int pid = 1;
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        List<ProductRawMaterial> expResult = new ArrayList<>();
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(3), 180));
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(4), 20));
        List<ProductRawMaterial> result = instance.getMaterialsPerProduct(pid);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class ProductRawMaterialDao.
     */
    @Test
    public void ctestInsert() {
        System.out.println("insert");
        ProductRawMaterial prm = new ProductRawMaterial(pdao.getById(2), rmdao.getById(2), 80);
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        instance.insert(prm);
        assertEquals(prm, instance.getByIds(2, 2));
    }

//    /**
//     * Test of insert method, of class ProductRawMaterialDao.
//     */
//    @Test
//    public void testInsert_3args() {
//        System.out.println("insert");
//        int pid = 0;
//        int rmid = 0;
//        int quantity = 0;
//        ProductRawMaterialDao instance = new ProductRawMaterialDao();
//        instance.insert(pid, rmid, quantity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of update method, of class ProductRawMaterialDao.
//     */
//    @Test
//    public void testUpdate_ProductRawMaterial() {
//        System.out.println("update");
//        ProductRawMaterial productRawMaterial = null;
//        ProductRawMaterialDao instance = new ProductRawMaterialDao();
//        instance.update(productRawMaterial);
//    }
//    /**
//     * Test of update method, of class ProductRawMaterialDao.
//     */
//    @Test
//    public void testUpdate_3args() {
//        System.out.println("update");
//        int pid = 0;
//        int rmid = 0;
//        int quantity = 0;
//        ProductRawMaterialDao instance = new ProductRawMaterialDao();
//        instance.update(pid, rmid, quantity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class ProductRawMaterialDao.
//     */
//    @Test
//    public void testDelete_ProductRawMaterial_prm() {
//        System.out.println("delete");
//        ProductRawMaterial prm = null;
//        ProductRawMaterialDao instance = new ProductRawMaterialDao();
//        instance.delete(prm);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of delete method, of class ProductRawMaterialDao.
     */
    @Test
    public void etestDelete() {
        System.out.println("delete");
        int pid = 4;
        int rmid = 2;
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        instance.delete(pid, rmid);
        assertEquals(null, instance.getByIds(pid, rmid));
    }

    /**
     * Test of getByIds method, of class ProductRawMaterialDao.
     */
    @Test
    public void dtestGetByIds() {
        System.out.println("getByIds");
        int pid = 2;
        int rmid = 1;
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        ProductRawMaterial expResult = new ProductRawMaterial(pdao.getById(2), rmdao.getById(1), 78);
        ProductRawMaterial result = instance.getByIds(pid, rmid);
        assertEquals(expResult, result);
    }

}
