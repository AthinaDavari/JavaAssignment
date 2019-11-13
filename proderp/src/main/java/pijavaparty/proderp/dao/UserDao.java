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
import pijavaparty.proderp.entity.Customer;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author athina
 */
public class UserDao extends AbstractDao{
    
    private final String GETUSER = "SELECT * FROM users WHERE user_name = ? AND password = ?";
    private final String GETALL = "SELECT * FROM Users";
    
    public User getUser(String username, String password) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETUSER);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users; 
    }
}
