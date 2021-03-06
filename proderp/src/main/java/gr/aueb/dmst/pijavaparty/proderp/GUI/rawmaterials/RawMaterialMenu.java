
package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.GUI.SimpleMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.customers.CustomerMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * RawMaterialMenu.java - A graphical user interface (gui) class responsible for 
 * showing all information of the raw materials.
 * @author aggel
 */
public class RawMaterialMenu extends javax.swing.JFrame {

    /**
     * Creates new form RawMaterialMenu
     */
    public RawMaterialMenu() {
        initComponents();
        showRawMaterialTable();
        seticon();
        setTitle("Raw Material's Menu");
    }
    
    /**
     * Set the icon that is shown on the frame. 
     */
    private void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set EawMaterialMenu window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        RawMaterial_table2 = new javax.swing.JTable();
        editRawMaterial = new javax.swing.JButton();
        addRawMaterial = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        RawMaterial_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Supplier_id", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RawMaterial_table2.setUpdateSelectionOnSort(false);
        jScrollPane3.setViewportView(RawMaterial_table2);

        editRawMaterial.setText("Update");
        editRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRawMaterialActionPerformed(evt);
            }
        });

        addRawMaterial.setText("Add");
        addRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRawMaterialActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Raw Materials");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(298, 298, 298)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(editRawMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(addRawMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editRawMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(addRawMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    /**
     *
     * Responsible for the continuing of the execution in the edit raw material
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the update button.
     */    
    private void editRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRawMaterialActionPerformed
        new RawMaterialEdit().setVisible(true);
        dispose();
    }//GEN-LAST:event_editRawMaterialActionPerformed
    
    /**
     *
     * Responsible for the continuing of the execution in the insert raw material
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the add button.
     */
    private void addRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRawMaterialActionPerformed
        new RawMaterialInsert().setVisible(true);
        dispose();
    }//GEN-LAST:event_addRawMaterialActionPerformed
    
    /**
     *
     * Responsible for the continuing of the execution in the delete raw material
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the delete button.
     */    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        new RawMaterialDelete().setVisible(true);
        dispose();
    }//GEN-LAST:event_deleteActionPerformed

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
        DefaultTableModel model = (DefaultTableModel)RawMaterial_table2.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        showRawMaterialTable();
    }//GEN-LAST:event_refreshActionPerformed

    /**
     *Method that shows every raw material that the copmany has along with 
     *some information for each raw material. 
     */
    public void showRawMaterialTable(){
        RawMaterialDao rawdao=new RawMaterialDao();
        DefaultTableModel model=(DefaultTableModel) RawMaterial_table2.getModel();
        int number=rawdao.getAll().size();
        Object[] row=new Object[4];
        for(int i=0; i<number; i++){
                row[0]=rawdao.getAll().get(i).getId();
                row[1]=rawdao.getAll().get(i).getName();
                row[2]=rawdao.getAll().get(i).getSupplier().getFullName() + " " + rawdao.getAll().get(i).getSupplier().getId();
                row[3]=rawdao.getAll().get(i).getPrice();
                model.addRow(row);
        }
        
    }
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
            java.util.logging.Logger.getLogger(RawMaterialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawMaterialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawMaterialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawMaterialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RawMaterialMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RawMaterial_table2;
    private javax.swing.JButton addRawMaterial;
    private javax.swing.JMenu back;
    private javax.swing.JButton delete;
    private javax.swing.JButton editRawMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenu logOut;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
