package gr.aueb.dmst.pijavaparty.proderp.services;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author aggel, Athina Davari
 */
public class Fillcombo {

    /**
     * Return the raw materials not included in product's recipe
     *
     * @param prodraw-list of raw materials included in product's recipe
     * temporarily saved in java until we save the process
     * @param prod-the product which we want to change the recipe (add
     * ingredients) or the product we want to create
     * @return list of raw materials (string type objects with raw materials'
     * names and ids) not included in product's recipe
     */
    public ArrayList<String> FillcomboArray(List<ProductRawMaterial> prodraw, Product prod) {
        ArrayList<String> fillcomboarray = new ArrayList<String>();
        RawMaterialDao rawdao = new RawMaterialDao();
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        List<RawMaterial> raw_material;

        raw_material = rawdao.getAll();//take all raw materials from database
        List<ProductRawMaterial> prodrawlist;
        /*get all rawmaterials' ids included in product's recipe.
        If the product doesn't exist for now in database (we create the product now),
        the list has no elements.
         */
        prodrawlist = prodrawdao.getMaterialsPerProduct(prod.getId());
        int num = raw_material.size();//the number of rawmaterials in database
        int prodrawlistsize = prodrawlist.size();//the number of rawmaterials in product's recipe
        int prodrawsize = prodraw.size();//of raw materials included in product's recipe
        try {
            int j;//counter of 2nd loop
            int m;//counter of 3rd loop
            for (int i = 0; i < num; i++) {//start 1st for

                //find if a raw material exists in product's recipe in database
                for (j = 0; j < prodrawlistsize; j++) {//start 2nd for

                    //check if a raw material from database is equal to a raw material from the prodrawlist list
                    if (raw_material.get(i).getId() == prodrawlist.get(j).getRawMaterial().getId()) {
                        break;
                    }//end if

                }//end 2nd for

                /*
                If the raw material doesn't exist in prodrawlist,
                find if a raw material from the supplier exist in product's recipe
                (temporarily saved part of product's recipe in java)
                 */
                for (m = 0; m < prodrawsize; m++) {//start 3rd for

                    //check if a raw material from database is equal to a raw material from the prodraw list
                    if (raw_material.get(i).getId() == prodraw.get(m).getRawMaterial().getId()) {
                        break;
                    }//end if

                }//end 3rd for

                //if a raw material from database doesnt exist in the prodrawlist or prodraw list add it to the list
                if (j == prodrawlistsize && m == prodrawsize) {
                    fillcomboarray.add(raw_material.get(i).getName() + " - " + raw_material.get(i).getId());
                }//end if

            }//end 1st for
            return fillcomboarray;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
