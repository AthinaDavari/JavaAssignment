package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * SOrderDao.java - a class for interacting and modifying the fields of a
 * supplier's order.
 *
 * @author athina
 */
public class SOrderDao extends Dao implements PlainEntityI<SOrder> {

    private static final String GETALL = "SELECT * FROM S_Orders";
    private static final String GETALLPENDINGORDERS = "SELECT * FROM S_Orders WHERE status = 'pending'";
    private static final String GETBYID = "SELECT * FROM S_Orders WHERE id = ?";
    private static final String INSERT = "INSERT INTO S_Orders(supplier_id,status) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM S_Orders WHERE id = ?";
    private static final String UPDATESTATUS = "UPDATE S_Orders SET status = ? WHERE id = ?";
    private static final String SELECTLASTID = "SELECT max(id) FROM S_Orders";

    /**
     * Retrieve s_orders from database.
     *
     * @return A SOrder data type List.
     */
    @Override
    public List<SOrder> getAll() {
        List<SOrder> sorders = new ArrayList();
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

    /**
     * Get SOrders with status = 'pending' 
     * 
     * @return A SOrder data type List.
     */
    public List<SOrder> getAllPendingOrders() {
        List<SOrder> sorders = new ArrayList();
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
     * @param id SOrder's id.
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
     * Insert a new supplier's order.
     *
     * @param so A variable of type SOrder.
     */
    public void insert(SOrder so) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, so.getSupplier().getId());
            pst.setString(2, so.getStatus());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Retrieve the last supplier's order id.
     *
     * @return The id of last inserted order.
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
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return 0;
    }

    /**
     * Insert a new supplier's order and items.
     *
     * @param so A SOrder data type object.
     * @param soi A List of SOrderItem data type objects.
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
     * @param orderId SOrder's id.
     * @param status New status.
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
     * @param id SOrder's id.
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
