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
 * @author Athina Davari
 */


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {

    /**
     *
     */
    public UserDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();

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
        User expResult = new User("athina", "ath", "asdfg", "admin");
        User result = instance.getUser(username, password);
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class UserDao.
     */
    @Test
    public void ctestGetAll() {
        System.out.println("getAll");
        UserDao instance = new UserDao();
        List<User> expResult = new ArrayList<User>();
        expResult.add(new User("athina", "ath", "admin"));
        expResult.add(new User("maria", "maria", "admin"));
        expResult.add(new User("natalia", "nat", "simpleuser"));
        List<User> result = instance.getAll();
         assertEquals(expResult, result);
    }

    
    /**
     * Test of insert method, of class UserDao.
     */
    
    @Test
    public void etestInsert() {
        System.out.println("insert");
        User user = new User("daniel", "dan", "12345", "simpleuser");
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.insert(user);
        assertEquals(expResult, result);
        User user1 = new User("daniel", "dan", "simpleuser");
        assertEquals(user1, instance.getUserByUsername("dan"));
    }
    
    /**
     * Test of delete method, of class UserDao.
     */
    
    @Test
    public void ftestDelete() {
        System.out.println("delete");
        User user = new User("maria", "maria", "admin");
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.delete(user);
        assertEquals(expResult, result);
        assertEquals(null, instance.getUserByUsername("maria"));
    }
     
    /**
     * Test of permissionToDeleteAnAdministratorUser method, of class UserDao.
     */
    @Test
    public void dtestPermissionToDeleteAnAdministratorUser() {
        System.out.println("permissionToDeleteAnAdministratorUser");
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.permissionToDeleteAnAdministratorUser();
        assertEquals(expResult, result);
    }

}
