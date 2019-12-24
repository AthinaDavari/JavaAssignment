package pijavaparty.proderp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * Dao.java - a class with the necessary methods for the java-database
 * connection.
 *
 * @author Natalia
 */
public class Dao {

    private static Connection conn;

    /**
     * Make the connection with the database proderp.
     *
     * @return A Connection data type.
     */
    public Connection getConnection() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        List<StackTraceElement> list = Arrays.asList(stackTrace);
        String dbname = "proderp";
        for (StackTraceElement element : list) {
            if (element.getClassName().startsWith("org.junit.")) {
                dbname = "erp_progIITest";
                break;
            }
        }
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/" + dbname + "?serverTimezone=Etc/GMT-2";
                conn = DriverManager.getConnection(url, "root", "CUjpQbA^64");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * Close connections.
     *
     * @param rs A variable of type ResultSet.
     * @param st A variable of type Statement.
     */
    public void closeStatementAndResultSet(ResultSet rs, Statement st) {
        try {

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Close connections.
     *
     * @param pst A variable of type PreparedStatement.
     */
    public void closeStatementAndResultSet(PreparedStatement pst) {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public abstract List<T> getAll();
//
//    public abstract void insert(T t);
//    public abstract void delete(int id);
//    public abstract void update(T t);
    /*
    public void printList(List<T> a) {
        System.out.println(a.get(0).getClass().getSimpleName());
        if (a == null) {
            return;
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

    }*/
    /**
     * Retrieve the value of conn.
     *
     * @return A Connection data type.
     */
    public Connection getConn() {
        return conn;
    }
}
