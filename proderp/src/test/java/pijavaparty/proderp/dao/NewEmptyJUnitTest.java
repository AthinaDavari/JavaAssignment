/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import static pijavaparty.proderp.dao.TestUtilities.runTestScript;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author athina
 */

@RunWith(MockitoJUnitRunner.class)
public class NewEmptyJUnitTest {
    @Mock
    private DataSource ds;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;
    
    private User u;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
 
    
    
    @Before
    public void setUp() throws SQLException {
        u= new User("anna", "anna", "12345", "admin");
        when(rs.getString(1)).thenReturn(u.getFullName());
        when(rs.getString(2)).thenReturn(u.getUsername());
        when(rs.getString(3)).thenReturn(u.getPassword());
        when(rs.getString(3)).thenReturn(u.getRole());

//        u= new User("natalia", "nat", "12345", "simpleuser");
//        when(rs.getString(1)).thenReturn(u.getUsername());

    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testInsert() {
       new UserDao().insert(u);
       UserDao ud = new UserDao();
        assertEquals("anna", ud.getUserByUsername("anna").getUsername());
    }
//    
//    @Test
//    public void testDelete() {
//       new UserDao().delete(u);
//    }
}
