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

    private static final String GETALL = "SELECT * FROM Customers WHERE phonenumber > 0";
    private static final String GETBYID = "SELECT * FROM Customers WHERE id = ?";
    private static final String GETBYNAME = "SELECT * FROM Customers WHERE full_name = ?";
    private static final String GETBYEMAIL = "SELECT * FROM Customers WHERE email = ?";
    private static final String INSERT = "INSERT INTO Customers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Customers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ?";
    private static final String DELETEPERM = "DELETE FROM Customers WHERE id = ?";
    private static final String UPDATEFN = "UPDATE Customers SET full_name = ? WHERE id = ?";
    private static final String UPDATEA = "UPDATE Customers SET address = ? WHERE id = ?";
    private static final String UPDATEE = "UPDATE Customers SET email = ? WHERE id = ?";
    private static final String UPDATEPHN = "UPDATE Customers SET phonenumber = ? WHERE id = ?";

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
            closeConnections(rs, st);
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
            closeConnections(rs, pst);
        }
        return c;
    }

    @Override
    public List<Customer> getByName(String name) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Customer> c = new LinkedList();
        try {
            pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pst);
        }
        return c;
    }

    public Customer getByEmail(String email) {
        PreparedStatement pst;
        Customer c = null;
        try {
            pst = getConnection().prepareStatement(GETBYEMAIL);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
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
                closeConnections(pst);
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
            closeConnections(pst);

        }

    }

    public void updateFullName(int id, String fullName) {
        CustomerDao customerDao = new CustomerDao();
        Customer c = customerDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEFN);
            pst.setString(1, fullName);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }

    }

    public void updateAddress(int id, String address) {
        CustomerDao customerDao = new CustomerDao();
        Customer c = customerDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEA);
            pst.setString(1, address);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }

    }

    public void updatePhoneNumber(int id, long phn) {
        CustomerDao customerDao = new CustomerDao();
        Customer c = customerDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEPHN);
            pst.setLong(1, phn);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }

    }

    public void updateEmail(int id, String email) {
        CustomerDao customerDao = new CustomerDao();
        Customer c = customerDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEE);
            pst.setString(1, email);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
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
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);

        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEPHN);
            pst.setInt(1, -1);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }

    }

    
    /**
     * IMPLEMENT THIS!!!!!!!!!!!!!!!!!
     * @return 
     */
    @Override
    public int bringLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
