package gr.aueb.dmst.pijavaparty.proderp.dao;

import gr.aueb.dmst.pijavaparty.proderp.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Athina Davari
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoTest {
    
    /**
     *
     */
    public CustomerDaoTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        TestUtilities.runTestScript();
    }

    /**
     * Test of getAll method, of class CustomerDao.
     */
    @Test
    public void atestGetAll() {
        System.out.println("getAll");
        CustomerDao instance = new CustomerDao();
        List<Customer> expResult = new ArrayList<>();
        expResult.add(new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com"));
        expResult.add(new Customer(2, "Mouzouris", "Markou 14", 2104534790l, "info@mouzouris.com"));
        expResult.add(new Customer(3,"BikeMall", "Patision 18", 2136789267l, "info@bikemall.com"));
        List<Customer> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class CustomerDao.
     */
    @Test
    public void btestGetById() {
        System.out.println("getById");
        int id = 1;
        CustomerDao instance = new CustomerDao();
        Customer expResult = new Customer(1, "Ora Gia Podilato", "Tositsa 45", 2109237849l, "info@oragiapodilato.com");
        Customer result = instance.getById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class CustomerDao.
     */
    @Test
    public void dtestUpdate() {
        System.out.println("update");
        Customer c = new Customer(3,"BikeMall", "Patision 18", 2136789267l, "info@bikemall.com");
        CustomerDao instance = new CustomerDao();
        instance.update(c);
        assertEquals(c, instance.getById(3));
    }

    /**
     * Test of insert method, of class CustomerDao.
     */
    @Test
    public void etestInsert() {
        System.out.println("insert");
        Customer c = new Customer("BikeCompany", "Chamosternas 12", 2109046784l, "info@bikecompany.com");
        CustomerDao instance = new CustomerDao();
        instance.insert(c);
        Customer c1 = new Customer(4, "BikeCompany", "Chamosternas 12", 2109046784l, "info@bikecompany.com");
        assertEquals(c1, instance.getById(4));
    }

    /**
     * Test of delete method, of class CustomerDao.
     */
    @Test
    public void ctestDelete() {
        System.out.println("delete");
        int id = 2;
        CustomerDao instance = new CustomerDao();
        Customer old = instance.getById(2);
        instance.delete(id);
        assertEquals(false, instance.getAll().contains(old));
    }
    
}
