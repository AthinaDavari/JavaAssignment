/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natalia
 */
public class TestUtilities {

    public static void runTestScript() {
        String queries = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(".\\src\\test\\resources\\test.sql"));
            String line = br.readLine();

            while (line != null) {
                queries += line;
                line = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String[] queryTable = queries.split(";");
            Dao dao = new Dao();
            Connection conn = dao.getConnection();
            for (String query : queryTable) {
                Statement st = conn.createStatement();
                st.execute(query);
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
