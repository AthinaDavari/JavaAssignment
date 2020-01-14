package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.COrderItemDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author aggel, MariaKokkorou, Athina Davari
 */
public class StorageServices {

    /**
     * Update the quantity of all the ingredients in product's recipe
     *
     * @param id-the product's id we want to made
     * @param quant-the quantity of product we want to make(with +) or
     * destroy(with -)
     */
    public void updateIngredients(int id, int quant) {
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();

        //list of raw materials,which are included in product's recipe
        List<ProductRawMaterial> prodrawlist = prodrawdao.getMaterialsPerProduct(id);
        RawMaterialDao rawmatdao = new RawMaterialDao();
        Function<Integer, Integer> f = updateQuantityOfRawMaterialBy(quant);

        int prodrawlistsize = prodrawlist.size();//number of raw materials in product's recipe
        ProductRawMaterial prodraw;
        int quantrecipe;
        int rawquant;
        //update all raw materials in product's recipe
        for (int i = 0; i < prodrawlistsize; i++) {
            //the raw material we want to update
            prodraw = prodrawlist.get(i);
            //raw material's quantity, which needs a product's unit to make
            quantrecipe = prodraw.getQuantityOfRawMaterial();
            //raw material's quantity in storage
            rawquant = prodraw.getRawMaterial().getQuantity();
            rawquant += f.apply(quantrecipe);//same with: rawquant = rawquant - quantrecipe * quant;
            //update the raw material 
            rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);
        }//end for
    }

    /**
     * Check if the storage have enough raw materials to make a product in
     * quantity we want
     *
     * @param id -the product's id we want to made
     * @param quant -the quantity of product we want to make(with +)
     * @return if the storage have enough raw materials to make a product in
     * quantity we want, return true, else false
     */
    public boolean permissionToUpdateIngredients(int id, int quant) {
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();

        //get all materials from product's recipe
        List<ProductRawMaterial> prodrawlist = prodrawdao.getMaterialsPerProduct(id);
        Function<Integer, Integer> f = updateQuantityOfRawMaterialBy(quant);
        int prodrawlistsize = prodrawlist.size();//number of raw materials in product's recipe

        int quantrecipe;
        int rawquant;
        for (int i = 0; i < prodrawlistsize; i++) {//start for
            //the raw material we want to check its quantity
            ProductRawMaterial prodraw = prodrawlist.get(i);
            //raw material's quantity, which needs a product's unit to make
            quantrecipe = prodraw.getQuantityOfRawMaterial();
            //raw material's quantity in storage
            rawquant = prodraw.getRawMaterial().getQuantity();
            rawquant += f.apply(quantrecipe);//same with: rawquant = rawquant - quantrecipe * quant;

            //if the raw material has not enough pieces in storage, return false
            if (rawquant < 0) {
                return false;
            }//end if

        }//end for

        return true;
    }

    /**
     * Creates a HashMap with total quantities of raw materials of a COrder and
     * checks if raw materials can be decreased by this quantity
     *
     * @param corderid COrder's id
     * @return false - if at least one RawMaterial is insufficient, true - if
     * all quantities are sufficient
     */
    public boolean permissionToDecreaseRawMaterials(int corderid) {
        ProductRawMaterialDao prd = new ProductRawMaterialDao();
        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        HashMap<RawMaterial, Integer> totalRawNeeded = new HashMap();
        for (COrderItem cOrderItem : corderitems) {
            ArrayList<ProductRawMaterial> rawsOfProduct = prd.getMaterialsPerProduct(cOrderItem.getProduct().getId());
            for (ProductRawMaterial prm : rawsOfProduct) {
                RawMaterial rawMaterial = prm.getRawMaterial();
                /* get old value of quantity contained in HashMap and increase it by 
                the other Product's  needed quantity for this particular RawMaterial */
                if (totalRawNeeded.get(rawMaterial) != null) {
                    totalRawNeeded.put(rawMaterial, totalRawNeeded.get(rawMaterial) + prm.getQuantityOfRawMaterial());
                } else {
                    totalRawNeeded.put(rawMaterial, prm.getQuantityOfRawMaterial());
                }
            }
        }
        for (RawMaterial rm : totalRawNeeded.keySet()) {
            int oldQuantity = rm.getQuantity();
            Function<Integer, Integer> f = updateQuantityOfRawMaterialBy(oldQuantity);
            int newQuantity = oldQuantity + f.apply(totalRawNeeded.get(rm));
            if (newQuantity < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param q-the quantity of product we want to make(with +) or destroy(with
     * -)
     * @return q returns an integer function
     */
    public Function<Integer, Integer> updateQuantityOfRawMaterialBy(int q) {
        return x -> -q * x;
    }

    /**
     * Increase the quantities of a specific product that are available for
     * customers and update this data in the database.
     *
     * @param corderid - An integer that defines the id of an order from
     * customers.
     */
    public void increaseProduct(int corderid) {

        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        // corderitems - an arraylist that contains all the items in a specific 
        // order from customers.
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {

            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() + cOrderItem.getQuantity());
            // Update the quantities of the specific product that are available 
            // for customers. Increase the existing quantity in the database by 
            // the extra quantity given in the order from customer.
        }

    }

    /**
     * Increase the quantities of a specific product that are available for
     * customers and update this data in the database.
     *
     * @param corderid - An integer that defines the id of an order from
     * customers.
     */
    public void decreaseRawQuantitiesForProducts(int corderid) {
        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        // corderitems - an arraylist that contains all the items in a specific 
        // order from customers.
        for (COrderItem cOrderItem : corderitems) {
            updateIngredients(corderid, cOrderItem.getQuantity());
            // For each item in a specific order from customer, call the 
            // updateIngredients method and update the quantities of the 
            // raw materials that were used.
        }
    }

    /**
     * Decrease the quantities of of order's products in the database.
     *
     * @param corderid - An integer that defines the id of an order from
     * customers.
     */
    public void decreaseProduct(int corderid) {

        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        // corderitems - an arraylist that contains all the items in a specific 
        // order from customers.
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {

            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() - cOrderItem.getQuantity());
            // If there are enough products in the storage, decrease the 
            // quantity of this product by the quantity given in the order 
            // from customers and update the database.

        }

    }

    /**
     * Check if the quantities of order's products are available for customers
     *
     * @param corderid - An integer that defines the id of an order from
     * customers.
     */
    public boolean permissionToDecreaseProduct(int corderid) {
        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        // corderitems - an arraylist that contains all the items in a specific 
        // order from customers.
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {

            Product productFromOrder = cOrderItem.getProduct();
            if (cOrderItem.getQuantity() > pd.getById(productFromOrder.getId()).getQuantity()) {
                // Check if the quantity of a specific product in an order from customers 
                // is more to the available quantity of this product in the storage.
                // if yes stop, return false(there are not enough products in the storage.)
                return false;
            }
        }
        return true;
    }

}
