package pijavaparty.proderp.main;

import java.util.LinkedList;
import java.util.List;
import pijavaparty.proderp.dao.CustomerDao;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.dao.SOrderDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.dao.UserDao;
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.SOrderItem;
import pijavaparty.proderp.entity.Supplier;
import pijavaparty.proderp.entity.User;
import pijavaparty.proderp.test.LogIn;

/**
 *
 * @author AthinaDavari
 */
public class Main {

    public static void main(String[] args) {
        //CustomerDao cd = new CustomerDao();
//           System.out.println(obj.getAll());
        //System.out.println(cd.getById(1));
        //UserDao ud = new UserDao();
        //System.out.println(ud.getUser("nat", "12345"));
        //System.out.println(ud.getAll());
//        ud.insert(new User("maria k", "maria", "abc12", 2));
        //ud.insert(new User("anna", "anna", "213", 1));
        //System.out.println(ud.getAll());
        //System.out.println(cd.getAll());
        SOrderDao s= new SOrderDao();
        SupplierDao sd = new SupplierDao();
        Supplier su =sd.getById(1);
        System.out.println(s.bringTheIdOfTheLatestSOrder());
        SOrder so =new SOrder(su);
        
        
        RawMaterialDao r = new RawMaterialDao();
        List<SOrderItem> lsoi = new LinkedList();
        lsoi.add(new SOrderItem(so, r.getById(1), 7));
        lsoi.add(new SOrderItem(so, r.getById(2), 7));
        s.insertSOrderAndSOrderItems(so, lsoi);
        
    }

}
