package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SupplierDao.java - a class for interacting and modifying the fields of a
 * supplier.
 *
 * @author Natalia
 * @see Supplier, RawMaterialDao
 */
public class SupplierDao extends Dao implements PlainEntityI<Supplier> {

    private static final String GETALL = "SELECT * FROM Suppliers WHERE is_deleted = false";
    private static final String GETBYID = "SELECT * FROM Suppliers WHERE id = ?";
    private static final String INSERT = "INSERT INTO Suppliers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Suppliers SET full_name = ?, address = ?, phonenumber = ?, email = ? "
            + "WHERE id = ? AND is_deleted = false";
    private static final String DELETE = "UPDATE Suppliers SET is_deleted = true WHERE id = ?";
    private static final String GETRAWMATERIALPERSUPPLIER = "SELECT * FROM Raw_Materials WHERE supplier_id = ? and is_deleted = false";

    /**
     * A no-argument Constructor.
     */
    public SupplierDao() {
    }

    /**
     * Retrieve suppliers from database.
     *
     * @return A supplier data type List.
     */
    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return suppliers;
    }

    /**
     * Get raw materials provided by a supplier.
     *
     * @param id Supplier's id.
     * @return A RawMaterial type List.
     */
    public List<RawMaterial> getRawMaterialsPerSupplier(int id) {
        List<RawMaterial> rawmaterials = new ArrayList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETRAWMATERIALPERSUPPLIER);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                rawmaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return rawmaterials;
    }

    /**
     * Return a supplier with a specific id.
     *
     * @param id Supplier's id.
     * @return A Supplier data type object.
     */
    @Override
    public Supplier getById(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return null;
    }

    /**
     * Insert a new supplier.
     *
     * @param s An object of type Supplier.
     */
    @Override
    public void insert(Supplier s) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, s.getFullName());
            pst.setString(2, s.getAddress());
            pst.setLong(3, s.getPhonenumber());
            pst.setString(4, s.getEmail());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }

    /**
     * Change/Update the fields of a supplier.
     *
     * @param s An object of type Supplier.
     */
    public void update(Supplier s) {
        Supplier fromTable = getById(s.getId());
        if (fromTable != null && !fromTable.equals(s)) {
            PreparedStatement pst = null;
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, s.getFullName());
                pst.setString(2, s.getAddress());
                pst.setLong(3, s.getPhonenumber());
                pst.setString(4, s.getEmail());
                pst.setInt(5, s.getId());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeStatementAndResultSet(pst);
            }
        }
    }
    /**
     * Delete a supplier with a specific id.
     *
     * @param id Supplier's id to be deleted.
     */
    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }


}
