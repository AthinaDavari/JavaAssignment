/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.Services;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.ProductRawMaterial;
import pijavaparty.proderp.entity.RawMaterial;

/**
 *
 * @author aggel
 */
public class Fillcombo {

    /**
     *
     * @param prodraw
     * @param prod
     * @return
     */
    public LinkedList<String> FillcomboArray(List<ProductRawMaterial> prodraw,Product prod ) {
        LinkedList<String> fillcomboarray=new LinkedList<String>();
        RawMaterialDao rawdao = new RawMaterialDao();
        List<RawMaterial> raw_material;
        raw_material = rawdao.getAll();
        List<ProductRawMaterial> prodrawlist;
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        prodrawlist = prodrawdao.getMaterialsPerProduct(prod.getId());
        int num;
        num = raw_material.size();
        try {
            int j;
            int i;
            int m;
            for (i = 0; i < num; i++) {
                for (j = 0; j < prodrawlist.size(); j++) {
                    if (raw_material.get(i).getId()==prodrawlist.get(j).getRawMaterial().getId()) {
                        break;
                    }
                }
                for (m = 0; m < prodraw.size(); m++) {
                    if (raw_material.get(i).getId()==prodraw.get(m).getRawMaterial().getId()) {
                        break;
                    }
                }
                if (j==prodrawlist.size() && m==prodraw.size()) { 
                    fillcomboarray.add(raw_material.get(i).getName()+" - "+raw_material.get(i).getId());
                }
            }
            return fillcomboarray;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
            }
            
}
