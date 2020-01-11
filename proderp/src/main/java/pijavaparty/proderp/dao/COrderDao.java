package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.COrder;
import pijavaparty.proderp.entity.COrderItem;

/**
 * COrderDao.java - a class for interacting and modifying the fields of a
 * customer's order.
 *
 * @author Athina P.
 */
public class COrderDao extends Dao implements PlainEntityI<COrder> {

    private static final String GETALL = "SELECT * FROM C_Orders";
    private static final String GETALLEXCEPTFROMDELIVERED = "SELECT * FROM C_Orders WHERE status = 'preparing' OR status = 'ready'";
    private static final String GETBYID = "SELECT * FROM C_Orders WHERE id = ?";
    private static final String UPDATESTATUS = "UPDATE C_Orders SET status = ? WHERE id = ?";
    private static final String INSERT = "INSERT INTO C_Orders(customer_id,status, user_name) VALUES(?,?, ?)";
    private static final String DELETE = "DELETE FROM C_Orders WHERE id = ?";
    private static final String SELECTLASTID = "SELECT max(id) FROM C_Orders";
    private static UserDao ud = new UserDao();

    /**
     * Add new orders in a List and then return it.
     *
     * @return A COrder data type List.
     * @see COrder
     */
    @Override
    public List<COrder> getAll() {
        List<COrder> corders = new LinkedList();
        CustomerDao c = new CustomerDao();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                corders.add(new COrder(rs.getInt(1), c.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4)), ud.getUserByUsername(rs.getString(5))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return corders;
    }

    /**
     * Add to a List customer's orders that are either preparing or pending.
     *
     * @return A COrder data type List.
     */
    public List<COrder> getAllExceptFromDelivered() {
        List<COrder> corders = new LinkedList();
        CustomerDao c = new CustomerDao();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALLEXCEPTFROMDELIVERED);
            while (rs.next()) {
                corders.add(new COrder(rs.getInt(1), c.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4)), ud.getUserByUsername(rs.getString(5))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return corders;
    }

    /**
     * Return a customer's order with a specific id.
     *
     * @param id A variable of type int.
     * @return A COrder data type object.
     */
    @Override
    public COrder getById(int id) {
        PreparedStatement pst = null;
        COrder c = null;
        CustomerDao cu = new CustomerDao();
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new COrder(rs.getInt(1), cu.getById(rs.getInt(2)), rs.getString(3), Timestamp.valueOf(rs.getString(4)), ud.getUserByUsername(rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return c;
    }

    /**
     * Modify the status of customer's order.
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
     * Insert a new order.
     *
     * @param co A COrder data type object.
     */
    @Override
    public void insert(COrder co) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, co.getCustomer().getId());
            pst.setString(2, co.getStatus());
            pst.setString(3, co.getUser().getUsername());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Retrieve the last customer's order id.
     *
     * @return An int data type.
     */
    public int bringTheIdOfTheLatestCOrder() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(SELECTLASTID);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Insert a new customer's order and items.
     *
     * @param co A COrder data type object.
     * @param coi A COrder data type List.
     */
    public void insertCOrderAndCOrderItems(COrder co, List<COrderItem> coi) {
        insert(co);
        co.setId(bringTheIdOfTheLatestCOrder());
        for (int i = 0; i < coi.size(); i++) {
            COrderItem coil;
            coil = coi.get(i);
            COrderItemDao cod = new COrderItemDao();
            cod.insert(coil);
        }
    }

    /**
     * Delete a customer's order with a specific id.
     *
     * @param id A variable of type int.
     */
    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

}
