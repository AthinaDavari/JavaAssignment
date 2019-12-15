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
import pijavaparty.proderp.entity.ProductRawMaterial;

/**
 *
 * @author Athina P.
 */
public class ProductDao extends Dao implements PlainEntityI<Product> {

    private static final String GETALL = "SELECT * FROM Products WHERE is_deleted = false";
    private static final String GETBYID = "SELECT * FROM Products WHERE id = ? AND is_deleted = false";
    private static final String INSERT = "INSERT INTO Products(name, quantity, price) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE Products SET name = ?, price = ? WHERE id = ? AND is_deleted = false";
    private static final String DELETEPERM = "DELETE FROM Products WHERE id = ?";
    private static final String DELETE = "UPDATE Products SET is_deleted = true WHERE id = ?";
    private static final String UPDATEN = "UPDATE Products SET name = ? WHERE id = ? AND is_deleted = false";
    private static final String UPDATEQ = "UPDATE Products SET quantity = ? WHERE id = ? AND is_deleted = false";
    private static final String UPDATEP = "UPDATE Products SET price = ? WHERE id = ? AND is_deleted = false";
    private static final String SELECTLASTID = "SELECT max(id) FROM Products";

    @Override
    public List<Product> getAll() {
        List<Product> products = new LinkedList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Product p = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            }
            closeStatementAndResultSet(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return p;
    }
    
    
    public void insertProductAndProductsRecipe(Product p, List<ProductRawMaterial> rml) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getName());
            pst.setInt(2, p.getQuantity());
            pst.setDouble(3, p.getPrice());
            pst.execute();
            p.setId(bringLastId());
            for (int i=0; i< rml.size();i++) {
                ProductRawMaterial rm;
                rm =rml.get(i);
                ProductRawMaterialDao rmd = new ProductRawMaterialDao();
                rmd.insert(rm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    @Override
    public void insert(Product p) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getName());
            pst.setInt(2, p.getQuantity());
            pst.setDouble(3, p.getPrice());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }

    public void updateName(int id, String name) {
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEN);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }
        public int bringLastId(){
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(SELECTLASTID);
            if (rs.next())
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SOrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void updateQuantity(int id, int quantity) {
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEQ);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }

    public void updatePrice(int id, double price) {
        ProductDao pDao = new ProductDao();
        Product c = pDao.getById(id);
        if (c == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEP);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }

    public void update(Product p) {
        Product fromTable = getById(p.getId());
        if (fromTable != null && !fromTable.equals(p)) {
            PreparedStatement pst = null;
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, p.getName());
                pst.setDouble(2, p.getPrice());
                pst.setInt(3, p.getId());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeStatementAndResultSet(pst);
            }
        }
    }

    public void deletePermanently(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }

    }



}
