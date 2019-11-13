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
import pijavaparty.proderp.entity.User;

/**
 *
 * @author athina
 */
public class UserDao extends AbstractDao {

    private final String GETUSER = "SELECT id, full_name, username, aes_decrypt(password, \"prod\"), role FROM users WHERE username = ? and password = aes_encrypt(?, \"prod\")";
    private final String GETALL = "SELECT id, full_name, username, aes_decrypt(password, \"prod\"), role FROM Users";
    private final String INSERT = "INSERT INTO Users(full_name, username, password, role) VALUES(?, ?, aes_encrypt(?, \"prod\"), ?)";
    private final String UPDATE = "UPDATE Users SET full_name = ?, username = ?, password = aes_encrypt(?, \"prod\"), role = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM Users WHERE id = ?"; 
       
    public User getUser(String username, String password) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETUSER);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
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
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public void insert(User u) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, u.getFullName());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getPassword());
            pst.setInt(4, u.getRole());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(User u) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATE);
            pst.setString(1, u.getFullName());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getPassword());
            pst.setInt(4, u.getRole());
            pst.setInt(5, u.getId());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETE);
            pst.setInt(1, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
