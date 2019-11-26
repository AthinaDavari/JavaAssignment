/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.entity.Supplier;

/**
 *
 * @author Natalia
 */
public class RawMaterialDao extends Dao implements PlainEntityI<RawMaterial> {

    private static final String GETALL = "SELECT * FROM Raw_Materials WHERE quantity >= 0";
    private static final String GETBYID = "SELECT * FROM Raw_materials WHERE id = ?";
    private static final String GETBYNAME = "SELECT * FROM Raw_materials WHERE name = ?";
    private static final String INSERT = "INSERT INTO Raw_Materials(name, supplier_id, quantity, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Raw_Materials SET name = ?, supplier_id = ?, quantity = ?, price = ? WHERE id = ?";
    private static final String UPDATENAME = "UPDATE Raw_Materials SET name = ? WHERE id = ?";
    private static final String UPDATESUP = "UPDATE Raw_Materials SET supplier_id = ? WHERE id = ?";
    private static final String UPDATEQUANT = "UPDATE Raw_Materials SET quantity = ? WHERE id = ?";
    private static final String UPDATEPRICE = "UPDATE Raw_Materials SET price = ? WHERE id = ?";
    private static final String DELETEPERM = "DELETE FROM Raw_Materials WHERE id = ?";

    private SupplierDao supplierDao = new SupplierDao();

    @Override
    public List<RawMaterial> getAll() {
        List<RawMaterial> rawMaterials = new LinkedList();
        Statement st =null;
        ResultSet rs = null;
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(GETALL);
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeConnections(rs, st);
        }
        return rawMaterials;
    }

    @Override
    public RawMaterial getById(int id) {
        PreparedStatement pst = null;
        RawMaterial r = null;
        ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                r = new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(rs, pst);
        }
        return r;
    }

    @Override
    public List<RawMaterial> getByName(String name) {
        List<RawMaterial> rawMaterials = new LinkedList();
        PreparedStatement pst = null;
            ResultSet rs = null;
        try {
            pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConnections(rs, pst);
        }
        return rawMaterials;
    }

    @Override
    public void insert(RawMaterial r) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, r.getName());
            pst.setInt(2, r.getSupplier().getId());
            pst.setInt(3, r.getQuantity());
            pst.setDouble(4, r.getPrice());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeConnections(pst);
        }
    }

    @Override
    public void update(RawMaterial r) {
        PreparedStatement pst = null;
        RawMaterial fromTable = getById(r.getId());
        if (fromTable != null && !fromTable.equals(r)) {
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, r.getName());
                pst.setInt(2, r.getSupplier().getId());
                pst.setInt(3, r.getQuantity());
                pst.setDouble(4, r.getPrice());
                pst.setInt(5, r.getId());
            } catch (SQLException ex) {
                Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnections(pst);
            }

        }
    }

    public void update(RawMaterial r, int supId) {
        PreparedStatement pst = null;
        RawMaterial fromTable = getById(r.getId());
        if (fromTable != null && !fromTable.equals(r)) {
            try {
                pst = getConnection().prepareStatement(UPDATE);
                pst.setString(1, r.getName());
                pst.setInt(2, supId);
                pst.setInt(3, r.getQuantity());
                pst.setDouble(4, r.getPrice());
                pst.setInt(5, r.getId());
            } catch (SQLException ex) {
                Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnections(pst);
            }

        }
    }

    public void updateName(int id, String name) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATENAME);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    public void updateSupplier(int id, Supplier supplier) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATESUP);
            pst.setInt(1, supplier.getId());
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    public void updateSupplier(int id, int supId) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATESUP);
            pst.setInt(1, supId);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    public void updateQuantity(int id, int quantity) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEQUANT);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    public void updatePrice(int id, double price) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEPRICE);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
    }

    @Override
    public void deletePermanently(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeConnections(pst);

        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = getConnection().prepareStatement(UPDATEQUANT);
            pst.setInt(1, -1);
            pst.setInt(2, id);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            closeConnections(pst);
        }
    }
    
    /**
     * IMPLEMENT THIS!!!!!!!!!!!!!
     * @return 
     */
    @Override
    public int bringLastId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
