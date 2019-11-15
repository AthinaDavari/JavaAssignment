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
import java.util.List;


/**
 *
 * @author Natalia
 */
public abstract class AbstractDao<T> {

    protected static final String URL = "jdbc:mysql://localhost:3306/proderp?serverTimezone=Etc/GMT-2";
    protected static final String USERNAME = "root";
    protected static final String PASS = "st7136";

    protected static final String PASS = "12345";
    private Connection conn;

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnections(PreparedStatement pst) {
        try {
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public abstract List<T> getAll();
   
    public void printList(List<T> a){
        System.out.println(a.get(0).getClass().getSimpleName());
        if(a == null){
            return;
        }
        for(int i=0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
        
    }
}


