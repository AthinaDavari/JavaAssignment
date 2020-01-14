/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.COrderItemDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Natalia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StorageServicesTest {
    /**
     * An empty conrtuctor
     */
    public StorageServicesTest() {
    }
    /**
     * Test - Set up
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of updateIngredients method, of class StorageServices.
     */
    @Test
    public void btestUpdateIngredients() {
        System.out.println("updateIngredients");
        int id = 1;
        int quant = 2;
        StorageServices instance = new StorageServices();
        ProductRawMaterialDao pdao = new ProductRawMaterialDao();
        ArrayList<ProductRawMaterial> oldIngr = pdao.getMaterialsPerProduct(id);
        instance.updateIngredients(id, quant);
        ArrayList<ProductRawMaterial> ingredients = pdao.getMaterialsPerProduct(id);
        for (int i = 0; i < ingredients.size(); i++) {
            int oldQuantity = oldIngr.get(i).getRawMaterial().getQuantity();
            int recipe = oldIngr.get(i).getQuantityOfRawMaterial();
            int newQuantity = ingredients.get(i).getRawMaterial().getQuantity();
            assertEquals(oldQuantity - recipe * quant, newQuantity);
        }
    }

    /**
     * Test of permissionToUpdateIngredients method, of class StorageServices.
     */
    @Test
    public void atestPermissionToUpdateIngredients() {
        System.out.println("permissionToUpdateIngredients");
        int id = 1;
        int quant = 2;
        StorageServices instance = new StorageServices();
        boolean expResult = true;
        boolean result = instance.permissionToUpdateIngredients(id, quant);
        assertEquals(expResult, result);
    }

    /**
     * Test of permissionToDecreaseRawMaterials method, of class
     * StorageServices.
     */
    @Test
    public void ctestPermissionToDecreaseRawMaterials() {
        System.out.println("permissionToDecreaseRawMaterials");
        int corderid = 3;
        StorageServices instance = new StorageServices();
        boolean expResult = false;
        boolean result = instance.permissionToDecreaseRawMaterials(corderid);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateQuantityOfRawMaterialBy method, of class StorageServices.
     */
    @Test
    public void testUpdateQuantityOfRawMaterialBy() {
        System.out.println("updateQuantityOfRawMaterialBy");
        int q = 2;
        StorageServices instance = new StorageServices();
        int expResult = -16;
        Function<Integer, Integer> result = instance.updateQuantityOfRawMaterialBy(q);
        int resultExample = result.apply(8);
        assertEquals(expResult, resultExample);
    }

    /**
     * Test of increaseProduct method, of class StorageServices.
     */
    @Test
    public void testIncreaseProduct() {
        System.out.println("increaseProduct");
        int corderid = 3;
        StorageServices instance = new StorageServices();
        COrderItemDao cdao = new COrderItemDao();
        List<COrderItem> items = cdao.getItemsPerCOrder(corderid);
        instance.increaseProduct(corderid);
        List<COrderItem> updatedItems = cdao.getItemsPerCOrder(corderid);
        for (int i = 0; i < items.size(); i++) {
            int oldQuantity = items.get(i).getProduct().getQuantity();
            int newQuantity = updatedItems.get(i).getProduct().getQuantity();
            assertEquals(oldQuantity + items.get(i).getQuantity(), newQuantity);
        }
    }

    /**
     * Test of decreaseRawQuantitiesForProducts method, of class
     * StorageServices.
     */
    @Test
    public void testDecreaseRawQuantitiesForProducts() {
        System.out.println("updateProduct");
        int corderid = 2;
        StorageServices instance = new StorageServices();
        COrderItemDao coidao = new COrderItemDao();
        ProductRawMaterialDao prdao = new ProductRawMaterialDao();

        List<COrderItem> items = coidao.getItemsPerCOrder(corderid);
        List<ArrayList<ProductRawMaterial>> oldMaterialsPerProduct = new ArrayList();
        /* for each product save a List of ingredients into the oldMaterialsPerProduct List */
        items.forEach((coi) -> oldMaterialsPerProduct.add(
                prdao.getMaterialsPerProduct(coi.getProduct().getId())));
        instance.decreaseRawQuantitiesForProducts(corderid);

        List<COrderItem> updatedItems = coidao.getItemsPerCOrder(corderid);
        List<ArrayList<ProductRawMaterial>> newMaterialsPerProduct = new ArrayList();
        updatedItems.forEach((coi) -> newMaterialsPerProduct.add(
                prdao.getMaterialsPerProduct(coi.getProduct().getId())));

        for (int i = 0; i < oldMaterialsPerProduct.size(); i++) {
            ArrayList<ProductRawMaterial> oldIngredients = oldMaterialsPerProduct.get(i);
            ArrayList<ProductRawMaterial> newIngredients = newMaterialsPerProduct.get(i);
            int quantityOrdered = items.get(i).getQuantity();

            for (int j = 0; j < oldIngredients.size(); j++) {
                int oldQuantity = oldIngredients.get(j).getRawMaterial().getQuantity();
                int recipe = oldIngredients.get(j).getQuantityOfRawMaterial();
                int newQuantity = newIngredients.get(j).getRawMaterial().getQuantity();
                assertEquals(oldQuantity - recipe * quantityOrdered, newQuantity);
            }
        }

    }

    /**
     * Test of decreaseProduct method, of class StorageServices.
     */
    @Test
    public void testDecreaseProduct() {
        System.out.println("decreaseProduct");
        int corderid = 3;
        StorageServices instance = new StorageServices();
        COrderItemDao cdao = new COrderItemDao();
        List<COrderItem> items = cdao.getItemsPerCOrder(corderid);
        instance.decreaseProduct(corderid);
        List<COrderItem> updatedItems = cdao.getItemsPerCOrder(corderid);
        for (int i = 0; i < items.size(); i++) {
            int oldQuantity = items.get(i).getProduct().getQuantity();
            int newQuantity = updatedItems.get(i).getProduct().getQuantity();
            assertEquals(oldQuantity - items.get(i).getQuantity(), newQuantity);
        }
    }

    /**
     * Test of permissionToDecreaseProduct method, of class StorageServices.
     */
    @Test
    public void wtestPermissionToDecreaseProduct() {
        System.out.println("permissionToDecreaseProduct");
        int corderid = 3;
        StorageServices instance = new StorageServices();
        boolean expResult = false;
        boolean result = instance.permissionToDecreaseProduct(corderid);
        assertEquals(expResult, result);
    }
}
