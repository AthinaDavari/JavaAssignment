
package pijavaparty.proderp.Services;

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
        List prodrawall = prodrawdao.getAll();
        ProductRawMaterial prodraw = new ProductRawMaterial();
        for (int i = 0; i < prodrawall.size(); i++) {
            prodrawall.get(i);
            if (prodraw.getRawMaterial().getId() == id) {
                return true;
            } 
        }
        return false;
    }
}
