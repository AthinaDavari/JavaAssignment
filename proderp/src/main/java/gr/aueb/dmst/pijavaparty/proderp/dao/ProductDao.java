package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * ProductDao.java - a class for interacting and modifying the fields of a
 * product.
 *
 * @author Athina P.
 * @see Product
 */
public class ProductDao extends Dao implements PlainEntityI<Product> {

    private static final String GETALL = "SELECT * FROM Products WHERE is_deleted = false";
    private static final String GETBYID = "SELECT * FROM Products WHERE id = ?";
    private static final String INSERT = "INSERT INTO Products(name, quantity, price) VALUES(?, ?, ?)";
    private static final String DELETE = "UPDATE Products SET is_deleted = true WHERE id = ?";
    private static final String UPDATEN = "UPDATE Products SET name = ? WHERE id = ? AND is_deleted = false";
    private static final String UPDATEQ = "UPDATE Products SET quantity = ? WHERE id = ? AND is_deleted = false";
    private static final String UPDATEP = "UPDATE Products SET price = ? WHERE id = ? AND is_deleted = false";
    private static final String SELECTLASTID = "SELECT max(id) FROM Products";

    /**
     * Retrieve products from database.
     *
     * @return A Product data type List.
     */
    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList();
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

    /**
     * Return a product with a specific id.
     *
     * @param id Product's id.
     * @return A Product data type object.
     */
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

    /**
     * Insert a new product and its ingredients to database.
     *
     * @param p Product to be added.
     * @param rml A List of RawMaterials as product's ingredients.
     */
    public void insertProductAndProductsRecipe(Product p, List<ProductRawMaterial> rml) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getName());
            pst.setInt(2, p.getQuantity());
            pst.setDouble(3, p.getPrice());
            pst.execute();
            p.setId(bringLastId());
            for (int i = 0; i < rml.size(); i++) {
                ProductRawMaterial rm;
                rm = rml.get(i);
                ProductRawMaterialDao rmd = new ProductRawMaterialDao();
                rmd.insert(rm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Insert a new product.
     *
     * @param p Product to be inserted.
     */
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

    /**
     * Modify the name of a product.
     *
     * @param id Product's id.
     * @param name New name.
     */
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

    /**
     * Retrieve the last product's id.
     *
     * @return Id of last inserted product.
     */
    public int bringLastId() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(SELECTLASTID);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return 0;
    }

    /**
     * Modify the quantity of a product.
     *
     * @param id Product's id.
     * @param quantity New quantity.
     */
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

    /**
     * Change the price of a product.
     *
     * @param id Product's id.
     * @param price New price.
     */
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

    /**
     * Delete a product and its recipe with a specific id.
     *
     * @param id Product's id.
     */
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
        ProductRawMaterialDao prmd = new ProductRawMaterialDao();
        prmd.deleteByProduct(id);

    }

}
