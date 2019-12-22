
package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author aggel
 */
public class Checks {
    public boolean CheckIfRawMaterialIsUsed (int id) {
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        List<ProductRawMaterial> prodrawall = prodrawdao.getAll();
        ProductRawMaterial prodraw = new ProductRawMaterial();
        for (int i = 0; i < prodrawall.size(); i++) {
            int a = prodrawall.get(i).getRawMaterial().getId();
            if (a == id) {
                return true;
            } 
        }
        return false;
    }
}
