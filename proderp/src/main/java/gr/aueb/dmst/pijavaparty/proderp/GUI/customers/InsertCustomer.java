package gr.aueb.dmst.pijavaparty.proderp.GUI.customers;

import gr.aueb.dmst.pijavaparty.proderp.dao.CustomerDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Customer;
import gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * InsertCustomer.java -a gui class for adding the data of a customer.
 *
 * @author Stella
 */
public class InsertCustomer extends javax.swing.JFrame {

    /**
     * Creates new form InsertCustomer
     */
    public InsertCustomer() {
        initComponents();
        seticon();
        setTitle("Insert Customer");
    }

    /**
     *Method that sets the icon that is shown on the frame when the program is running. 
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set InsertCustomer window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        value_FullName = new javax.swing.JTextField();
        value_Address = new javax.swing.JTextField();
        value_Email = new javax.swing.JTextField();
        value_Phonenumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        valid_Fullname = new javax.swing.JLabel();
        valid_Phonenumber = new javax.swing.JLabel();
        valid_Email = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insert New Customer");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fullname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Phonenumber");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        value_FullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_FullNameKeyReleased(evt);
            }
        });

        value_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_EmailKeyReleased(evt);
            }
        });

        value_Phonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_PhonenumberKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setText("   Insert New Customer");

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        valid_Fullname.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Fullname.setForeground(new java.awt.Color(255, 0, 0));

        valid_Phonenumber.setForeground(new java.awt.Color(255, 0, 0));

        valid_Email.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
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
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(value_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valid_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(value_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(value_FullName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(value_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(valid_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valid_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valid_Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(value_FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(value_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(value_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(valid_Phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(valid_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(value_Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Add valid data of a customer in the database.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the save button.
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {

            if (ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_FullName.getText()) && ValidVariables.isValidPhonenumber(value_Phonenumber.getText()) && ValidVariables.isValidEmailAddress(value_Email.getText())) {
                String value2_full_name = value_FullName.getText();
                String value3_address = value_Address.getText();
                String value4_phonenumber = value_Phonenumber.getText();
                long newvalue4_phonenumber = Long.parseLong(value4_phonenumber);
                String value5_email = value_Email.getText();

                Customer ant = new Customer(value2_full_name, value3_address, newvalue4_phonenumber, value5_email);
                CustomerDao ant2 = new CustomerDao();
                ant2.insert(ant);

                JOptionPane.showMessageDialog(null, "Saved");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }

        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
        }

    }//GEN-LAST:event_saveActionPerformed
    /**
     * Check if the name input is valid and if it is invalid show a warning
     * message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to the method
     * by typing a key in the keyboard.
     */
    private void value_FullNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_FullNameKeyReleased

        if (!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_FullName.getText())) {
            valid_Fullname.setText("Name is invalid!");
        } else {
            valid_Fullname.setText(null);
        }
    }//GEN-LAST:event_value_FullNameKeyReleased
    /**
     * Check if the phonenumber input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt @param evt is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */
    private void value_PhonenumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_PhonenumberKeyReleased
        if (!ValidVariables.isValidPhonenumber(value_Phonenumber.getText())) {
            valid_Phonenumber.setText("Phonenumber is invalid!");
        } else {
            valid_Phonenumber.setText(null);
        }
    }//GEN-LAST:event_value_PhonenumberKeyReleased
    /**
     * Check if the email input is valid and if it is invalid show a warning
     * message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to the method
     * by typing a key in the keyboard.
     */
    private void value_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_EmailKeyReleased
        if (!ValidVariables.isValidEmailAddress(value_Email.getText())) {
            valid_Email.setText("Email is invalid!");
        } else {
            valid_Email.setText(null);
        }
    }//GEN-LAST:event_value_EmailKeyReleased
   
    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
 
        dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        dispose();
    }//GEN-LAST:event_cancelMouseClicked
   
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
            java.util.logging.Logger.getLogger(InsertCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton save;
    private javax.swing.JLabel valid_Email;
    private javax.swing.JLabel valid_Fullname;
    private javax.swing.JLabel valid_Phonenumber;
    private javax.swing.JTextField value_Address;
    private javax.swing.JTextField value_Email;
    private javax.swing.JTextField value_FullName;
    private javax.swing.JTextField value_Phonenumber;
    // End of variables declaration//GEN-END:variables
}
