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
public class SupplierDao extends AbstractDao {

    private final String GETALL = "SELECT * FROM Suppliers";
    private final String GETBYID = "SELECT * FROM Suppliers WHERE id = ";
    private final String INSERT = "INSERT INTO Suppliers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private final String UPDATE = "UPDATE Suppliers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ?";

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliers;
    }

    public Supplier getById(int id) {
        Statement st;
        try {
            st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETBYID + id);
            if (rs.next()) {
                return new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Supplier s) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, s.getFullName());
            pst.setString(2, s.getAddress());
            pst.setLong(3, s.getPhonenumber());
            pst.setString(4, s.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public boolean update(Supplier s) {
        Supplier fromTable = getById(s.getId());
        if (fromTable != null) {
            
        } 
        return false;
    }

}
