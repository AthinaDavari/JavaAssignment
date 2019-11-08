package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.Customer;


/**
 *
 * @author AthinaDavari
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        CustomerDao c = new CustomerDao();
        ProductDao p = new ProductDao();
        RawMaterialDao rawMaterialDao = new RawMaterialDao();
        
//        System.out.println(rawMaterialDao.getAll());
        System.out.println(rawMaterialDao.getById(2));
        
        System.out.println(supplierDao.getById(2));
//        supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com"));
        //supplierDao.update(new Supplier(2, "Wood", "Patisionn 200", 4222222l, "info@wood.com"));
        //SupplierDao.printList(supplierDao.getAll());
        System.out.println(supplierDao.getById(2));
        
        
//          c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
//          c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
//                    c.updateFullName(1, "Skoda");
//          c.printList(c.getAll());
//          c.printList(c.getByName("Papadopoulos"));
//        c.delete(2);
//        c.printList(c.getAll());


         // p.printList(p.getAll());
        
        
    }
    
}
