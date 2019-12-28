
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
     * @param rawmat-list of raw materials included in the order
     * @param sup-the consignee(supplier) of order
     * @return list of raw materials (string type objects with raw materials' names and ids) not included in the order
     */
    public static ArrayList<String> RawMaterialsNotIncludedInSuppliersOrder(List<SOrderItem> rawmat, Supplier sup) {
        ArrayList<String> rawmaterialist = new ArrayList<String>();
        SupplierDao supdao = new SupplierDao();
        List<RawMaterial> raw_material_per_supplier;
        raw_material_per_supplier = supdao.getRawMaterialsPerSupplier(sup.getId());
        int num;
        num = raw_material_per_supplier.size();
        int rawmatsize = rawmat.size();
        try {
            int j;
            int i;
            for (i = 0; i < num; i++) {
                for (j = 0; j < rawmatsize; j++) {
                    if (raw_material_per_supplier.get(i).getId() == rawmat.get(j).getRawmaterial().getId()) {
                        break;
                    }
                    }
                if (j == rawmatsize) {
                        rawmaterialist.add(raw_material_per_supplier.get(i).getId()+"-"+raw_material_per_supplier.get(i).getName());
                }
            }
            System.out.println(rawmaterialist.size());
            return rawmaterialist;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
