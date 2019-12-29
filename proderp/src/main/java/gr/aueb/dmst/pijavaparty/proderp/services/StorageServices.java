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




/**
 *
 * @author aggel
 */
public class StorageServices {

    /**
     *
     */
    public void StorageServices() {

    }

    //method that takes the quantity of all the ingrediaents in a product recipe 
    //and as the quantity of the product chages the quantity of all the raw matirials changes as well

    /**
     *
     * @param id
     * @param quant
     */
    public boolean UpdateIngredients(int id, int quant) {
        ProductRawMaterial prodraw;
        int quantrecipe;
        int rawquant;
        ProductDao proddao = new ProductDao();
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        List<ProductRawMaterial> prodrawlist;
        prodrawlist = prodrawdao.getMaterialsPerProduct(id);
        RawMaterialDao rawmatdao = new RawMaterialDao();
        Function<Integer, Integer> f = updateQuantityOfRawMaterialBy(quant);
        for (int i = 0; i < prodrawlist.size(); i++) {
            prodraw = prodrawlist.get(i);
            quantrecipe = prodraw.getQuantityOfRawMaterial();
            rawquant = prodraw.getRawMaterial().getQuantity();
            rawquant += f.apply(quantrecipe);
//          rawquant = rawquant + quantrecipe * quant;
            if (rawquant < 0) {
                return false;
            }
        }
        for (int i = 0; i < prodrawlist.size(); i++) {
            prodraw = prodrawlist.get(i);
            quantrecipe = prodraw.getQuantityOfRawMaterial();
            rawquant = prodraw.getRawMaterial().getQuantity();
            rawquant += f.apply(quantrecipe);
            rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);
        }
        
        return true;

    }

    /**
     *
     * @param q
     * @return
     */
    public Function<Integer, Integer> updateQuantityOfRawMaterialBy(int q) {
        return x -> q * x;
    }
    
    
    
    /**
     * @author MariaKokkorou
     * @param corderid
     */
    public void increaseProduct(int corderid){
        
        COrderItemDao coid = new COrderItemDao();
        List <COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {
            
            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() + cOrderItem.getQuantity());
       
        }
        
    }
    
    public void updateProduct(int corderid){
        
        COrderItemDao coid = new COrderItemDao();
        List <COrderItem> corderitems = coid.getItemsPerCOrder(corderid); 
        for (COrderItem cOrderItem : corderitems) {
            
            UpdateIngredients(corderid, cOrderItem.getQuantity());
            
        }
    }
    
    /**
     *
     * @param corderid
     */
    public void decreaseProduct(int corderid){
        
        COrderItemDao coid = new COrderItemDao();
        List <COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {
            
            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() - cOrderItem.getQuantity());
       
        }
        
    }
}
