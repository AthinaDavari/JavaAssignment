/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.ProductRawMaterial;

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
    public void UpdateIngredients(int id, int quant) {
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
            rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);
        }

    }

    /**
     *
     * @param q
     * @return
     */
    public Function<Integer, Integer> updateQuantityOfRawMaterialBy(int q) {
        return x -> q * x;
    }

}
