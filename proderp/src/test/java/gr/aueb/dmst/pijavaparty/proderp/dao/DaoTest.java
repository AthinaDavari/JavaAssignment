package gr.aueb.dmst.pijavaparty.proderp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author athina
 */
public class DaoTest {
    
    static Connection conn;
    static final String url = "jdbc:mysql://localhost:3306/erp_progIITest?serverTimezone=Etc/GMT-2";
    static final String GETUSERBYUSERNAME = "SELECT full_name, user_name, role FROM users "
            + "WHERE user_name = 'nat' ";
    /**
     *An empty constructor
     */    
    public DaoTest() {
    }
    /**
     *Test - Set up
     * @throws java.sql.SQLException
     */
    @BeforeClass
    public static void setUpClass() throws SQLException {
        conn = DriverManager.getConnection(url, "root", "12345");
        TestUtilities.runTestScript();
    }
     /**
     * Close connection
     * @throws java.sql.SQLException
     */
    @AfterClass
    public static void tearDownClass() throws SQLException {
        conn.close();
    }


    /**
     * Test of getConnection method, of class Dao.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetConnection() throws SQLException {
        System.out.println("getConnection");
        Dao instance = new Dao();
        Connection expResult = DriverManager.getConnection(url, "root", "12345");
        Connection result = instance.getConnection();
        assertEquals(expResult.getSchema(), result.getSchema());
        assertEquals(expResult.getClientInfo(), result.getClientInfo());
    }

    /**
     * Test of closeStatementAndResultSet method, of class Dao.
     * @throws java.sql.SQLException
     */
    @Test
    public void testCloseStatementAndResultSet_ResultSet_Statement() throws SQLException {
        System.out.println("closeStatementAndResultSet");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(GETUSERBYUSERNAME);
        Dao instance = new Dao();
        instance.closeStatementAndResultSet(rs, st);
        assertEquals(true, st.isClosed());
        assertEquals(true, rs.isClosed());
    }

    /**
     * Test of closeStatementAndResultSet method, of class Dao.
     * @throws java.sql.SQLException
     */
    @Test
    public void testCloseStatementAndResultSet_PreparedStatement() throws SQLException {
        System.out.println("closeStatementAndResultSet");
        PreparedStatement pst = conn.prepareStatement(GETUSERBYUSERNAME);
        Dao instance = new Dao();
        instance.closeStatementAndResultSet(pst);
        assertEquals(true, pst.isClosed());
    }
    
}
