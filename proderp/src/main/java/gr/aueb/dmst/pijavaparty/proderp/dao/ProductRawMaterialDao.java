package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * ProductRawMaterialDao.java - a class for interacting and modifying the fields
 * of a product's raw materials.
 *
 * @author Natalia
 * @see ProductRawMaterial
 */
public class ProductRawMaterialDao extends Dao implements CompositeEntityI<ProductRawMaterial> {

    private static final String GETALL = "SELECT * FROM P_Materials";
    private static final String GETMATERIALSPERPRODUCT = "SELECT * FROM P_Materials WHERE product_id = ?";
    private static final String INSERT = "INSERT INTO P_Materials VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM P_Materials WHERE product_id = ? AND raw_material_id = ?";
    private static final String GETBYIDS = "SELECT * FROM P_Materials WHERE product_id = ? AND raw_material_id = ?";
    private static final String DELETEBYPRODUCT = "DELETE FROM P_Materials WHERE product_id = ?";   
    private ProductDao productDao = new ProductDao();
    private RawMaterialDao rawMaterialDao = new RawMaterialDao();

    /**
     * Retrieve P_Materials from database.
     *
     * @return A ProductRawMaterial data type List.
     */
    @Override
    public ArrayList<ProductRawMaterial> getAll() {
        Statement st = null;
        ResultSet rs = null;
        ArrayList<ProductRawMaterial> productRawMaterials = new ArrayList();
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                productRawMaterials.add(new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return productRawMaterials;
    }
    
    /**
     * Get recipe of a specific product.
     *
     * @param pid A variable of type int.
     * @return A List of RawMaterials with their quantity.
     */
    public ArrayList<ProductRawMaterial> getMaterialsPerProduct(int pid) {
        ArrayList<ProductRawMaterial> productsMaterials = new ArrayList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETMATERIALSPERPRODUCT);
            pst.setInt(1, pid);
            rs = pst.executeQuery();
            while (rs.next()) {
                productsMaterials.add(new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return productsMaterials;
    }

    /**
     * Insert new raw materials of a product.
     *
     * @param prm An object of type ProductRawMaterial.
     */
    public void insert(ProductRawMaterial prm) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, prm.getProduct().getId());
            pst.setInt(2, prm.getRawMaterial().getId());
            pst.setInt(3, prm.getQuantityOfRawMaterial());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }


    /**
     * Delete a raw material of a product.
     *
     * @param pid Product's id.
     * @param rmid RawMaterial's id.
     */
    @Override
    public void delete(int pid, int rmid) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, pid);
            pst.setInt(2, rmid);
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }

    /**
     * Return the raw material and quantity with a specific id.
     *
     * @param pid Product's id.
     * @param rmid RawMaterial's id.
     * @return A ProductRawMaterial data type object.
     */
    @Override
    public ProductRawMaterial getByIds(int pid, int rmid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYIDS);
            pst.setInt(1, pid);
            pst.setInt(2, rmid);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new ProductRawMaterial(productDao.getById(rs.getInt(1)), rawMaterialDao.getById(rs.getInt(2)), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return null;
    }
    
    /**
     * Delete a product's recipe
     * 
     * @param pid Product's id
     */
    public void deleteByProduct(int pid) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETEBYPRODUCT);
            pst.setInt(1, pid);
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

}
