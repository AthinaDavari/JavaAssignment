package pijavaparty.proderp.main;


import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.dao.SOrderDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.dao.UserDao;
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.User;


/**
 *
 * @author AthinaDavari
 */
public class Main {
    
        
        
       public static void main(String[] args) {
           /*SupplierDao supplierDao = new SupplierDao();
        CustomerDao c = new CustomerDao();
        c.getAll();
        ProductDao p = new ProductDao();
        RawMaterialDao rawMaterialDao = new RawMaterialDao();
        ProductRawMaterialDao productRawMaterialDao = new ProductRawMaterialDao();
        SOrderDao so =new SOrderDao();
        SOrder s =new SOrder(2);
        so.insert(s);
        so.printList(so.getAll());
        p.printList(p.getAll());*/
        UserDao u = new UserDao();
        System.out.println(u.getUser("ath", "asdfg"));
        
                //       new MainPage().setVisible(true);
    
//        System.out.println(rawMaterialDao.getAll());
//        System.out.println(rawMaterialDao.getById(2));
        
//        System.out.println(supplierDao.getById(2));
//        supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com"));
        //supplierDao.update(new Supplier(2, "Wood", "Patisionn 200", 4222222l, "info@wood.com"));
        //SupplierDao.printList(supplierDao.getAll());
 //       System.out.println(supplierDao.getById(2));
       
     
       // System.out.println(productRawMaterialDao.getAll());
    
        
//          c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
//          c.insert(new Customer("Papadopoulos", "Mousitsa 56", 345678l, "papadopoulos@gmail.com"));
//                    c.updateFullName(1, "Skoda");
       
      
//          c.printList(c.getByName("Papadopoulos"));
//        c.delete(2);
//        c.printList(c.getAll());


         // p.printList(p.getAll());

     
         
         
        
    
                
}
       
}