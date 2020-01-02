package gr.aueb.dmst.pijavaparty.proderp.GUI;

import gr.aueb.dmst.pijavaparty.proderp.GUI.customers.CustomerMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.orders.OrdersFrame;
import gr.aueb.dmst.pijavaparty.proderp.GUI.products.ProductGui;
import gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials.RawMaterialMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.storage.StorageMain;
import gr.aueb.dmst.pijavaparty.proderp.GUI.suppliers.SuppliersMenu;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author anna
 * AdminMenu is the menu for the administrators which allows them to have access to all 
 * the program's operations including adding and deleting users.
 */
public class AdminMenu extends javax.swing.JFrame {
    
    /**
     * Creates new form AdminMenu
     */
    public AdminMenu() {
        initComponents();
        seticon();
        setTitle("Administrator's Menu");
    }

    /**
     * Method that sets the icon that is shown on the frame when the program is running.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Customers = new javax.swing.JButton();
        Suppliers = new javax.swing.JButton();
        Products = new javax.swing.JButton();
        RawMaterials = new javax.swing.JButton();
        Storage = new javax.swing.JButton();
        Orders = new javax.swing.JButton();
        AddUser = new javax.swing.JButton();
        DeleteUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        LogOut = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        visitOurWebsite = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("AdminMenu"); // NOI18N
        setResizable(false);

        Customers.setBackground(new java.awt.Color(255, 255, 255));
        Customers.setText("Customers");
        Customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersActionPerformed(evt);
            }
        });

        Suppliers.setBackground(new java.awt.Color(255, 255, 255));
        Suppliers.setText("Suppliers");
        Suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersActionPerformed(evt);
            }
        });

        Products.setBackground(new java.awt.Color(255, 255, 255));
        Products.setText("Products");
        Products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsActionPerformed(evt);
            }
        });

        RawMaterials.setBackground(new java.awt.Color(255, 255, 255));
        RawMaterials.setText("Raw Materials");
        RawMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RawMaterialsActionPerformed(evt);
            }
        });

        Storage.setBackground(new java.awt.Color(255, 255, 255));
        Storage.setText("Storage");
        Storage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StorageActionPerformed(evt);
            }
        });

        Orders.setBackground(new java.awt.Color(255, 255, 255));
        Orders.setText("Orders");
        Orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdersActionPerformed(evt);
            }
        });

        AddUser.setText("Add User");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        DeleteUser.setText("Delete User");
        DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/untitled (4).png"))); // NOI18N

        LogOut.setText("Log Out");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(LogOut);
        jMenuBar1.add(jMenu4);

        visitOurWebsite.setText("Visit Our Website");
        visitOurWebsite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visitOurWebsiteMouseClicked(evt);
            }
        });
        jMenuBar1.add(visitOurWebsite);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Customers, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Products, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RawMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Storage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Orders, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Orders, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(Storage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RawMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Suppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Customers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exits from the window and returns to LogIn window.
     */
    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        LogIn.setUser(null);
        LogIn obj = new LogIn();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogOutMouseClicked

    /**
     * Closes the window and opens CustomerMenu window.
     */
    private void CustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersActionPerformed
        CustomerMenu obj = new CustomerMenu();
        obj.setVisible(true);
        dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_CustomersActionPerformed

    /**
     * Closes the window and opens SuppliersMenu window.
     */
    private void SuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersActionPerformed
        SuppliersMenu obj = new SuppliersMenu();
        obj.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_SuppliersActionPerformed

     /**
     * Closes the window and opens ProductsGui window.
     */
    private void ProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsActionPerformed
        ProductGui obj = new ProductGui();
        obj.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ProductsActionPerformed

     /**
     * Closes the window and opens RawMaterialMenu window.
     */
    private void RawMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RawMaterialsActionPerformed
        RawMaterialMenu obj = new RawMaterialMenu();
        obj.setVisible(true);
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_RawMaterialsActionPerformed

    /**
     * Closes the window and opens StorageMain window.
     */
    private void StorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StorageActionPerformed
        StorageMain obj = new StorageMain();
        obj.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_StorageActionPerformed

    /**
     * Closes the window and opens OrdersFrame window.
     */
    private void OrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdersActionPerformed
        OrdersFrame obj = new OrdersFrame();
        obj.setVisible(true);
        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_OrdersActionPerformed

    /**
     * Closes the window and opens DeleteUser window.
     */
    private void DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserActionPerformed
        new DeleteUser().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteUserActionPerformed

    /**
     * Closes the window and opens AddUser window.
     */
    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        new AddUser().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_AddUserActionPerformed

    /**
     * Closes the window, opens web and transfers user to Proderp website.
     */
    private void visitOurWebsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitOurWebsiteMouseClicked
        try {
            URI uri = new URI("http://prometheus.dmst.aueb.gr/~nkatsiapi/proderp/index.html");
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_visitOurWebsiteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUser;
    private javax.swing.JButton Customers;
    private javax.swing.JButton DeleteUser;
    private javax.swing.JMenu LogOut;
    private javax.swing.JButton Orders;
    private javax.swing.JButton Products;
    private javax.swing.JButton RawMaterials;
    private javax.swing.JButton Storage;
    private javax.swing.JButton Suppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu visitOurWebsite;
    // End of variables declaration//GEN-END:variables
}
