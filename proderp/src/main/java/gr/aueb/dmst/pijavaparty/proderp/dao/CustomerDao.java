package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * CustomerDao.java - a class for interacting and modifying the fields of a
 * customer.
 *
 * @author athinaDavari
 * @see Customer
 */
public class CustomerDao extends Dao implements PlainEntityI<Customer> {

    private static final String GETALL = "SELECT * FROM Customers WHERE is_deleted = false";
    private static final String GETBYID = "SELECT * FROM Customers WHERE id = ? AND is_deleted = false";
    private static final String INSERT = "INSERT INTO Customers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Customers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ? AND is_deleted = false";
    private static final String DELETE = "UPDATE Customers SET is_deleted = true WHERE id = ?";

    /**
     * Retrieve customers from database.
     *
     * @return A Customer data type List.
     */
    @Override
    public List<Customer> getAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList();
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

    /**
     * Return a customer with a specific id.
     *
     * @param id Customer's id.
     * @return A Customer data type object.
     */
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

    /**
     * Change/Update the fields of a customer.
     *
     * @param c An object of type Customer.
     */
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

    /**
     * Insert a new customer.
     *
     * @param c An object of type Customer.
     */
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

    /**
     * Delete a customer with a specific id.
     *
     * @param id Customer's id.
     */
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
