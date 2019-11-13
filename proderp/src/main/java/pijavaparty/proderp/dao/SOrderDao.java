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

/**
 *
 * @author athina
 */
public class SOrderDao extends AbstractDao{
    
    private final String GETALL = "SELECT * FROM S_Orders";
    private final String GETBYID = "SELECT * FROM S_Orders WHERE id = ?";
    private final String INSERT = "INSERT INTO S_Orders(supplier_id,status) VALUES(?,?)";
    private final String DELETE = "DELETE FROM S_Orders WHERE id = ?";
    private final String UPDATE = "UPDATE S_Orders SET supplier_id = ?, status = ?, created_at = ? WHERE id = ?";
    
    @Override
    public List<SOrder> getAll() {
        List<SOrder> sorders = new LinkedList();
        SupplierDao s= new SupplierDao();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                sorders.add(new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sorders;
    }
    
    public SOrder getById(int id) {
        PreparedStatement pst;
        SupplierDao s= new SupplierDao();
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new SOrder(rs.getInt(1), s.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4));
            }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(SOrder s) {
        SOrder fromTable = getById(s.getId());
        if (fromTable != null && !fromTable.equals(s)) {
            try {
                PreparedStatement pst = getConnection().prepareStatement(UPDATE);
                pst.setInt(1, s.getSupplier().getId());
                pst.setString(2, s.getStatus());
                pst.setTimestamp(3, s.getCreated_at());
                pst.setInt(4, s.getId());
                pst.execute();
                closeConnections(pst);
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void insert(SOrder so) {
        try {
            SupplierDao s= new SupplierDao();
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, so.getSupplier().getId()); 
            pst.setString(2, so.getStatus());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
}
    
    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
