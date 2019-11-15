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
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author Natalia
 */
public class ProductRawMaterialDao extends AbstractDao {
    
    private static final String GETALL = "SELECT * FROM P_Materials";
    private static final String GETMATERIALSPERPRODUCT = "SELECT * FROM P_Materials WHERE product_id = ?";
    private static final String INSERT = "INSERT INTO P_Materials VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE P_Materials SET raw_material_id = ?, quantity_of_raw_material = ? WHERE product_id = ?";
    private static final String DELETE = "DELETE FROM P_Materials WHERE product_id = ? AND raw_material_id = ?";
    private ProductDao productDao = new ProductDao();
    private RawMaterialDao rawMaterialDao = new RawMaterialDao();
    
    @Override
    public List<ProductRawMaterial> getAll() {
        List<ProductRawMaterial> productRawMaterials = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                productRawMaterials.add(new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productRawMaterials;
    }
    
    public List<ProductRawMaterial> getMaterialsPerProduct(int pid) {
        List<ProductRawMaterial> productsMaterials = new LinkedList();
        try {
            PreparedStatement pst = getConnection().prepareStatement(GETMATERIALSPERPRODUCT);
            pst.setInt(1, pid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                productsMaterials.add(new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3)));
            }
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsMaterials;
    }
    
    public void insert(ProductRawMaterial prm) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, prm.getProduct().getId());
            pst.setInt(2, prm.getRawMaterial().getId());
            pst.setInt(3, prm.getQuantityOfRawMaterial());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(int pid, int rmid, int quantity) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, pid);
            pst.setInt(2, rmid);
            pst.setInt(3, quantity);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(ProductRawMaterial productRawMaterial) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(UPDATE);
            pst.setInt(1, productRawMaterial.getRawMaterial().getId());
            pst.setInt(2, productRawMaterial.getQuantityOfRawMaterial());
            pst.setInt(3, productRawMaterial.getProduct().getId());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(int pid, int rmid, int quantity) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(UPDATE);
            pst.setInt(1, rmid);
            pst.setInt(2, quantity);
            pst.setInt(3, pid);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(ProductRawMaterial prm) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, prm.getProduct().getId());
            pst.setInt(2, prm.getRawMaterial().getId());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int pid, int rmid) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, pid);
            pst.setInt(2, rmid);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
