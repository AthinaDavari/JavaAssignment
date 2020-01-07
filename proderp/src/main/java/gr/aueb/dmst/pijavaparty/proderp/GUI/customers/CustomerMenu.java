package gr.aueb.dmst.pijavaparty.proderp.GUI.customers;

import gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.GUI.SimpleMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.CustomerDao;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

/**
 * CustomerMenu.java -a gui class for choosing to update or add the date of a
 * customer.
 *
 * @author Stella
 */
public class CustomerMenu extends javax.swing.JFrame {

    /**
     * Creates new form CustomerMenu
     */
    public CustomerMenu() {
        initComponents();
        showCustomersTable();
        setTitle("Customer's Menu");
        seticon();
    }

    /**
     *Method that sets the icon that is shown on the frame when the program is running. 
     */
    private void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));

    }

    /**
     * Set CustomerMenu window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editCustomer = new javax.swing.JButton();
        insertCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Customers_table = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setResizable(false);

        editCustomer.setText("Update/Delete");
        editCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerActionPerformed(evt);
            }
        });

        insertCustomer.setText("Add");
        insertCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCustomerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("      Customer Menu");
        jLabel1.setMaximumSize(new java.awt.Dimension(147, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(147, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(147, 30));

        Customers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fullname", "Address", "Phonenumber", "Email"
            }
        ));
        Customers_table.setEnabled(false);
        jScrollPane1.setViewportView(Customers_table);

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        logOut.setText("Log Out");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(editCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(insertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Show the gui CustomerEdit window.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the update button.
     */
    private void editCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerActionPerformed
        new CustomerEdit().setVisible(true);
    }//GEN-LAST:event_editCustomerActionPerformed
    /**
     * Show the gui InsertCustomer window.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the add button.
     */
    private void insertCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCustomerActionPerformed
        new InsertCustomer().setVisible(true);
    }//GEN-LAST:event_insertCustomerActionPerformed
    
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        LogIn login = new LogIn();
        LogIn.setUser(null);
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        if ((LogIn.getUser().getRole()).equals("admin")) {
            AdminMenu menu = new AdminMenu();
            menu.setVisible(true);
        } else {
            SimpleMenu menu = new SimpleMenu();
            menu.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_backMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        DefaultTableModel model = (DefaultTableModel)Customers_table.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        showCustomersTable();
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMenu().setVisible(true);
            }
        });
    }

    /**
     * Show customer's data in a table.
     *
     */
    private void showCustomersTable() {
        CustomerDao obj = new CustomerDao();
        DefaultTableModel model = (DefaultTableModel) Customers_table.getModel();
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Customers_table;
    private javax.swing.JMenu back;
    private javax.swing.JButton editCustomer;
    private javax.swing.JButton insertCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logOut;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables

   
}
