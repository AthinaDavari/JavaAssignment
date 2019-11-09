/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author Natalia
 */
public class ProductRawMaterialDao extends AbstractDao{
    
    private final String GETALL = "SELECT * FROM P_Materials";
    private ProductDao productDao = new ProductDao();
    private RawMaterialDao rawMaterialDao = new RawMaterialDao();

    @Override
    public List getAll() {
     List<ProductRawMaterial> productRawMaterials = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                productRawMaterials.add(new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productRawMaterials;
    }    
    
}
