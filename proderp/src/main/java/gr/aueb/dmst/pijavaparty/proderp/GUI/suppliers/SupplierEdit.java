package gr.aueb.dmst.pijavaparty.proderp.GUI.suppliers;

import gr.aueb.dmst.pijavaparty.proderp.dao.SupplierDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *SupplierEdit.java -a gui class for modifying the data of a supplier.
 * 
 * @author Stella
 */
public class SupplierEdit extends javax.swing.JFrame {

    /**
     * Creates new form SupplierEdit
     */
    public SupplierEdit() {
        initComponents();
        showSuppliersTable();
        seticon();
        setTitle("Edit Supplier");
    }

    /**
     * Set the icon that is shown on the frame.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set SupplierEdit window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        value_id = new javax.swing.JTextField();
        value_full_name = new javax.swing.JTextField();
        value_address = new javax.swing.JTextField();
        value_phonenumber = new javax.swing.JTextField();
        value_email = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Suppliers_table = new javax.swing.JTable();
        valid_Fullname = new javax.swing.JLabel();
        valid_Phonenumber = new javax.swing.JLabel();
        valid_Email = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Supplier Data");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edit Supplier Data");

        jLabel2.setText("Supplier Id:");

        jLabel3.setText("Fullname:");

        jLabel4.setText("Address:");

        jLabel5.setText("Phonenumber:");

        jLabel6.setText("Email:");

        value_id.setEnabled(false);

        value_full_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_full_nameKeyReleased(evt);
            }
        });

        value_phonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_phonenumberKeyReleased(evt);
            }
        });

        value_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_emailKeyReleased(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        Suppliers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Id", "Fullname", "Address", "Phonenumber", "Email"
            }
        ));
        Suppliers_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Suppliers_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Suppliers_table);

        valid_Fullname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Fullname.setForeground(new java.awt.Color(255, 0, 0));

        valid_Phonenumber.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Phonenumber.setForeground(new java.awt.Color(255, 0, 0));

        valid_Email.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Email.setForeground(new java.awt.Color(255, 0, 0));

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
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(value_email, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(value_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(value_address, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(value_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valid_Phonenumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valid_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(valid_Fullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(value_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(value_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(value_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valid_Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(value_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     *  Check if the name input is valid and if it is invalid show a warning message.
     * 
     * @param evt is a reference to a KeyEvent object that is sent to the method 
     * by typing a key in the keyboard.
     */
    private void value_full_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_full_nameKeyReleased
        if (!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_full_name.getText())) {
            valid_Fullname.setText("Name is invalid!");
        } else {
            valid_Fullname.setText(null);
        }
    }//GEN-LAST:event_value_full_nameKeyReleased
    /**
     * Check if the phonenumber input is valid and if it is invalid show a warning message.
     * 
     * @param evt @param evt is a reference to a KeyEvent object that is sent to the method
     * by typing a key in the keyboard.
     */
    private void value_phonenumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_phonenumberKeyReleased
        if (!ValidVariables.isValidPhonenumber(value_phonenumber.getText())) {
            valid_Phonenumber.setText("Phonenumber is invalid!");
        } else {
            valid_Phonenumber.setText(null);
        }
    }//GEN-LAST:event_value_phonenumberKeyReleased
    /**
     * Check if the email input is valid and if it is invalid show a warning message.
     * 
     * @param evt is a reference to a KeyEvent object that is sent to the method 
     * by typing a key in the keyboard.
     */
    private void value_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_emailKeyReleased
        if (!ValidVariables.isValidEmailAddress(value_email.getText())) {
            valid_Email.setText("Email is invalid!");
        } else {
            valid_Email.setText(null);
        }
    }//GEN-LAST:event_value_emailKeyReleased
    /**
    * Add valid and edited data of a supplier in the database.
    * 
    * @param evt is a reference to an ActionEvent object that is sent to the method 
    * by clicking the update button. 
    */
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            if (ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_full_name.getText()) && ValidVariables.isValidPhonenumber(value_phonenumber.getText()) && ValidVariables.isValidEmailAddress(value_email.getText())) {
                String value1_id = value_id.getText();
                int newvalue1_id = Integer.parseInt(value1_id);
                String value2_full_name = value_full_name.getText();
                String value3_address = value_address.getText();
                String value4_phonenumber = value_phonenumber.getText();
                long newvalue4_phonenumber = Long.parseLong(value4_phonenumber);
                String value5_email = value_email.getText();
                Supplier objc = new Supplier(newvalue1_id, value2_full_name, value3_address, newvalue4_phonenumber, value5_email);
                SupplierDao obj = new SupplierDao();
                obj.update(objc);
                JOptionPane.showMessageDialog(null, "Updated");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }
    }//GEN-LAST:event_updateActionPerformed
    
    /**
     * Delete the data of supplier in the database.
     * 
     * @param evt is a reference to an ActionEvent object that is sent to the method
     * by clicking the delete button. 
     */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
            String value1_id = value_id.getText();
            int newvalue1_id = Integer.parseInt(value1_id);
            SupplierDao customerDao = new SupplierDao();
            customerDao.delete(newvalue1_id);
            JOptionPane.showMessageDialog(null, "Deleted");
            new SupplierEdit().setVisible(true);
            dispose();
    }//GEN-LAST:event_deleteActionPerformed
     /**
      * 
      * Select a row of the table and put the supplier's data in the fields.
      * 
      * @param evt is a reference to a MouseEvent object that is sent to the method 
      * by putting the mouse cursor in a selected row of the table. 
      */
    private void Suppliers_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Suppliers_tableMouseClicked
        int selectedRow = Suppliers_table.getSelectedRow();
        DefaultTableModel model2 = (DefaultTableModel) Suppliers_table.getModel();
        value_id.setText((model2.getValueAt(selectedRow, 0).toString()));
        value_full_name.setText((model2.getValueAt(selectedRow, 1).toString()));
        value_address.setText((model2.getValueAt(selectedRow, 2).toString()));
        value_phonenumber.setText((model2.getValueAt(selectedRow, 3).toString()));
        value_email.setText((model2.getValueAt(selectedRow, 4).toString()));
    }//GEN-LAST:event_Suppliers_tableMouseClicked
    /**
     * Close the SupplierEdit to SuppliersMenu window by clicking on cancel button on
     * the menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is sent to
     * the method by clicking on cancel button on the menu bar.
     */
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        dispose();
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Show supplier's data in a table  
     * 
     */
    public void showSuppliersTable() {
        SupplierDao obj = new SupplierDao();
        DefaultTableModel model = (DefaultTableModel) Suppliers_table.getModel();
        int number = obj.getAll().size();
        Object[] row = new Object[5];
        for (int i = 0; i < number; i++) {
            row[0] = obj.getAll().get(i).getId();
            row[1] = obj.getAll().get(i).getFullName();
            row[2] = obj.getAll().get(i).getAddress();
            row[3] = obj.getAll().get(i).getPhonenumber();
            row[4] = obj.getAll().get(i).getEmail();
            model.addRow(row);
        }
    }

    /**
     *
     * @param args command line arguements
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
            java.util.logging.Logger.getLogger(SupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Suppliers_table;
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    private javax.swing.JLabel valid_Email;
    private javax.swing.JLabel valid_Fullname;
    private javax.swing.JLabel valid_Phonenumber;
    private javax.swing.JTextField value_address;
    private javax.swing.JTextField value_email;
    private javax.swing.JTextField value_full_name;
    private javax.swing.JTextField value_id;
    private javax.swing.JTextField value_phonenumber;
    // End of variables declaration//GEN-END:variables
}
