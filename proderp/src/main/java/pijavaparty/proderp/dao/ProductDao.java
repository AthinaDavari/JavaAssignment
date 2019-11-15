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
import pijavaparty.proderp.entity.Product;

/**
 *
 * @author Athina P.
 */
public class ProductDao extends AbstractDao {


    private static final String GETALL = "SELECT * FROM Products WHERE quantity > 0";
    private static final String GETBYID = "SELECT * FROM Products WHERE id = ?";
    private static final String GETBYNAME = "SELECT * FROM Products WHERE name = ?";
    private static final String INSERT = "INSERT INTO Products(name, quantity, price) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE Products SET name = ?, price = ? WHERE id = ?";
    private final String DELETEPERM = "DELETE FROM Products WHERE id = ?";
    private static final String UPDATEN = "UPDATE Products SET name = ? WHERE id = ?";
    private static final String UPDATEQ = "UPDATE Products SET quantity = ? WHERE id = ?";
    private static final String UPDATEP = "UPDATE Products SET price = ? WHERE id = ?";


    @Override

    public List<Product> getAll() {
        List<Product> products = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getDouble(4)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getById(int id) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getByName(String name) {
        PreparedStatement pst;
        List<Product> p = new LinkedList();
        try {
            pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    p.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
                }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public void insert(Product p) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getName());
            pst.setInt(2, p.getQuantity());
            pst.setDouble(3, p.getPrice());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void updateName(int id, String name) {
        //Customer fromTable = getById(c.getId());
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEN);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateQuantity(int id, int quantity) {
        //Customer fromTable = getById(c.getId());
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEQ);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updatePrice(int id, double price) {
        //Customer fromTable = getById(c.getId());
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEP);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Product p) {
        Product fromTable = getById(p.getId());
        if (fromTable != null && !fromTable.equals(p)) {
            try {
                PreparedStatement pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, p.getName());
                pst.setDouble(2, p.getPrice());
                pst.setInt(3, p.getId());
                pst.execute();
                closeConnections(pst);
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deletePermanently(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEQ);
            pst.setInt(1, -1);
            pst.setInt(1, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
