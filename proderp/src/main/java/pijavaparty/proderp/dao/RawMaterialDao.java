/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.RawMaterial;

/**
 *
 * @author Natalia
 */
public class RawMaterialDao extends AbstractDao{
    
    private final String GETALL = "SELECT * FROM Raw_Materials";
    private final String GETBYID = "SELECT * FROM Raw_materials WHERE id = ?";
    private SupplierDao supplierDao = new SupplierDao();
    
    
    @Override
    public List<RawMaterial> getAll() {
        List<RawMaterial> rawMaterials = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rawMaterials;
    }
    public RawMaterial getById(int id) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
