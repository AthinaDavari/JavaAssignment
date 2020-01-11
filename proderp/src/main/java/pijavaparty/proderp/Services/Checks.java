package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.ProductRawMaterial;
import pijavaparty.proderp.entity.RawMaterial;

/**
 *
 * @author aggel
 */
public class Checks {

    /**
     *
     * @param id
     * @return
     */
    public boolean checkIfRawMaterialIsUsed(int id) {
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
    
    /**
     *
     * @return
     */
    public List<RawMaterial> checkRawQuantities() {
        RawMaterialDao materialDao = new RawMaterialDao();
        List<RawMaterial> rawMaterials = materialDao.getAll();
        rawMaterials = rawMaterials.stream()
                    .filter(x -> x.getQuantity() < 20)
                    .collect(toList());
        return rawMaterials;
    } 
    
    /**
     *
     * @return
     */
    public List<Product> checkProductQuantities() {
        ProductDao proDao = new ProductDao();
        List<Product> products = proDao.getAll();
        products = products.stream()
                .filter(x -> x.getQuantity() < 10)
                .collect(toList());
        return products;
    }
}
