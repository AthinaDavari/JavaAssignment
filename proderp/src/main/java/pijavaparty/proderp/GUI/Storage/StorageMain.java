package pijavaparty.proderp.GUI.Storage;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
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
    private int id;
    private String prodorraw;
    public StorageMain() {
        initComponents();
        showStorageTable();
        seticon();
    }
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        RawMaterial_table2 = new javax.swing.JTable();
        product_id = new javax.swing.JTextField();
        updateQuantity = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        RawMaterial_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Price", "Quantity", "Product or Raw"
            }
        ));
        RawMaterial_table2.setUpdateSelectionOnSort(false);
        RawMaterial_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RawMaterial_table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(RawMaterial_table2);

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
    public void showStorageTable(){
        //Mathod that is responsible for the appearance of the table with the contents of the database
        RawMaterialDao rawdao = new RawMaterialDao();
        ProductDao proddao = new ProductDao();
        DefaultTableModel model = (DefaultTableModel) RawMaterial_table2.getModel();
        int number = rawdao.getAll().size();
        Object[] row = new Object[5];
        for(int i = 0; i < number; i++){
                row[0] = rawdao.getAll().get(i).getId();
                row[1] = rawdao.getAll().get(i).getName();
                row[2] = rawdao.getAll().get(i).getPrice();
                row[3] = rawdao.getAll().get(i).getQuantity();
                row[4] = "Raw Material";
                model.addRow(row);
        }
        number = proddao.getAll().size();
        row = new Object[5];
        for(int i = 0; i<number; i++){
            row[0] = proddao.getAll().get(i).getId();
            row[1] = proddao.getAll().get(i).getName();
            row[2] = proddao.getAll().get(i).getPrice();
            row[3] = proddao.getAll().get(i).getQuantity();
            row[4] = "Product";
            model.addRow(row);
        }
        
    }
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        new StorageMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_refreshActionPerformed

    private void updateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateQuantityActionPerformed
        try {
           if (prodorraw.equals(""))
               throw new Exception();
           StorageUpdateQuantity storup = new StorageUpdateQuantity(id, prodorraw);
            storup.setVisible(true); 
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null,"Choose Product or Raw Material.","Error",  JOptionPane.ERROR_MESSAGE);
            StorageMain stor = new StorageMain();
            stor.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_updateQuantityActionPerformed

    private void RawMaterial_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RawMaterial_table2MouseClicked
        int selectedRow=RawMaterial_table2.getSelectedRow();
        DefaultTableModel model2 =(DefaultTableModel) RawMaterial_table2.getModel();
        product_id.setText((model2.getValueAt(selectedRow, 0).toString()) +" " + (model2.getValueAt(selectedRow, 1).toString()));
        String ids=model2.getValueAt(selectedRow, 0).toString();
        id=Integer.parseInt(ids);
        prodorraw=model2.getValueAt(selectedRow, 4).toString();
    }//GEN-LAST:event_RawMaterial_table2MouseClicked

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        LogIn login = new LogIn();
        login.setVisible(true);
        dispose();        
    }//GEN-LAST:event_logOutMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
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
    private javax.swing.JTable RawMaterial_table2;
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
