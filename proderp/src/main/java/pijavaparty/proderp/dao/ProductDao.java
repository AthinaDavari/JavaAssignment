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

    private final String GETALL = "SELECT * FROM Products";
    private final String GETBYID = "SELECT * FROM Products WHERE id = ?";
    private final String INSERT = "INSERT INTO Products(name, quantity, price) VALUES(?, ?, ?)";
    private final String UPDATE = "UPDATE Products SET name = ?, quantity = ?, price = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM Products WHERE id = ?";

    @Override

    public List<Product> getAll() {
        List<Product> products = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
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

    public void insert(Product p) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getName());
            pst.setInt(2, p.getQuantity());
            pst.setDouble(3, p.getPrice());
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void update(Product p) {
        Product fromTable = getById(p.getId());
        if (fromTable != null && !fromTable.equals(p)) {

        }
    }

    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
