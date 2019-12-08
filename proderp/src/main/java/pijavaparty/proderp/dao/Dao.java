/*
 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Natalia
 */
public class Dao {

    protected static final String URL = "jdbc:mysql://localhost:3306/proderp?serverTimezone=Etc/GMT-2";
    protected static final String initialTestURL = "jdbc:h2:mem:testdb;INIT=RUNSCRIPT FROM './src/test/resources/test.sql';DB_CLOSE_DELAY=-1";
    protected static final String testURL = "jdbc:h2:mem:testdb";
    private static boolean isFirstTest = true;
    protected static final String USERNAME = "root";
    protected static final String PASS = "st7136";
    private static Connection conn;

    public Connection getConnection() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        List<StackTraceElement> list = Arrays.asList(stackTrace);
        String urlToConnect = URL;
        for (StackTraceElement element : list) {
            if (element.getClassName().startsWith("org.junit.")) {
                urlToConnect = isFirstTest ? initialTestURL : testURL;
                isFirstTest = false;
                break;
            }
        }
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(urlToConnect, USERNAME, PASS);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    public void closeConnections(ResultSet rs, Statement st) {
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

    public void closeConnections(PreparedStatement pst) {
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
    public Connection getConn() {
        return conn;
    }
}
