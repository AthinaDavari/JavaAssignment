package pijavaparty.proderp.Services;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.entity.SOrderItem;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Athina Davari
 */
public class SOrderServices {

    /**
     * Return the raw materials not included in the order
     *
     * @param rawmat-list of raw materials included in the order
     * @param sup-the consignee(supplier) of order
     * @return list of raw materials (string type objects with raw materials' ids and names) not included in the order
     */
    public static ArrayList<String> RawMaterialsNotIncludedInSuppliersOrder(List<SOrderItem> rawmat, Supplier sup) {
        ArrayList<String> rawmaterialist = new ArrayList<String>();
        SupplierDao supdao = new SupplierDao();
        List<RawMaterial> raw_material_per_supplier;

        //get all rawmaterials' ids from a specific supplier
        raw_material_per_supplier = supdao.getRawMaterialsPerSupplier(sup.getId());
        int num = raw_material_per_supplier.size();//the number of rawmaterials from a specific supplier 
        int rawmatsize = rawmat.size();//the number of of raw materials included in the order
        try {
            int j;//counter of 2nd loop
            for (int i = 0; i < num; i++) {//start 1st for
                
                //find if a raw material from the supplier exists in the order
                for (j = 0; j < rawmatsize; j++) {//start 2nd for

                    //check if a raw material from supplier is equal to a raw material from the corderitem list
                    if (raw_material_per_supplier.get(i).getId() == rawmat.get(j).getRawmaterial().getId()) {
                        break;
                    }//end if
                    
                    }//end 2nd for
                
                //if a raw material from supplier doesnt exist in the order add it to the list
                if (j == rawmatsize) {
                        rawmaterialist.add(raw_material_per_supplier.get(i).getId()+"-"+raw_material_per_supplier.get(i).getName());
                }//end if
            
            }//end 1st for

            return rawmaterialist;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
