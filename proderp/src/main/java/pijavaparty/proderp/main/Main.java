package pijavaparty.proderp.main;

import java.util.List;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author athina
 */
public class Main {
    
    public static void main(String[] args) {
        SupplierDao supplierDao = new SupplierDao();
        printList(supplierDao.getAll());
    }
    
    public static void printList(List<Supplier> a){
        System.out.println(a.getClass());
        for(int i=0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}
