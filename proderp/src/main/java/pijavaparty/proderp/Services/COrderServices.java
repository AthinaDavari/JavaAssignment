
package pijavaparty.proderp.Services;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.entity.COrderItem;
import pijavaparty.proderp.entity.Product;

/**
 *
 * @author Athina Davari
 */
public class COrderServices {

    /**
     * Return the products not included in the order
     * @param prod-list of products included in the order
     * @return list of products (string type objects with products' names and ids) not included in the order
     */
    public static ArrayList<String> RawMaterialsNotIncludedInSuppliersOrder(List<COrderItem> prod) {
        ArrayList<String> productlist = new ArrayList<String>();
        ProductDao pdao = new ProductDao();
        List<Product> allproducts;
        
        allproducts = pdao.getAll();//take all the product from the database
        int num = allproducts.size();//the number of products in database
        int prodsize = prod.size();//the number of products in order
        
        try {
            int j;
            int i;
            for (i = 0; i < num; i++) {// start of 2nd for
                
                //find if a product from database exist in the order
                for (j = 0; j < prodsize; j++) {// start of 2nd for
                    
                    //check if a product from database is equal to a product from the sorderitem list
                    if (allproducts.get(i).getId() == prod.get(j).getProduct().getId()) {
                        break;
                    }//end if
                    
                }//end of 2nd for
                
                //if a product from database doesnt exist in the order add it to the list
                if (j == prodsize) {
                    productlist.add(allproducts.get(i).getId() + "-" + allproducts.get(i).getName());
                }//end if
                
            }//end of 1st for

            return productlist;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
