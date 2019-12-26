/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author athina
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
    
    /**
     *
     */
    public ProductDaoTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
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
     * Test of getAll method, of class ProductDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        ProductDao instance = new ProductDao();
        List<Product> expResult = new ArrayList<>();
        expResult.add(new Product(1, "Orient City Classic", 10, 479.65));
        expResult.add(new Product(2, "GT Air 20", 32, 567.34));
        expResult.add(new Product(3, "Bullet Freestyle 20", 25, 235.69));
        expResult.add(new Product(4, "Olmo Graffito 20", 33, 800.99));
        expResult.add(new Product(5, "Scott Volt X20", 50, 1000.0));
        List<Product> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ProductDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        ProductDao instance = new ProductDao();
        Product expResult = new Product(1, "Orient City Classic", 10, 479.65);
        Product result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertProductAndProductsRecipe method, of class ProductDao.
     */
    @Test
    public void itestInsertProductAndProductsRecipe() {
        System.out.println("insertProductAndProductsRecipe");
        Product p = new Product("Regina Urban Freestyle 20", 15, 540.56);
        List<ProductRawMaterial> rml = new ArrayList<>();
        RawMaterialDao rmd = new RawMaterialDao();
        rml.add(new ProductRawMaterial(p,rmd.getById(1),5));
        rml.add(new ProductRawMaterial(p,rmd.getById(2),8));
        ProductDao instance = new ProductDao();
        instance.insertProductAndProductsRecipe(p, rml);
        p.setId(7);
        assertEquals(p, instance.getById(7));
        ProductRawMaterialDao prmd = new ProductRawMaterialDao();
        assertEquals(rml, prmd.getMaterialsPerProduct(7));
        
        

    }

    /**
     * Test of insert method, of class ProductDao.
     */
    @Test
    public void etestInsert() {
        System.out.println("insert");
        Product p = new Product("Montana Wax S500 20", 35, 1800.00);
        ProductDao instance = new ProductDao();
        instance.insert(p);
        Product p1 = new Product(6, "Montana Wax S500 20", 35, 1800.00);
        assertEquals(p1, instance.getById(6));
    }

    /**
     * Test of updateName method, of class ProductDao.
     */
    @Test
    public void dtestUpdateName() {
        System.out.println("updateName");
        int id = 2;
        String name = "GT Air 21";
        ProductDao instance = new ProductDao();
        instance.updateName(id, name);
        Product p = new Product(2, "GT Air 21", 32, 567.34);
        assertEquals(p, instance.getById(id));
        
    }

    /**
     * Test of bringLastId method, of class ProductDao.
     */
    @Test
    public void ctestBringLastId() {
        System.out.println("bringLastId");
        ProductDao instance = new ProductDao();
        int expResult = 5;
        int result = instance.bringLastId();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateQuantity method, of class ProductDao.
     */
    @Test
    public void ftestUpdateQuantity() {
        System.out.println("updateQuantity");
        int id = 3;
        int quantity = 7;
        ProductDao instance = new ProductDao();
        instance.updateQuantity(id, quantity);
        Product p = new Product(3, "Bullet Freestyle 20", 7, 235.69);
        assertEquals(p, instance.getById(id));
    }

    /**
     * Test of updatePrice method, of class ProductDao.
     */
    @Test
    public void gtestUpdatePrice() {
        System.out.println("updatePrice");
        int id = 4;
        double price = 4.5;
        ProductDao instance = new ProductDao();
        instance.updatePrice(id, price);
        Product p = new Product(4,"Olmo Graffito 20", 33, 4.5);
        assertEquals(p, instance.getById(id));
    }

    /**
     * Test of update method, of class ProductDao.
     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Product p = null;
//        ProductDao instance = new ProductDao();
//        instance.update(p);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deletePermanently method, of class ProductDao.
     */
//    @Test
//    public void testDeletePermanently() {
//        System.out.println("deletePermanently");
//        int id = 0;
//        ProductDao instance = new ProductDao();
//        instance.deletePermanently(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of delete method, of class ProductDao.
     */
    @Test
    public void htestDelete() {
        System.out.println("delete");
        int id = 5;
        ProductDao instance = new ProductDao();
        instance.delete(id);
        assertEquals(null, instance.getById(id));
    }
    
}
