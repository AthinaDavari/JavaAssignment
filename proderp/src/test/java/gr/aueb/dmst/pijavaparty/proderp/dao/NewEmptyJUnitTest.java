package gr.aueb.dmst.pijavaparty.proderp.dao;

import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import gr.aueb.dmst.pijavaparty.proderp.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author athina
 */

@RunWith(MockitoJUnitRunner.class)
public class NewEmptyJUnitTest {
    @InjectMocks 
    private UserDao userdao;
    @Mock
    private DataSource ds;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet rs;
    @Mock 
    private Statement mockStatement;
    @Mock
    private User u;
    @Mock
    private static final String INSERT = "INSERT INTO Users(full_name, user_name, password, role) VALUES(?, ?, aes_encrypt(?, \"prod\"), ?)";
    
    
    /**
     *
     */
    public NewEmptyJUnitTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
 
    /**
     *
     * @throws SQLException
     */
    @Before
    public void setUp() throws SQLException {
//        u= new User("anna", "anna", "12345", "admin");
//        when(rs.getString(1)).thenReturn(u.getFullName());
//        when(rs.getString(2)).thenReturn(u.getUsername());
//        when(rs.getString(3)).thenReturn(u.getPassword());
//        when(rs.getString(3)).thenReturn(u.getRole());
        MockitoAnnotations.initMocks(this);

//        u= new User("natalia", "nat", "12345", "simpleuser");
//        when(rs.getString(1)).thenReturn(u.getUsername());

    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testInsert() throws SQLException {
       UserDao ud = new UserDao();
       
//       assertEquals("anna", ud.getUserByUsername("anna").getUsername());
        Mockito.when(mockConnection.prepareStatement(INSERT)).thenReturn(mockPreparedStatement);
    }
//    
//    @Test
//    public void testDelete() {
//       new UserDao().delete(u);
//    }
}
