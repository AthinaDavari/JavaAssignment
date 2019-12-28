
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
        allproducts = pdao.getAll();
        int num;
        num = allproducts.size();
        int prodsize = prod.size();
        try {
            int j;
            int i;
            for (i = 0; i < num; i++) {
                for (j = 0; j < prodsize; j++) {
                    if (allproducts.get(i).getId() == prod.get(j).getProduct().getId()) {
                        break;
                    }
                }
                if (j == prodsize) {
                    productlist.add(allproducts.get(i).getId() + "-" + allproducts.get(i).getName());
                }
            }
            System.out.println(productlist.size());
            return productlist;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
