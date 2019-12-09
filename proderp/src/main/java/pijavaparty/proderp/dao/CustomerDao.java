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
import pijavaparty.proderp.entity.Customer;

/**
 *
 * @author athinaDavari
 */
public class CustomerDao  extends Dao implements PlainEntityI<Customer> {

    private static final String GETALL = "SELECT * FROM Customers WHERE is_deleted = 0";
    private static final String GETBYID = "SELECT * FROM Customers WHERE id = ?";
    private static final String INSERT = "INSERT INTO Customers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Customers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ?";
    private static final String DELETE = "UPDATE Customers SET is_deleted = 1 WHERE id = ?";
    private static final String DELETEPERM = "DELETE FROM Customers WHERE id = ?";

    @Override
    public List<Customer> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Customer> customers = new LinkedList();
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return customers;
    }

   
    @Override
    public Customer getById(int id) {
        Customer c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return c;
    }

    @Override
    public void update(Customer c) {
        Customer fromTable = getById(c.getId());
        PreparedStatement pst = null;
        if (fromTable != null && !fromTable.equals(c)) {
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, c.getFullName());
                pst.setString(2, c.getAddress());
                pst.setLong(3, c.getPhonenumber());
                pst.setString(4, c.getEmail());
                pst.setInt(5, c.getId());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeStatementAndResultSet(pst);
            }
        }
    }

    @Override
    public void insert(Customer c) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, c.getFullName());
            pst.setString(2, c.getAddress());
            pst.setLong(3, c.getPhonenumber());
            pst.setString(4, c.getEmail());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);

        }

    }

    public void deletePermanently(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);

        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }   

}
