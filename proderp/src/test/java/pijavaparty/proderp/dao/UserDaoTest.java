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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pijavaparty.proderp.entity.User;



/**
 *
 * @author athina
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUp() {
        String queries = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(".\\src\\test\\resources\\test.sql"));
            String line = br.readLine();

            while (line != null) {
                queries += line;
                line = br.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String[] queryTable = queries.split(";");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp_progIITest?serverTimezone=UTC", "root", "12345");
            for (String query : queryTable) {
                Statement st = conn.createStatement();
                st.execute(query);
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of getUser method, of class UserDao.
     */
    @Test
    public void atestGetUser() {
        System.out.println("getUser");
        String username = "ath";
        String password = "asdfg";
        UserDao instance = new UserDao();
        User expResult = new User("athina","ath","asdfg","admin");
        User result = instance.getUser(username, password);
        assertEquals(result, expResult);
    }

    /**
     * Test of getUserByUsername method, of class UserDao.
     */
    
    
    @Test
    public void btestGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "ath";
        UserDao instance = new UserDao();
        User expResult = new User("athina", "ath", "admin");
        User result = instance.getUserByUsername(username);
        assertEquals(result, expResult);
    }

    /**
     * Test of getAll method, of class UserDao.
     */
  
    @Test
    public void ctestGetAll() {
        System.out.println("getAll");
        UserDao instance = new UserDao();
        List<User> expResult = new ArrayList<User>();
        expResult.add( new User("athina", "ath", "admin"));
        expResult.add( new User("maria", "maria", "admin"));
        expResult.add( new User("natalia", "nat", "simpleuser"));
        List<User> result = instance.getAll();
        assertEquals(result, expResult);
    }

    /**
     * Test of insert method, of class UserDao.
     */
    /*
    @Test
    public void testInsert() {
        System.out.println("insert");
        User user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.insert(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of update method, of class UserDao.
     */
  /*
    @Test
    public void testUpdate() {
        System.out.println("update");
        User u = null;
        UserDao instance = new UserDao();
        instance.update(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of delete method, of class UserDao.
     */
  /*
    @Test
    public void testDelete() {
        System.out.println("delete");
        User user = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.delete(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of permissionToDeleteAnAdministratorUser method, of class UserDao.
     */
  
    @Test
    public void dtestPermissionToDeleteAnAdministratorUser() {
        System.out.println("permissionToDeleteAnAdministratorUser");
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.permissionToDeleteAnAdministratorUser();
        assertEquals(result, expResult);
    }
    
}
