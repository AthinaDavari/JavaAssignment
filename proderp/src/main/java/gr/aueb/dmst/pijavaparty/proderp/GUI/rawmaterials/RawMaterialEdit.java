package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.SupplierDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidDouble;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author aggel
 */
public class RawMaterialEdit extends javax.swing.JFrame {

    /**
     *
     */
    public RawMaterialEdit() {
        initComponents();
        showRawMaterialTable();
        seticon();
        setTitle("Edit Raw Materials");
    }
    /**
     *Method that sets the icon that is shown on the frame when the program is running. 
     */
    private void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        RawMaterial_table2 = new javax.swing.JTable();
        value_id = new javax.swing.JTextField();
        value_name = new javax.swing.JTextField();
        value_supplier_id = new javax.swing.JTextField();
        value_price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_update = new javax.swing.JButton();
        valid_Name = new javax.swing.JLabel();
        valid_Price = new javax.swing.JLabel();
        valid_SupplierId = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

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
        RawMaterial_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RawMaterial_table2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(RawMaterial_table2);

        value_id.setEditable(false);

        value_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_nameKeyReleased(evt);
            }
        });

        value_supplier_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_supplier_idKeyReleased(evt);
            }
        });

        value_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_priceKeyReleased(evt);
            }
        });

        jLabel5.setText("Price:");

        jLabel3.setText("Supplier Id:");

        jLabel2.setText("Name:");

        jLabel1.setText("Raw Materal Id:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Edit Raw Material Data:");

        txt_update.setText("update");
        txt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateActionPerformed(evt);
            }
        });

        valid_Name.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Name.setForeground(new java.awt.Color(255, 0, 0));

        valid_Price.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Price.setForeground(new java.awt.Color(255, 0, 0));

        valid_SupplierId.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_SupplierId.setForeground(new java.awt.Color(255, 0, 0));

        cancel.setForeground(new java.awt.Color(51, 51, 255));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        jMenuBar1.add(cancel);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(txt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valid_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valid_Price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valid_SupplierId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(value_supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(valid_SupplierId, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(txt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Returning to the raw material main window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the cancel button.
     */     
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        RawMaterialMenu rawmenu = new RawMaterialMenu();
        rawmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked

    /**
     *
     * Select a row of the table and put the raw materials's data in the fields.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by putting the mouse cursor in a selected row of the table.
     */
    private void RawMaterial_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RawMaterial_table2MouseClicked

        int selectedRow = RawMaterial_table2.getSelectedRow();
        DefaultTableModel model2 = (DefaultTableModel) RawMaterial_table2.getModel();
        value_id.setText((model2.getValueAt(selectedRow, 0).toString()));
        value_name.setText((model2.getValueAt(selectedRow, 1).toString()));
        value_supplier_id.setText((model2.getValueAt(selectedRow, 2).toString()));
        //value_quantity.setText((model2.getValueAt(selectedRow, 3).toString()));
        value_price.setText((model2.getValueAt(selectedRow, 3).toString()));
    }//GEN-LAST:event_RawMaterial_table2MouseClicked

    /**
     * Update the details of a raw material.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the update button.
     */    
    private void txt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateActionPerformed
        try {
            if (ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText()) && isValidDouble(value_price.getText()) && isValidInteger(value_supplier_id.getText())) {
                String value1_id = value_id.getText();
                int newvalue1_id = Integer.parseInt(value1_id);
                String value2_name = value_name.getText();
                int value3_supplier_id = Integer.parseInt(value_supplier_id.getText());
                double value5_price = Double.parseDouble(value_price.getText());

                RawMaterialDao rawdao = new RawMaterialDao();
                SupplierDao sdao = new SupplierDao();
                RawMaterial rm = new RawMaterial(newvalue1_id, value2_name, value5_price, sdao.getById(value3_supplier_id));
                rawdao.update(rm);
                JOptionPane.showMessageDialog(null, "Updated");
                new RawMaterialEdit().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No details were inserted.", "Error", JOptionPane.ERROR_MESSAGE);
            RawMaterialEdit stor = new RawMaterialEdit();
            stor.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong details.", "Error", JOptionPane.ERROR_MESSAGE);
            RawMaterialEdit stor = new RawMaterialEdit();
            stor.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_txt_updateActionPerformed

    /**
     * Check if the name input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */    
    private void value_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_nameKeyReleased
        if (!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText())) {
            valid_Name.setText("Name is invalid!");
        } else {
            valid_Name.setText(null);
        }
    }//GEN-LAST:event_value_nameKeyReleased

    /**
     * Check if the price input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */    
    private void value_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_priceKeyReleased
        if (!isValidDouble(value_price.getText())) {
            valid_Price.setText("Price is invalid!");
        } else {
            valid_Price.setText(null);
        }
    }//GEN-LAST:event_value_priceKeyReleased

    /**
     * Check if the supplier input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */    
    private void value_supplier_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_supplier_idKeyReleased
        if (!isValidInteger(value_supplier_id.getText())) {
            valid_SupplierId.setText("Supplier Id is invalid!");
        } else {
            valid_SupplierId.setText(null);
        }
    }//GEN-LAST:event_value_supplier_idKeyReleased

    /**
     *Method that shows every raw material that the copmany has along with 
     *some information for each raw material. 
     */
    public void showRawMaterialTable() {
        RawMaterialDao obj = new RawMaterialDao();
        DefaultTableModel model = (DefaultTableModel) RawMaterial_table2.getModel();
        int number = obj.getAll().size();
        Object[] row = new Object[4];
        for (int i = 0; i < number; i++) {
            row[0] = obj.getAll().get(i).getId();
            row[1] = obj.getAll().get(i).getName();
            row[2] = obj.getAll().get(i).getSupplier().getId();
            row[3] = obj.getAll().get(i).getPrice();
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
            java.util.logging.Logger.getLogger(RawMaterialEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawMaterialEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawMaterialEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawMaterialEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RawMaterialEdit().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RawMaterial_table2;
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton txt_update;
    private javax.swing.JLabel valid_Name;
    private javax.swing.JLabel valid_Price;
    private javax.swing.JLabel valid_SupplierId;
    private javax.swing.JTextField value_id;
    private javax.swing.JTextField value_name;
    private javax.swing.JTextField value_price;
    private javax.swing.JTextField value_supplier_id;
    // End of variables declaration//GEN-END:variables
}
