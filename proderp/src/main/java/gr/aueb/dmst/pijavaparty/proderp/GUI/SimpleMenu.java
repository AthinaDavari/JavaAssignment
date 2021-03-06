
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
 *
 * @author aggel, anna
 */
public class SimpleMenu extends javax.swing.JFrame {

    /**
     * Creates new form SimpleMenu
     */
    public SimpleMenu() {
        initComponents();
        seticon();
        setTitle("User's Menu");
    }

    /**
     * Method that sets the icon that is shown on the frame when the program is running.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));

    }

    /**
     * Set SimpleMenu window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customers = new javax.swing.JButton();
        suppliers = new javax.swing.JButton();
        products = new javax.swing.JButton();
        rawMaterials = new javax.swing.JButton();
        storage = new javax.swing.JButton();
        orders = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        visitOurWebsite = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customers.setBackground(new java.awt.Color(255, 255, 255));
        customers.setText("Customers");
        customers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersActionPerformed(evt);
            }
        });

        suppliers.setBackground(new java.awt.Color(255, 255, 255));
        suppliers.setText("Suppliers");
        suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersActionPerformed(evt);
            }
        });

        products.setBackground(new java.awt.Color(255, 255, 255));
        products.setText("Products");
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });

        rawMaterials.setBackground(new java.awt.Color(255, 255, 255));
        rawMaterials.setText("Raw Materials");
        rawMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rawMaterialsActionPerformed(evt);
            }
        });

        storage.setBackground(new java.awt.Color(255, 255, 255));
        storage.setText("Storage");
        storage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storageActionPerformed(evt);
            }
        });

        orders.setBackground(new java.awt.Color(255, 255, 255));
        orders.setText("Orders");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/untitled (4).png"))); // NOI18N

        logOut.setText("Log Out");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);
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
                .addComponent(customers, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(products, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rawMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(storage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orders, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(233, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(235, 235, 235)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(suppliers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(products, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rawMaterials, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(storage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(175, 175, 175)
                    .addComponent(jLabel1)
                    .addContainerGap(154, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Opens the window and opens CustomerMenu window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the customer button.
     */
    private void customersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersActionPerformed
        CustomerMenu obj = new CustomerMenu();
        obj.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_customersActionPerformed
    /**
     * Exits from the window and returns to LogIn window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the logout button.
     */
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        LogIn.setUser(null);
        LogIn obj = new LogIn();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutMouseClicked
    /**
     * Opens the window, opens web and transfers user to Proderp website.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the visitOurWebsite button.
     */
    private void visitOurWebsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitOurWebsiteMouseClicked
        try {
            URI uri = new URI("http://prometheus.dmst.aueb.gr/~nkatsiapi/proderp/index.html");
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_visitOurWebsiteMouseClicked
    /**
     * Opens the window and opens SuppliersMenu window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the suppliers button.
     */
    private void suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersActionPerformed
        SuppliersMenu obj = new SuppliersMenu();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_suppliersActionPerformed
     /**
     * Opens the window and opens ProductsGui window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the products button.
     */
    private void productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsActionPerformed
        ProductGui obj = new ProductGui();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_productsActionPerformed
     /**
     * Opens the window and opens RawMaterialMenu window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the raw materials button. 
     */
    private void rawMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rawMaterialsActionPerformed
        RawMaterialMenu obj = new RawMaterialMenu();
        obj.setVisible(true);
        dispose();    
    }//GEN-LAST:event_rawMaterialsActionPerformed
    /**
     * Opens the window and opens StorageMain window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the storage button.
     */
    private void storageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storageActionPerformed
        StorageMain obj = new StorageMain();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_storageActionPerformed
    /**
     * Opens the window and opens OrdersFrame window.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the orders button.
     */
    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        OrdersFrame obj = new OrdersFrame();
        obj.setVisible(true);
        dispose();  
    }//GEN-LAST:event_ordersActionPerformed

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
            java.util.logging.Logger.getLogger(SimpleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JButton orders;
    private javax.swing.JButton products;
    private javax.swing.JButton rawMaterials;
    private javax.swing.JButton storage;
    private javax.swing.JButton suppliers;
    private javax.swing.JMenu visitOurWebsite;
    // End of variables declaration//GEN-END:variables
}
