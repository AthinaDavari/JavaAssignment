package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author athina
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        System.out.println(supplierDao.getById(2));
        System.out.println(supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com")));
    }
    
}
