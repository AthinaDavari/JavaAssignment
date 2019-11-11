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
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author athina
 */
public class SOrderDao extends AbstractDao{
    
    private final String GETALL = "SELECT * FROM S_Orders";
    private final String INSERT = "INSERT INTO S_Orders(supplier_id,status) VALUES(?,?)";
    
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
}
