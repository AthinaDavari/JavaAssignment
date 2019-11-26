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
import pijavaparty.proderp.entity.SOrderItem;

/**
 *
 * @author athinaDavari
 */
public class SOrderItemDao extends Dao implements CompositeEntityI<SOrderItem> {

    private static final String GETALL = "SELECT * FROM S_order_items";
    private static final String GETBYIDS = "SELECT * FROM S_order_items WHERE s_order_id = ? AND raw_material_id = ?";
    private static final String GETITEMSPERSORDER = "SELECT * FROM S_order_items WHERE s_order_id = ?";
    private static final String INSERT = "INSERT INTO S_order_items VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM S_order_items WHERE s_order_id = ? AND raw_material_id = ?";
    private SOrderDao so = new SOrderDao();
    private RawMaterialDao rm = new RawMaterialDao();

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
            closeConnections(rs, st);
        }
        return sorders;
    }

    public SOrderItem getByIds(int soid, int rmid) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYIDS);
            pst.setInt(1, soid);
            pst.setInt(1, rmid);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pst);
        }
        return null;
    }

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
            closeConnections(rs, pst);
        }
        return soi;
    }

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
            closeConnections(pst);
        }
    }

    public void delete(SOrderItem soi) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, soi.getSorder().getId());
            pst.setInt(2, soi.getRawmaterial().getId());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(ProductRawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    @Override
    public void update(SOrderItem t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePermanently(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
