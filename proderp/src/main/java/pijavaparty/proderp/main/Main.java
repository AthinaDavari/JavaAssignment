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
<<<<<<< HEAD
        System.out.println(supplierDao.getById(2));
        supplierDao.insert(new Supplier("Wood", "Patisionn 8", 222222l, "info@wood.com"));
=======
        printList(supplierDao.getAll());
>>>>>>> b158a8582ea6763ff6261f40b823ea86d40590dd
    }
    
    public static void printList(List<Supplier> a){
        System.out.println(a.get(0).getClass().getSimpleName());
        for(int i=0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}
