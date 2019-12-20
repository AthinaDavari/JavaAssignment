package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.SOrderItem;

/**
 * SOrderDao.java - a class for interacting and modifying the fields of a
 * supplier's order.
 *
 * @author athina
 * @see SOrder, SOrderItem
 */
public class SOrderDao extends Dao implements PlainEntityI<SOrder> {

    private static final String GETALL = "SELECT * FROM S_Orders";
    private static final String GETALLPENDINGORDERS = "SELECT * FROM S_Orders WHERE status = 'pending'";
    private static final String GETBYID = "SELECT * FROM S_Orders WHERE id = ?";
    private static final String INSERT = "INSERT INTO S_Orders(supplier_id,status) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM S_Orders WHERE id = ?";
    private static final String UPDATE = "UPDATE S_Orders SET supplier_id = ?, status = ?, created_at = ? WHERE id = ?";
    private static final String UPDATESTATUS = "UPDATE S_Orders SET status = ? WHERE id = ?";
    private static final String SELECTLASTID = "SELECT max(id) FROM S_Orders";

    /**
     * Add a new supplier's order in a List.
     *
     * @return A SOrder data type List.
     */
    @Override
    public List<SOrder> getAll() {
        List<SOrder> sorders = new LinkedList();
        SupplierDao s = new SupplierDao();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                // Not using directly rs.getTimestamp(4) due to Daylight Saving Time auto conversion
                sorders.add(new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return sorders;
    }

    public List<SOrder> getAllPendingOrders() {
        List<SOrder> sorders = new LinkedList();
        SupplierDao s = new SupplierDao();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALLPENDINGORDERS);
            while (rs.next()) {
                // Not using directly rs.getTimestamp(4) due to Daylight Saving Time auto conversion
                sorders.add(new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return sorders;
    }

    /**
     * Return a supplier's order with a specific id.
     *
     * @param id A variable of type int.
     * @return A SOrder data type object.
     */
    public SOrder getById(int id) {
        PreparedStatement pst = null;
        SOrder c = null;
        SupplierDao s = new SupplierDao();
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return c;
    }

    /**
     * Change/Update the fields of a supplier's order.
     *
     * @param s A variable of type SOrder.
     */
    public void update(SOrder s) {
        SOrder fromTable = getById(s.getId());
        PreparedStatement pst = null;
        if (fromTable != null && !fromTable.equals(s)) {
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setInt(1, s.getSupplier().getId());
                pst.setString(2, s.getStatus());
                pst.setTimestamp(3, s.getCreated_at());
                pst.setInt(4, s.getId());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeStatementAndResultSet(pst);
            }
        }
    }

    /**
     * Insert a new supplier's order.
     *
     * @param so A variable of type SOrder.
     */
    public void insert(SOrder so) {
        PreparedStatement pst = null;
        try {
            //SupplierDao s = new SupplierDao();
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, so.getSupplier().getId());
            pst.setString(2, so.getStatus());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            //closeConnections(pst);
        }
    }

    /**
     * Retrieve the last supplier's order id.
     *
     * @return An int data type variable.
     */
    public int bringTheIdOfTheLatestSOrder() {
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
        }
        return 0;
    }

    /**
     * Insert a new supplier's order and items.
     *
     * @param so A SOrder data type object.
     * @param soi A SOrderItem data type object.
     */
    public void insertSOrderAndSOrderItems(SOrder so, List<SOrderItem> soi) {
        insert(so);
        so.setId(bringTheIdOfTheLatestSOrder());
        for (int i = 0; i < soi.size(); i++) {
            SOrderItem soil;
            soil = soi.get(i);
            SOrderItemDao sod = new SOrderItemDao();
            sod.insert(soil);
        }
    }

    /**
     * Modify the status of supplier's order.
     *
     * @param orderId A variable of type int.
     * @param status A variable of type String.
     */
    public void updateStatus(int orderId, String status) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATESTATUS);
            pst.setString(1, status);
            pst.setInt(2, orderId);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Delete a supplier's order with a specific id.
     *
     * @param id A variable of type int.
     */
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
