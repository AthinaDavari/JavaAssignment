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
import pijavaparty.proderp.entity.Customer;
/**
 *
 * @author Athina P.
 */
public class COrderDao extends AbstractDao{
    
    private final String GETALL = "SELECT * FROM C_Orders";
    private final String INSERT = "INSERT INTO C_Orders(customer_id,status) VALUES(?,?)";
    
    public List<COrder> getAll() {
        List<COrder> corders = new LinkedList();
        CustomerDao c = new CustomerDao();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                corders.add(new COrder(rs.getInt(1), c.getById(rs.getInt(2)), rs.getString(3), rs.getTimestamp(4)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return corders;
    }
    
    public void insert(COrder co) {
        try {
            CustomerDao c = new CustomerDao();
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setInt(1, co.getCustomer().getId()); 
            pst.setString(2, co.getStatus());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);

        }
}
}
