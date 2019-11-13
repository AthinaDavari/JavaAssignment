package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.dao.SOrderDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.dao.UserDao;
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.User;
import pijavaparty.proderp.test.LogIn;

/**
 *
 * @author AthinaDavari
 */
public class Main {

    public static void main(String[] args) {
        CustomerDao obj = new CustomerDao();
//           System.out.println(obj.getAll());
        UserDao ud = new UserDao();
        System.out.println(ud.getUser("nat", "12345"));
        //System.out.println(ud.getAll());
//        ud.insert(new User("maria k", "maria", "abc12", 2));
        ud.insert(new User("anna", "anna", "213", 1));
        System.out.println(ud.getAll());
        
        
    }

}
