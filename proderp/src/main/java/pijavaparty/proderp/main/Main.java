package pijavaparty.proderp.main;

import java.util.List;
import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.SupplierDao;


/**
 *
 * @author athina
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        CustomerDao customerDao = new CustomerDao();
        System.out.println(supplierDao.getById(2));
//        supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com"));

        SupplierDao.printList(supplierDao.getAll());
        CustomerDao c = new CustomerDao();
        //c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
        System.out.println(c.getById(1));
        CustomerDao.printList(c.getAll());
        
    }
    
}
