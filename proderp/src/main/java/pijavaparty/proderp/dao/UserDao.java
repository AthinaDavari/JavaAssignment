package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.User;

/**
 * UserDao.java - a class for interacting and modifying the fields of a user.
 *
 * @author athinaDavari
 * @see User
 */
public class UserDao extends Dao {

    private static final String GETUSER = "SELECT full_name, user_name, aes_decrypt(password, \"prod\"), role FROM users "
            + "WHERE user_name = ? and password = aes_encrypt(?, \"prod\") and is_deleted = false";
    private static final String GETUSERBYUSERNAME = "SELECT full_name, user_name, role FROM users "
            + "WHERE user_name = ? and is_deleted=false ";
    private static final String GETALL = "SELECT full_name, user_name, role FROM Users "
            + "WHERE is_deleted=false";
    private static final String INSERT = "INSERT INTO Users(full_name, user_name, password, role) VALUES(?, ?, aes_encrypt(?, \"prod\"), ?)";
    private static final String DELETE = "UPDATE Users SET is_deleted = true WHERE user_name = ?";
    private static final String PERMISSIONTODELETE = "SELECT COUNT(*) FROM users WHERE role = 'admin'";

    /**
     * Returns the fields of an already created user or null.
     *
     * @param username Username to be checked.
     * @param password Password to be checked.
     * @return Found User.
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
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return u;
    }

    /**
     * Return the fields of an already created user or null - without password.
     *
     * @param username Username to be checked.
     * @return Found User.
     */
    public User getUserByUsername(String username) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        User u = null;
        try {
            pst = getConnection().prepareStatement(GETUSERBYUSERNAME);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, pst);
        }
        return u;
    }

    /**
     * Get users from database - without password.
     *
     * @return A User data type List.
     */
    public List<User> getAll() {
        List<User> users = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return users;
    }

    /**
     * Check if a specific user exists in the List. If so, the method is
     * terminated. Otherwise, the user is inserted in the List.
     *
     * @param user A variable of type User.
     * @return
     */
    public boolean insert(User user) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            for (User u : getAll()) {
                if (u.getUsername().equals(user.getUsername())) {
                    System.out.println("Username already exists");
                    return false;
                }
            }
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            closeStatementAndResultSet(pst);
        }
    }

    /**
     * Delete a user with a specific username.
     *
     * @param user User to be deleted.
     * @return true if deleted - false otherwise
     */
    public boolean delete(User user) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETE);

            if ((permissionToDeleteAnAdministratorUser() == true && user.getRole() == "simpleuser") ){
                pst.setString(1, user.getUsername());
                pst.execute();
            return true;
            }
            pst.setString(1, user.getUsername());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(pst);
        }
        return false;
    }

    /**
     * Return if at least one administrator user exists or not.
     *
     * @return true if exists - false otherwise
     */
    public boolean permissionToDeleteAnAdministratorUser() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(PERMISSIONTODELETE);
            if (rs.next()) {
                if (rs.getInt(1) > 1) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeStatementAndResultSet(rs, st);
        }
        return false;
    }
}
