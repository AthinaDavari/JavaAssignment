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
import pijavaparty.proderp.entity.Supplier;

/**
 * RawMaterialDao.java - a class for interacting and modifying the fields of raw
 * materials.
 *
 * @author Natalia
 * @see RawMaterial
 */
public class RawMaterialDao extends Dao implements PlainEntityI<RawMaterial> {

    private static final String GETALL = "SELECT * FROM Raw_Materials WHERE is_deleted = false";
    private static final String GETBYID = "SELECT * FROM Raw_materials WHERE id = ? AND is_deleted = false";
    private static final String INSERT = "INSERT INTO Raw_Materials(name, supplier_id, quantity, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Raw_Materials SET name = ?, supplier_id = ?, price = ? "
            + "WHERE id = ?";
    private static final String UPDATEQUANT = "UPDATE Raw_Materials SET quantity = ? WHERE id = ? AND is_deleted = false";
    private static final String DELETE = "UPDATE Raw_Materials SET is_deleted = true WHERE id = ?";
    private static final String DELETEPERM = "DELETE FROM Raw_Materials WHERE id = ?";

    private SupplierDao supplierDao = new SupplierDao();

    /**
     * Add new raw materials in a List.
     *
     * @return A RawMAterial data type List.
     */
    @Override
    public List<RawMaterial> getAll() {
        List<RawMaterial> rawMaterials = new LinkedList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return rawMaterials;
    }

    /**
     * Return a raw material with a specific id.
     *
     * @param id A variable of type int.
     *
     * @return A RawMaterial data type object.
     */
    @Override
    public RawMaterial getById(int id) {
        PreparedStatement pst = null;
        RawMaterial r = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                r = new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return r;
    }

    /**
     * Insert a new raw material.
     *
     * @param r An object of type RawMaterial.
     */
    @Override
    public void insert(RawMaterial r) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, r.getName());
            pst.setInt(2, r.getSupplier().getId());
            pst.setInt(3, r.getQuantity());
            pst.setDouble(4, r.getPrice());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Change/modify the fields of a raw material.
     *
     * @param r A variable of type RawMaterial.
     */
    public void update(RawMaterial r) {
        PreparedStatement pst = null;
        RawMaterial fromTable = getById(r.getId());
        if (fromTable != null && !fromTable.equals(r)) {
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, r.getName());
                pst.setInt(2, r.getSupplier().getId());
                pst.setDouble(3, r.getPrice());
                pst.setInt(4, r.getId());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeStatementAndResultSet(pst);
            }

        }
    }

    /**
     * Change/modify the quantity of a raw material.
     *
     * @param id A variable of type int.
     * @param quantity A variable of type int.
     */
    public void updateQuantity(int id, int quantity) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEQUANT);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

//    /**
//     * Delete permanently a raw material with a specific id.
//     *
//     * @param id A variable of type int.
//     *
//     */
//    public void deletePermanently(int id) {
//        PreparedStatement pst = null;
//        try {
//            pst = getConnection().prepareStatement(DELETEPERM);
//            pst.setInt(1, id);
//            pst.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
//
//        } finally {
//            closeStatementAndResultSet(pst);
//
//        }
//    }

    /**
     * Delete a raw material with a specific id.
     *
     * @param idd A variable of type int.
     *
     */
    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeStatementAndResultSet(pst);
        }
    }

}
