/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.GUI.Storage;

import javax.swing.table.DefaultTableModel;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.GUI.LogIn;
import pijavaparty.proderp.GUI.Menu;

/**
 *
 * @author aggel
 */
public class StorageMain extends javax.swing.JFrame {

    /**
     * Creates new form StorageMain
     */
    public StorageMain() {
        initComponents();
        showStorageTable();
        LogIn login = new LogIn();
        login.seticon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        editCustomer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        RawMaterial_table2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editCustomer.setText("Update Quantity");
        editCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        RawMaterial_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Price", "Quantity"
            }
        ));
        RawMaterial_table2.setUpdateSelectionOnSort(false);
        RawMaterial_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RawMaterial_table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(RawMaterial_table2);

        jMenu2.setForeground(new java.awt.Color(51, 51, 255));
        jMenu2.setText("Log Out");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu5.setForeground(new java.awt.Color(51, 51, 255));
        jMenu5.setText("Back");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showStorageTable(){
        RawMaterialDao obj=new RawMaterialDao();
        ProductDao obj1=new ProductDao();
        DefaultTableModel model=(DefaultTableModel) RawMaterial_table2.getModel();
        int number=obj.getAll().size();
        Object[] row=new Object[4];
        for(int i=0; i<number; i++){
                row[0]=obj.getAll().get(i).getId();
                row[1]=obj.getAll().get(i).getName();
                row[2]=obj.getAll().get(i).getPrice();
                row[3]=obj.getAll().get(i).getQuantity();
                model.addRow(row);
        }
        number=obj1.getAll().size();
        row=new Object[4];
        for(int i=0; i<number; i++){
            row[0]=obj1.getAll().get(i).getId();
            row[1]=obj1.getAll().get(i).getName();
            row[2]=obj1.getAll().get(i).getPrice();
            row[3]=obj1.getAll().get(i).getQuantity();
            model.addRow(row);
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new StorageMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerActionPerformed
        StorageUpdateQuantity obj = new StorageUpdateQuantity();
        obj.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_editCustomerActionPerformed

    private void RawMaterial_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RawMaterial_table2MouseClicked

    }//GEN-LAST:event_RawMaterial_table2MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        LogIn obj = new LogIn();
        obj.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        Menu obj = new Menu();
        obj.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5MouseClicked

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StorageMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RawMaterial_table2;
    private javax.swing.JButton editCustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
