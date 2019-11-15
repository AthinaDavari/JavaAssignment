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
public class RawMaterialDao extends AbstractDao {

    private static final String GETALL = "SELECT * FROM Raw_Materials";
    private static final String GETBYID = "SELECT * FROM Raw_materials WHERE id = ?";
    private static final String GETBYNAME = "SELECT * FROM Raw_materials WHERE name = ?";
    private static final String INSERT = "INSERT INTO Raw_Materials(name, supplier_id, quantity, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Raw_Materials SET name = ?, supplier_id = ?, quantity = ?, price = ? WHERE id = ?";
    private static final String UPDATENAME = "UPDATE Raw_Materials SET name = ? WHERE id = ?";
    private static final String UPDATESUP = "UPDATE Raw_Materials SET supplier_id = ? WHERE id = ?";
    private static final String UPDATEQUANT = "UPDATE Raw_Materials SET quantity = ? WHERE id = ?";
    private static final String UPDATEPRICE = "UPDATE Raw_Materials SET price = ? WHERE id = ?";
    private final String DELETEPERM = "DELETE FROM Raw_Materials WHERE id = ?";

    private SupplierDao supplierDao = new SupplierDao();

    @Override
    public List<RawMaterial> getAll() {
        List<RawMaterial> rawMaterials = new LinkedList();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(GETALL);
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rawMaterials;
    }

    public RawMaterial getById(int id) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(GETBYID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<RawMaterial> getByName(String name) {
        List<RawMaterial> rawMaterials = new LinkedList();
        try {
            PreparedStatement pst = getConnection().prepareStatement(GETBYNAME);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rawMaterials.add(new RawMaterial(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(5), supplierDao.getById(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rawMaterials;
    }

    public void insert(RawMaterial r) {
        PreparedStatement pst;
        try {
            pst = getConnection().prepareStatement(INSERT);
            pst.setString(1, r.getName());
            pst.setInt(2, r.getSupplier().getId());
            pst.setInt(3, r.getQuantity());
            pst.setDouble(4, r.getPrice());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(RawMaterial r) {
        PreparedStatement pst;
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
            }

        }
    }

    public void update(RawMaterial r, int supId) {
        PreparedStatement pst;
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
            }

        }
    }

    public void updateName(int id, String name) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATENAME);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSupplier(int id, Supplier supplier) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATESUP);
            pst.setInt(1, supplier.getId());
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSupplier(int id, int supId) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATESUP);
            pst.setInt(1, supId);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateQuantity(int id, int quantity) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEQUANT);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePrice(int id, double price) {
        RawMaterial r = getById(id);
        if (r == null) {
            return;
        }
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEPRICE);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePerm(RawMaterial r) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, r.getId());
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void deletePerm(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(DELETEPERM);
            pst.setInt(1, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(int id) {
        try {
            PreparedStatement pst = getConnection().prepareStatement(UPDATEQUANT);
            pst.setInt(1, -1);
            pst.setInt(2, id);
            pst.execute();
            closeConnections(pst);
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
