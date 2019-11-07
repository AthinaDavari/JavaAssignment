package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.Supplier;


/**
 *
 * @author AthinaDavari
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        CustomerDao customerDao = new CustomerDao();
        
        
        
        
        
        System.out.println(supplierDao.getById(2));
//        supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com"));
        System.out.println(supplierDao.update(new Supplier(3, "Wood", "Patisionn 200", 4222222l, "info@wood.com")));
        SupplierDao.printList(supplierDao.getAll());
        
        
        
        
        
        
        
        
        
//        CustomerDao c = new CustomerDao();
//        c.updatePhoneNumber(7, 3455);
//        //c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
//        System.out.println(c.getByName("Papadopoulos"));
//        CustomerDao.printList(c.getAll());
//        c.delete(2);
//        CustomerDao.printList(c.getAll());
//        
        
        
    }
    
}
