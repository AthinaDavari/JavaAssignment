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
import pijavaparty.proderp.entity.COrder;

/**
 *
 * @author Athina P.
 */
public class COrderDao extends Dao implements PlainEntityI<COrder> {

    private static final String GETALL = "SELECT * FROM C_Orders";
    private static final String GETBYID = "SELECT * FROM C_Orders WHERE id = ?";
    private static final String INSERT = "INSERT INTO C_Orders(customer_id,status) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM C_Orders WHERE id = ?";

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
                corders.add(new COrder(rs.getInt(1), c.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, st);
        }
        return corders;
    }

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
                c = new COrder(rs.getInt(1), cu.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pst);
        }
        return c;
    }

    
    @Override
    public void insert(COrder co) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, co.getCustomer().getId());
            pst.setString(2, co.getStatus());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
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
            Logger.getLogger(COrderDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    @Override
    public int bringLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(COrder t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
