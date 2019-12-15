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
import java.sql.Statement;
import javax.sql.DataSource;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    DataSource ds;

    @Mock
    Connection conn;

    @Mock
    ResultSet rs;

    @Mock
    PreparedStatement pst;

    @Mock
    Statement st;

    private static Supplier s1;
    private static Supplier s2;

    @Before
    public void setUp() throws SQLException {
        assertNotNull(ds);
        when(ds.getConnection()).thenReturn(conn);
        when(conn.createStatement()).thenReturn(st);

        s1 = new Supplier(3, "SideroA.E.", "A.Papadreou 30", 2105678934l, "info@sidero.gr");
        s2 = new Supplier(2, "PetaloudaA.E.", "Palaiologou 156", 2103789023l, "info@petalouda.gr");
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(s1.getFullName());
        when(rs.getString(2)).thenReturn(s1.getAddress());
        when(rs.getLong(4)).thenReturn(s1.getPhonenumber());
        when(rs.getString(5)).thenReturn(s1.getEmail());

    }

    @Test
    public void insertAndGetSupplier() throws Exception {
        SupplierDao dao = new SupplierDao(ds);
        dao.insert(s1);
        Supplier supplier = dao.getById(3);
        assertEquals(s1, supplier);
    }

}
