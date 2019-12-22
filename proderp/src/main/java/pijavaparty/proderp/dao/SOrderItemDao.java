package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.entity.SOrderItem;

/**
 * SOrderItemDao.java - a class for interacting and modifying the fields of
 * supplier's items.
 *
 * @author athinaDavari
 * @see SOrderItem
 */
public class SOrderItemDao extends Dao implements CompositeEntityI<SOrderItem> {

    private static final String GETALL = "SELECT * FROM S_order_items";
    private static final String GETBYIDS = "SELECT * FROM S_order_items WHERE s_order_id = ? AND raw_material_id = ?";
    private static final String GETITEMSPERSORDER = "SELECT * FROM S_order_items WHERE s_order_id = ?";
    private static final String INSERT = "INSERT INTO S_order_items VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM S_order_items WHERE s_order_id = ? AND raw_material_id = ?";
    private SOrderDao so = new SOrderDao();
    private RawMaterialDao rm = new RawMaterialDao();

    /**
     * Add new supplier's items in a List.
     *
     * @return A SOrderItem data type List.
     */
    @Override
    public List<SOrderItem> getAll() {
        List<SOrderItem> sorders = new LinkedList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                sorders.add(new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return sorders;
    }

    /**
     * Return a supplier's order item with a specific id.
     *
     * @param soid A variable of type int.
     * @param rmid A variable of type int.
     * @return A SOrderItem data type object.
     */
    public SOrderItem getByIds(int soid, int rmid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYIDS);
            pst.setInt(1, soid);
            pst.setInt(2, rmid);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return null;
    }

    /**
     * Add items sorted by supplier.
     *
     * @param soid A variable of type int.
     * @return A SOrderItem data type List.
     */
    public List<SOrderItem> getItemsperSOrder(int soid) {
        List<SOrderItem> soi = new LinkedList();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETITEMSPERSORDER);
            pst.setInt(1, soid);
            rs = pst.executeQuery();
            while (rs.next()) {
                soi.add(new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return soi;
    }

    /**
     * Insert a new supplier's item.
     *
     * @param soi An object of type SOrderItem.
     */
    public void insert(SOrderItem soi) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, soi.getSorder().getId());
            pst.setInt(2, soi.getRawmaterial().getId());
            pst.setInt(3, soi.getQuantity());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Delete a supplier's item with a specific id.
     *
     * @param soi A SOrderItem data type object.
     */
    public void delete(SOrderItem soi) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, soi.getSorder().getId());
            pst.setInt(2, soi.getRawmaterial().getId());
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Increase the quantity of raw materials.
     *
     * @param orderId A variable of type int.
     */
    public void increaseQuantities(int orderId) {
        List<SOrderItem> orderItems = getItemsperSOrder(orderId);
        RawMaterialDao rmd = new RawMaterialDao();
        for (SOrderItem sOrderItem : orderItems) {
            RawMaterial rawFromOrder = sOrderItem.getRawmaterial();
            rmd.updateQuantity(rawFromOrder.getId(), rmd.getById(rawFromOrder.getId()).getQuantity() + sOrderItem.getQuantity());
        }
    }

    /**
     * Delete a customer's item with a specific id.
     *
     * @param sordId A variable of type int.
     * @param rawMId A variable of type int.
     */
    @Override
    public void delete(int sordId, int rawMId) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, sordId);
            pst.setInt(2, rawMId);
            pst.execute();
            closeStatementAndResultSet(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

}
