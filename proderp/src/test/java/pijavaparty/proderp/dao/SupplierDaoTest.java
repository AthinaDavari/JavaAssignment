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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pijavaparty.proderp.entity.Supplier;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Natalia
 */
@TestMethodOrder(MethodOrderer.class)
public class SupplierDaoTest {

    public SupplierDaoTest() {
    }

    @BeforeAll
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
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String[] queryTable = queries.split(";");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proderp_test?serverTimezone=UTC", "root", "12345");
            for (String query : queryTable) {
                Statement st = conn.createStatement();
                st.execute(query);
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getAll method, of class SupplierDao.
     */
    @Test
    @Order(1)
    public void testGetAll() {
        System.out.println("getAll");
        SupplierDao instance = new SupplierDao();
        List<Supplier> expResult = new LinkedList();
        expResult.add(new Supplier(1, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr"));
        expResult.add(new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr"));
        List<Supplier> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SupplierDao.
     */
    @Test
    @Order(2)
    public void testGetById() {
        System.out.println("getById");
        int id = 2;
        SupplierDao instance = new SupplierDao();
        Supplier expResult = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        Supplier result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class SupplierDao.
     */
    @Test
    @Order(3)
    public void testInsert() {
        System.out.println("insert");
        Supplier s = new Supplier(3, "GoldSuppl", "Panepistimiou 27", 2105454554l, "info@gold.gr");
        SupplierDao instance = new SupplierDao();
        instance.insert(s);
        assertEquals(s, instance.getById(3));
    }

    /**
     * Test of update method, of class SupplierDao.
     */
    @Test
    @Order(4)
    public void testUpdate() {
        System.out.println("update");
        Supplier s = new Supplier(3, "GoldSupplUpdated", "Panepistimiou 30", 2105454554l, "info@gold.gr");
        SupplierDao instance = new SupplierDao();
        instance.update(s);
        assertEquals(s, instance.getById(3));
    }

    /**
     * Test of delete method, of class SupplierDao.
     */
    @Test
    @Order(5)
    public void xtestDelete() {
        System.out.println("delete");
        int id = 3;
        SupplierDao instance = new SupplierDao();
        instance.delete(id);
        assertEquals(new Supplier(3, "GoldSupplUpdated", "Panepistimiou 30", -1l, "info@gold.gr"), instance.getById(3));
    }

    /**
     * Test of deletePerm method, of class SupplierDao.
     */
    @Test
    @Order(6)
    public void ztestDeletePermanently() {
        System.out.println("deletePermanently");
        int id = 3;
        SupplierDao instance = new SupplierDao();
        instance.deletePermanently(id);
        assertEquals(null, instance.getById(3));
    }

}
