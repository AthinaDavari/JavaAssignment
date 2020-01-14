package gr.aueb.dmst.pijavaparty.proderp.GUI.storage;

import gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.GUI.SimpleMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.customers.CustomerMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * StorageMain.java - A graphical user interface (gui) class responsible for 
 * showing the quantities of the products and the raw materials.
 * @author aggel
 */
public class StorageMain extends javax.swing.JFrame {
    private int id;
    private String prodorraw;

    /**
     *
     */
    public StorageMain() {
        initComponents();
        showStorageTable();
        seticon();
        setTitle("Storage");
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    private void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    
    /**
     * Set StorageMain window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        Storage_Table = new javax.swing.JTable();
        product_id = new javax.swing.JTextField();
        updateQuantity = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Storage_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Price", "Quantity", "Product or Raw"
            }
        ));
        Storage_Table.setUpdateSelectionOnSort(false);
        Storage_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Storage_TableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Storage_Table);

        product_id.setEditable(false);
        product_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_idActionPerformed(evt);
            }
        });

        updateQuantity.setText("Update Quantity");
        updateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateQuantityActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Storage");

        logOut.setForeground(new java.awt.Color(51, 51, 255));
        logOut.setText("Log Out");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);

        back.setForeground(new java.awt.Color(51, 51, 255));
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jMenuBar1.add(back);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(updateQuantity)
                .addGap(253, 253, 253))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Method that shows everything that exist in the storage along with the 
     *quantities and some information for each product or raw material. 
     */
    public void showStorageTable(){
        RawMaterialDao rawdao = new RawMaterialDao();
        ProductDao proddao = new ProductDao();
        DefaultTableModel model = (DefaultTableModel) Storage_Table.getModel();
        int number = rawdao.getAll().size();
        Object[] row = new Object[5];
        for(int i = 0; i < number; i++){
                row[0] = rawdao.getAll().get(i).getId();
                row[1] = rawdao.getAll().get(i).getName();
                row[2] = rawdao.getAll().get(i).getPrice();
                row[3] = rawdao.getAll().get(i).getQuantity();
                row[4] = "Raw Material";
                model.addRow(row);
        } // First all the raw materials are shown.
        number = proddao.getAll().size();
        row = new Object[5];
        for(int i = 0; i<number; i++){
            row[0] = proddao.getAll().get(i).getId();
            row[1] = proddao.getAll().get(i).getName();
            row[2] = proddao.getAll().get(i).getPrice();
            row[3] = proddao.getAll().get(i).getQuantity();
            row[4] = "Product";
            model.addRow(row);
        } // Lastly all the products are shown in the table.
        
    }
    
    /**
    * Refresh button so that when something is changed, you can see if its also 
    * successfully changed in the data base.
    *
    * @param evt is a reference to an ActionEvent object that is sent to the
    * method by clicking the refresh quantity button.
    */
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        setVisible(false);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomerMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
        DefaultTableModel model = (DefaultTableModel)Storage_Table.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        showStorageTable();
    }//GEN-LAST:event_refreshActionPerformed

    /**
     * Method that pops another window which is used for updating quantities
     * of products or raw materials.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the update quantity button.
     */
    private void updateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityActionPerformed
        try {
           if (prodorraw.equals(""))
               throw new Exception();
           StorageUpdateQuantity storup = new StorageUpdateQuantity(id, prodorraw);
           storup.setVisible(true); 
           dispose();
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null,"Choose Product or Raw Material.","Error",  JOptionPane.ERROR_MESSAGE);
            StorageMain stor = new StorageMain();
            stor.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_updateQuantityActionPerformed

    /**
     *
     * Select a row of the table and put the product's or raw materials's data in the fields.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by putting the mouse cursor in a selected row of the table.
     */
    private void Storage_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Storage_TableMouseClicked
        int selectedRow=Storage_Table.getSelectedRow();
        DefaultTableModel model2 =(DefaultTableModel) Storage_Table.getModel();
        product_id.setText((model2.getValueAt(selectedRow, 0).toString()) +" " + (model2.getValueAt(selectedRow, 1).toString()));
        String ids=model2.getValueAt(selectedRow, 0).toString();
        id=Integer.parseInt(ids);
        prodorraw=model2.getValueAt(selectedRow, 4).toString();
    }//GEN-LAST:event_Storage_TableMouseClicked

    /**
     *
     * Loging out of the user that you are currently loged in in.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the log out button.
     */
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        LogIn login = new LogIn();
        LogIn.setUser(null);
        login.setVisible(true);
        dispose();       
    }//GEN-LAST:event_logOutMouseClicked

    /**
     *
     * Returning to the main menu window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the back button.
     */
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        if((LogIn.getUser().getRole()).equals("admin")){
            AdminMenu menu = new AdminMenu();
            menu.setVisible(true);
        } else {
            SimpleMenu menu = new SimpleMenu();
            menu.setVisible(true);
        }
        dispose();       
    }//GEN-LAST:event_backMouseClicked

    private void product_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_idActionPerformed

    }//GEN-LAST:event_product_idActionPerformed

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
            java.util.logging.Logger.getLogger(StorageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StorageMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Storage_Table;
    private javax.swing.JMenu back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu logOut;
    private javax.swing.JTextField product_id;
    private javax.swing.JButton refresh;
    private javax.swing.JButton updateQuantity;
    // End of variables declaration//GEN-END:variables
}
