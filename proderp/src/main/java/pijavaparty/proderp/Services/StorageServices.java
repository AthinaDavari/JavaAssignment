/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
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
    public void StorageServices() {
        
    }
    
    //method that takes the quantity of all the ingrediaents in a product recipe 
    //and as the quantity of the product chages the quantity of all the raw matirials changes as well
    public void UpdateIngredients(int id, int quant) {
        ProductRawMaterial prodraw;
        int quantrecipe;
        int rawquant;
        ProductDao proddao = new ProductDao();
        Product prod;
        prod = proddao.getById(id);
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        List<ProductRawMaterial> prodrawall;
        List<ProductRawMaterial> prodrawlist = new LinkedList();
        prodrawall = prodrawdao.getAll();
        for(int i=0; i<prodrawall.size(); i++){
            System.out.print(1);
            if (prodrawall.get(i).getProduct().getId()==id) {
                System.out.print(2);
                prodrawlist.add(prodrawdao.getAll().get(i));
            }
        }
        RawMaterialDao rawmatdao = new RawMaterialDao();
        System.out.print(quant);
        if (quant < 0) {
            for(int i=0 ; i < prodrawlist.size();i++){
                prodraw = prodrawlist.get(i);
                quantrecipe = prodraw.getQuantityOfRawMaterial();
                rawquant = prodraw.getRawMaterial().getQuantity();
                rawquant = rawquant - quantrecipe * (-quant);
                rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);            
            }
        } else {
            for(int i=0 ; i<prodrawlist.size();i++){
                prodraw = prodrawlist.get(i);
                quantrecipe = prodraw.getQuantityOfRawMaterial();
                rawquant = prodraw.getRawMaterial().getQuantity();
                rawquant = rawquant + quantrecipe * quant;
                rawmatdao.updateQuantity(prodraw.getRawMaterial().getId(), rawquant);            
            }       

        }

    }
    
    
}
