package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.SupplierDao;

/**
 *
 * @author athina
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        System.out.println(supplierDao.getAll());
    }
    
}
