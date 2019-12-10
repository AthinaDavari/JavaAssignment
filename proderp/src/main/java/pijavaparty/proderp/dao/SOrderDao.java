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
import pijavaparty.proderp.entity.SOrder;
import pijavaparty.proderp.entity.SOrderItem;

/**
 *
 * @author athina
 */
public class SOrderDao extends Dao implements PlainEntityI<SOrder> {

    private static final String GETALL = "SELECT * FROM S_Orders";
    private static final String GETBYID = "SELECT * FROM S_Orders WHERE id = ?";
    private static final String INSERT = "INSERT INTO S_Orders(supplier_id,status) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM S_Orders WHERE id = ?";
    private static final String UPDATE = "UPDATE S_Orders SET supplier_id = ?, status = ?, created_at = ? WHERE id = ?";
    private static final String UPDATESTATUS = "UPDATE S_Orders SET status = ? WHERE id = ?";
    private static final String SELECTLASTID = "SELECT max(id) FROM S_Orders";
    
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
                sorders.add(new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return sorders;
    }

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
                c = new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return c;
    }
    
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

    public int bringTheIdOfTheLatestSOrder(){
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
    public void insertSOrderAndSOrderItems(SOrder so,List<SOrderItem > soi) {
        PreparedStatement pst = null;
        try {
            //SupplierDao s = new SupplierDao();
            pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, so.getSupplier().getId());
            pst.setString(2, so.getStatus());
            pst.execute();
            so.setId(bringTheIdOfTheLatestSOrder());
            for (int i=0; i< soi.size();i++) {
                SOrderItem soil;
                soil =soi.get(i);
                
                //soil.setSorder(this.getById(id));
                SOrderItemDao sod = new SOrderItemDao();
                sod.insert(soil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeStatementAndResultSet(pst);
        }
    }
    
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
