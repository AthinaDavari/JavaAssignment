package pijavaparty.proderp.main;

import pijavaparty.proderp.dao.SupplierDao;

/**
 *
 * @author AthinaDavari
 */
public class Main {

    public static void main(String[] args) {
        SupplierDao sd = new SupplierDao();
        System.out.println(sd.getRawMaterialsPerSupplier(1));
    }

}
