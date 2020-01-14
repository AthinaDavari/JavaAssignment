package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import java.util.List;
import static java.util.stream.Collectors.toList;


/**
 *
 * @author aggel, Natalia
 */
public class Checks {

    /**
     * Checks if a RawMaterial is contained in any Product in the Database
     * 
     * @param id RawMaterial's id
     * @return true if it is contained - false otherwise
     */
    public boolean checkIfRawMaterialIsUsed(int id) {
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        List<ProductRawMaterial> prodrawall = prodrawdao.getAll();
        for (int i = 0; i < prodrawall.size(); i++) {
            int a = prodrawall.get(i).getRawMaterial().getId();
            if (a == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get a List with insufficient RawMaterials (quantity less than 20)
     * 
     * @return a List with RawMaterials
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
     * Get a List with insufficient Products (quantity less than 10)
     * 
     * @return a List with Products
     */
    public List<Product> checkProductQuantities() {
        ProductDao proDao = new ProductDao();
        List<Product> products = proDao.getAll();
        products = products.stream()
                .filter(x -> x.getQuantity() < 12)
                .collect(toList());
        return products;
    }
}
