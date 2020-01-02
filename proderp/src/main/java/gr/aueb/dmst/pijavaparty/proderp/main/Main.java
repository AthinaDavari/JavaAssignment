package gr.aueb.dmst.pijavaparty.proderp.main;

import gr.aueb.dmst.pijavaparty.proderp.services.StorageServices;

/**
 *
 * @author AthinaDavari
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        StorageServices services = new StorageServices();
        System.out.println(services.permissionToDecreaseRawMaterials(3));

                
    }
    
 
}
