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
    private static final String UPDATE = "UPDATE P_Materials SET raw_material_id = ?, quantity_of_raw_material = ? WHERE product_id = ?";
    private static final String DELETE = "DELETE FROM P_Materials WHERE product_id = ? AND raw_material_id = ?";
    private static final String GETBYIDS = "SELECT * FROM P_Materials WHERE product_id = ? AND raw_material_id = ?";
    private ProductDao productDao = new ProductDao();
    private RawMaterialDao rawMaterialDao = new RawMaterialDao();

    /**
     * Add new raw materials of a product in a List.
     *
     * @return A ProductRawMaterial data type List.
     */
    @Override
    public List<ProductRawMaterial> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<ProductRawMaterial> productRawMaterials = new LinkedList();
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
     * Add raw materials of a product.
     *
     * @param pid A variable of type int.
     * @return A ProductRawMaterial data type List.
     */
    public List<ProductRawMaterial> getMaterialsPerProduct(int pid) {
        List<ProductRawMaterial> productsMaterials = new LinkedList();
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
     * Insert new raw materials of a product..
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


//    /**
//     * Insert new raw materials of a product..
//     *
//     * @param pid A variable of type int.
//     * @param rmid A variable of type int.
//     * @param quantity A variable of type int.
//     */
//    public void insert(int pid, int rmid, int quantity) {
//        PreparedStatement pst = null;
//        try {
//            pst = getConnection().prepareStatement(INSERT);
//            pst.setInt(1, pid);
//            pst.setInt(2, rmid);
//            pst.setInt(3, quantity);
//            pst.execute();
//            closeStatementAndResultSet(pst);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeStatementAndResultSet(pst);
//        }
//    }
//
//    /**
//     * Change/Modify the fields of a product's raw materials.
//     *
//     * @param productRawMaterial A ProductRawMaterial data type object.
//     */
//    public void update(ProductRawMaterial productRawMaterial) {
//        PreparedStatement pst = null;
//        try {
//            pst = getConnection().prepareStatement(UPDATE);
//            pst.setInt(1, productRawMaterial.getRawMaterial().getId());
//            pst.setInt(2, productRawMaterial.getQuantityOfRawMaterial());
//            pst.setInt(3, productRawMaterial.getProduct().getId());
//            pst.execute();
//            closeStatementAndResultSet(pst);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeStatementAndResultSet(pst);
//        }
//
//    }
//
//    /**
//     * Change/Modify the fields of a product's raw materials.
//     *
//     * @param pid A variable of type int.
//     * @param rmid A variable of type int.
//     * @param quantity A variable of type int.
//     */
//    public void update(int pid, int rmid, int quantity) {
//        PreparedStatement pst = null;
//        try {
//            pst = getConnection().prepareStatement(UPDATE);
//            pst.setInt(1, rmid);
//            pst.setInt(2, quantity);
//            pst.setInt(3, pid);
//            pst.execute();
//            closeStatementAndResultSet(pst);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeStatementAndResultSet(pst);
//        }
//
//    }
//
//    /**
//     * Delete the raw materials of a product.
//     *
//     * @param prm A ProductRawMaterial data type object.
//     */
//    public void delete(ProductRawMaterial prm) {
//        PreparedStatement pst = null;
//        try {
//            pst = getConnection().prepareStatement(DELETE);
//            pst.setInt(1, prm.getProduct().getId());
//            pst.setInt(2, prm.getRawMaterial().getId());
//            pst.execute();
//            closeStatementAndResultSet(pst);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            closeStatementAndResultSet(pst);
//        }
//
//    }


    /**
     * Delete the raw materials of a product.
     *
     * @param pid A variable of type int.
     * @param rmid A variable of type int.
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
     * Return the raw materials of a product with a specific id.
     *
     * @param pid A variable of type int.
     * @param rmid A variable of type int.
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

}
