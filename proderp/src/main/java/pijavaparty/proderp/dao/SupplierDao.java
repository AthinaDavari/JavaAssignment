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
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
public class SupplierDao extends Dao implements PlainEntityI<Supplier> {

    private static final String GETALL = "SELECT * FROM Suppliers WHERE phonenumber > 0";
    private static final String GETBYID = "SELECT * FROM Suppliers WHERE id = ?";
    private static final String GETBYNAME = "SELECT * FROM Suppliers WHERE full_name = ?";
    private static final String INSERT = "INSERT INTO Suppliers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Suppliers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ?";
    private static final String DELETEPERM = "DELETE FROM Suppliers WHERE id = ?";
    private static final String UPDATEPN = "UPDATE Suppliers SET phonenumber = ? WHERE id = ?";

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers = new LinkedList();
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
            closeConnections(rs, st);
        }
        return suppliers;
    }

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
            closeConnections(rs, pst);
        }
        return null;
    }

    @Override
    public List<Supplier> getByName(String name) {
        List<Supplier> suppliers = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pst);
        }
        return suppliers;
    }

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
            closeConnections(pst);
        }

    }

    @Override
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
                closeConnections(pst);
            }
        }
    }

    @Override
    public void deletePermanently(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEPN);
            pst.setInt(1, -1);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    /**
     * IMPLEMENT THIS!!!!!!!!!!!
     * @return 
     */
    @Override
    public int bringLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
