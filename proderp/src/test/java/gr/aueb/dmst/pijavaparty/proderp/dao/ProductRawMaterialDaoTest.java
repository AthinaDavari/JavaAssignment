package gr.aueb.dmst.pijavaparty.proderp.dao;

import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Athina Davari
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductRawMaterialDaoTest {

    private ProductDao pdao = new ProductDao();
    private RawMaterialDao rmdao = new RawMaterialDao();

    /**
     *An empty constructor
     */
    public ProductRawMaterialDaoTest() {
    }

    /**
     *Test - Set up
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }

    /**
     * Test of getAll method, of class ProductRawMaterialDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        List<ProductRawMaterial> expResult = new ArrayList<>();
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(3), 3));
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(4), 2));
        expResult.add(new ProductRawMaterial(pdao.getById(2), rmdao.getById(1), 6));
        expResult.add(new ProductRawMaterial(pdao.getById(3), rmdao.getById(4), 4));
        expResult.add(new ProductRawMaterial(pdao.getById(4), rmdao.getById(2), 5));
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
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(3), 3));
        expResult.add(new ProductRawMaterial(pdao.getById(1), rmdao.getById(4), 2));
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
        ProductRawMaterial expResult = new ProductRawMaterial(pdao.getById(2), rmdao.getById(1), 6);
        ProductRawMaterial result = instance.getByIds(pid, rmid);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteByProduct method, of class ProductRawMaterialDao.
     */
    @Test
    public void ftestDeleteByProduct() {
        System.out.println("deleteByProduct");
        int pid = 1;
        ProductRawMaterialDao instance = new ProductRawMaterialDao();
        instance.deleteByProduct(pid);
        assertEquals(null, instance.getByIds(pid, 3));
        assertEquals(null, instance.getByIds(pid, 4));
    }

}
