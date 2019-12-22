package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.COrderItem;

/**
 * COrderItemDao.java - a class for interacting and modifying the fields of a
 * customer's items.
 *
 * @author Athina P.
 * @see COrderItem
 */
public class COrderItemDao extends Dao implements CompositeEntityI<COrderItem> {

    private static final String GETALL = "SELECT * FROM C_order_items";
    private static final String GETBYIDS = "SELECT * FROM C_order_items WHERE c_order_id = ? AND product_id = ?";
    private static final String GETITEMSPERCORDER = "SELECT * FROM C_order_items WHERE c_order_id = ?";
    private static final String INSERT = "INSERT INTO C_order_items VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM C_order_items WHERE c_order_id = ? AND product_id = ?";
    private COrderDao co = new COrderDao();
    private ProductDao pr = new ProductDao();

    /**
     * Add new customer's items in a List.
     *
     * @return A COrder data type List.
     */
    @Override
    public List<COrderItem> getAll() {
        List<COrderItem> corders = new LinkedList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                corders.add(new COrderItem(co.getById(rs.getInt(1)), pr.getById(rs.getInt(2)), rs.getInt(3)));//δεν υπαρχει η getById στην COrdrDao
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return corders;
    }

    /**
     * Return a customer's order item with a specific id.
     *
     * @param coid A variable of type int.
     * @param prid A variable of type int.
     * @return A COrderItem data type object.
     */
    public COrderItem getByIds(int coid, int prid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYIDS);
            pst.setInt(1, coid);
            pst.setInt(2, prid);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new COrderItem(co.getById(rs.getInt(1)), pr.getById(rs.getInt(2)), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return null;
    }

    /**
     * Add items sorted by customer.
     *
     * @param coid A variable of type int.
     * @return A COrderItem data type List.
     */
    public List<COrderItem> getItemsperCOrder(int coid) {
        List<COrderItem> coi = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETITEMSPERCORDER);
            pst.setInt(1, coid);
            rs = pst.executeQuery();
            while (rs.next()) {
                coi.add(new COrderItem(co.getById(rs.getInt(1)), pr.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return coi;
    }

    /**
     * Insert a new customer's item.
     *
     * @param coi An object of type COrderItem.
     */
    @Override
    public void insert(COrderItem coi) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, coi.getCorder().getId());
            pst.setInt(2, coi.getProduct().getId());
            pst.setInt(3, coi.getQuantity());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);//εδω τι θα μπει;
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Delete a customer's item with a specific id.
     *
     * @param coi A COrderItem data type object.
     */
    public void delete(COrderItem coi) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, coi.getCorder().getId());
            pst.setInt(2, coi.getProduct().getId());
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);//εδω τι θα μπει;
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Delete a customer's item with a specific id.
     *
     * @param cordId An int data type object.
     * @param pId An int data type object.
     */
    @Override
    public void delete(int cordId, int pId) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, cordId);
            pst.setInt(2, pId);
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);//εδω τι θα μπει;
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

}
