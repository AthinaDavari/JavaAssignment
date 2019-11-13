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
 * @author athinaDavari
 */
public class SOrderItemDao extends AbstractDao {

    private final String GETALL = "SELECT * FROM S_order_items";
    private final String GETBYIDS = "SELECT * FROM S_order_items WHERE s_order_id = ? AND raw_material_id = ?";
    private final String GETITEMSPERSORDER = "SELECT * FROM S_order_items WHERE s_order_id = ?";
    private SOrderDao so = new SOrderDao();
    private RawMaterialDao rm = new RawMaterialDao();

    @Override
    public List<SOrderItem> getAll() {
        List<SOrderItem> sorders = new LinkedList();
        SOrderItemDao s = new SOrderItemDao();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                sorders.add(new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sorders;
    }

    public SOrderItem getByIds(int soid, int rmid) {
        PreparedStatement pst;
        SOrderItemDao s = new SOrderItemDao();

        try {
            pst = getConnection().prepareStatement(GETBYIDS);
            pst.setInt(1, soid);
            pst.setInt(1, rmid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3));
            }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<SOrderItem> getItemsperSOrder(int soid) {
        List<SOrderItem> soi = new LinkedList();
        PreparedStatement pst;
        SOrderItemDao s = new SOrderItemDao();

        try {
            pst = getConnection().prepareStatement(GETITEMSPERSORDER);
            pst.setInt(1, soid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soi.add(new SOrderItem(so.getById(rs.getInt(1)), rm.getById(rs.getInt(2)), rs.getInt(3)));
            }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soi;
    }

}
