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
public class CustomerDao extends AbstractDao {
    
    private final String GETALL = "SELECT * FROM Customers";
    private final String GETBYID = "SELECT * FROM Customers WHERE id = ?";
    private final String GETBYNAME = "SELECT * FROM Customers WHERE full_name = ?";
    private final String INSERT = "INSERT INTO Customers(full_name, address, phonenumber, email) VALUES(?, ?, ?, ?)";
    private final String UPDATE = "UPDATE Customers SET full_name = ?, address = ?, phonenumber = ?, email = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM Customers WHERE id = ?";
    
     @Override
    public List<Customer> getAll() {
        List<Customer> customers = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    
    public Customer getById(int id) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public Customer getByName(String name) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insert(Customer c) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, c.getFullName());
            pst.setString(2, c.getAddress());
            pst.setLong(3, c.getPhonenumber());
            pst.setString(4, c.getEmail());
            pst.execute();
        } catch (SQLException ex) {
             Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    public void update(Customer c) {
        Customer fromTable = getById(c.getId());
        if (fromTable != null && !fromTable.equals(c)) {

        }
    }
    
    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
             Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public static void printList(List<Customer> a){
        System.out.println(a.get(0).getClass().getSimpleName());
        for(int i=0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}
