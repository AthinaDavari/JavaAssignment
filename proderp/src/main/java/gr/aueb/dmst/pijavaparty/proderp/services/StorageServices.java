package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.COrderItemDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.util.List;
import java.util.function.Function;
import javax.swing.JOptionPane;

/**
 *
 * @author aggel, MariaKokkorou, Athina Davari
 */
public class StorageServices {

    /**
     *
     */
    public void StorageServices() {

    }


    /**
     * Update the quantity of all the ingredients in product's recipe
     * @param id-the product's id we want to made
     * @param quant-the quantity of product we want to make(with -) or destroy(with +)
     * @return if the quantity of product's, return true,
     * else false
     */

    public boolean updateIngredients(int id, int quant) {
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        
        //list of raw materials,which are included in product's recipe
        List<ProductRawMaterial> prodrawlist = prodrawdao.getMaterialsPerProduct(id);
        RawMaterialDao rawmatdao = new RawMaterialDao();
        Function<Integer, Integer> f = updateQuantityOfRawMaterialBy(quant);
        
        //if we want to make products,check the raw materials pieces in storage
        if(quant < 0){//start 1st if
        //if at least a raw material has not enough pieces in storage, stop the process 
        if (permissionToUpdateIngredients(id, quant) == false) {//start 2nd if
            return false;
        }//end 2nd if
        }//end 1st if
        
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
            rawquant += f.apply(quantrecipe);//same with: rawquant = rawquant + quantrecipe * quant;
            //update the raw material 
            rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);
        }//end for
        return true;
    }

    /**
     * Check if the storage have enough raw materials to make a product in quantity we want
     * @param id-the product's id we want to made
     * @param quant-the quantity of product we want to make(with -)
     * @return if the storage have enough raw materials to make a product in quantity we want, return true,
     * else false
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
            rawquant += f.apply(quantrecipe);//same with: rawquant = rawquant + quantrecipe * quant;
            
            //if the raw material has not enough pieces in storage, return false
            if (rawquant < 0) {
                return false;
            }//end if
            
        }//end for
        
        return true;
    }

    /**
     *
     * @param q-the quantity of product we want to make(with -) or destroy(with +)
     * @return
     */
    public Function<Integer, Integer> updateQuantityOfRawMaterialBy(int q) {
        return x -> q * x;
    }

    
    /**
     * Increase the quantities of a specific product that are available for 
     * customers and update this data in the database.
     * 
     * @param corderid - An integer that defines the id of an order from customers.
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
     * @param corderid - An integer that defines the id of an order from customers.
     */
    
    public void updateProduct(int corderid) {

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
     * Decrease the quantities of a specific product that are available for 
     * customers and update this data in the database.
     * 
     * @param corderid - An integer that defines the id of an order from customers.
     */
    
    public void decreaseProduct(int corderid) {

        COrderItemDao coid = new COrderItemDao();
        List<COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        // corderitems - an arraylist that contains all the items in a specific 
        // order from customers.
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {
            
            Product productFromOrder = cOrderItem.getProduct();
            if (cOrderItem.getQuantity() <= pd.getById(productFromOrder.getId()).getQuantity()){
            // Check if the quantity of a specific product in an order from customers 
            // is less or equal to the available quantity of this product in the storage.
            // Check if there are enough products in the storage.
                pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() - cOrderItem.getQuantity());
                // If there are enough products in the storage, decrease the 
                // quantity of this product by the quantity given in the order 
                // from customers and update the database.
            } else {
                
                JOptionPane.showMessageDialog(null, "Not enough products in the storage.");
            }
        }

    }
}
