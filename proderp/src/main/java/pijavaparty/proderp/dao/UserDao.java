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
 * @author athinaDavari
 */
public class UserDao extends Dao {
    
    private static final String GETUSER = "SELECT full_name, username, aes_decrypt(password, \"prod\"), role FROM users WHERE username = ? and password = aes_encrypt(?, \"prod\")";
    private static final String GETALL = "SELECT full_name, username, aes_decrypt(password, \"prod\"), role FROM Users";
    private static final String INSERT = "INSERT INTO Users(full_name, username, password, role) VALUES(?, ?, aes_encrypt(?, \"prod\"), ?)";
    private static final String UPDATE = "UPDATE Users SET full_name = ?, password = aes_encrypt(?, \"prod\"), role = ? WHERE username = ?";
    private static final String DELETE = "DELETE FROM Users WHERE username = ?";

    /**
     * Returns the fields of an already created user or null.
     * @param username
     * @param password
     * @return 
     */
    public User getUser(String username, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        User u = null;
        try {
            pst = getConnection().prepareStatement(GETUSER);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return u;
    }

    /**
     * Adds new users in a List and then returns it.
     * @return 
     */
    public List<User> getAll() {
        List<User> users = new LinkedList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return users;
    }

    /**
     * Checks if a specific user exists in the List. If so, the method is terminated. Otherwise, the user is inserted in the List.  
     * @param user 
     */
    public void insert(User user) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            for (User u : getAll()) {
                if (u.getUsername().equals(user.getUsername())) {
                    System.out.println("Username already exists");
                    return;
                }
            }
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setInt(4, user.getRole());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Changes/Updates the fields of a user.
     * @param u 
     */
    public void update(User u) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATE);
            pst.setString(1, u.getFullName());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getRole());
            pst.setString(4, u.getUsername());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Deletes a user with a specific username.
     * @param username 
     */
    public void delete(String username) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);
            pst.setString(1, username);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
    }
}
