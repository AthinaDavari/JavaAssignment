package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.dao.CustomerDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.Customer;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * AddNewCustOrder.java - A graphical user interface (gui) class responsible for
 * adding a new order from a customer - Select the customer's id and name and
 * then shows the graphical user interface (gui) of AddProductToCOrder class.
 *
 * @author MariaKokkorou
 */
public class AddNewCustOrder extends javax.swing.JFrame {

    static COrder corder;
    static int customerId;

    /**
     * Creates new form AddNewCustOrder
     */
    public AddNewCustOrder() {
        initComponents();
        seticon();
        comboBox();
    }

    /**
     * Set the icon that is shown on the frame.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set AddNewCustOrder window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNewOrderFromCustomer = new javax.swing.JLabel();
        customerIDAndName = new javax.swing.JLabel();
        custid = new javax.swing.JComboBox<>();
        addNewProduct = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        addNewOrderFromCustomer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addNewOrderFromCustomer.setText("Add New Order From Customer");

        customerIDAndName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerIDAndName.setText("Customer ID - Name:");

        custid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        addNewProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addNewProduct.setText("Add New Product To Order");
        addNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductActionPerformed(evt);
            }
        });

        cancel.setForeground(new java.awt.Color(0, 0, 204));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerIDAndName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(custid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addNewOrderFromCustomer)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNewOrderFromCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDAndName, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custid, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(addNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Select the customer's id and name to whom the order is added, and then
     * shows the graphical user interface (gui) of AddItemSOrder class.
     *
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on Add New Product To Order button.
     */
    private void addNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductActionPerformed

        try {

            String customerAsString = custid.getSelectedItem().toString();
            // Get the selected customer id and name.
            createCOrder(customerAsString);
            // Create a COrder object, which represents the order from the specific 
            // customer with the selected id and name. 

            new AddProductToCOrder().setVisible(true);
            // Shows the graphical user interface (gui) of AddProductToCOrder class.
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_addNewProductActionPerformed

    /**
     * Close the Add New Cust Order window by clicking on cancel button on the
     * menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is sent to the
     * method by clicking on the cancel button on the menu bar.
     */

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new OrdersFromCustomers().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Fill the "custid" combobox with the ids and the names of all the
     * customers that exist in the database.
     *
     */
    private void comboBox() {

        CustomerDao cd = new CustomerDao();
        List<Customer> customers = new ArrayList();
        // customers - an array list with all the available customers that
        // exist in the database.
        customers = cd.getAll();
        int number = cd.getAll().size(); // the number of all the available 
        // customers that exist in the database.

        try {

            for (int i = 0; i < number; i++) {

                custid.addItem(customers.get(i).getId() + "-" + customers.get(i).getFullName());
                // add in the combo box the id - name of all the customers.

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * Creates a COrder object that represents an order to the
     * customer with this specific id.
     *
     * @param customer - a string with the selected id and name of the customer
     * from the combo box (form of string: id-name).
     */
    private void createCOrder(String customer) {

        CustomerDao cd = new CustomerDao();
        String[] customerTable = customer.split("-");
        // split the customer string in two parts, where the "-" symbol exists
        // and store the two parts in a table.
        customerId = Integer.parseInt(customerTable[0]);
        // the customer's id is stored in position 0 of the table.

        corder = new COrder(cd.getById(customerId), LogIn.getUser());
        // creates a COrder object that represents an order to the customer 
        // with this specific id
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
            java.util.logging.Logger.getLogger(AddNewCustOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewCustOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewCustOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewCustOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewCustOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addNewOrderFromCustomer;
    private javax.swing.JButton addNewProduct;
    private javax.swing.JMenu cancel;
    private javax.swing.JComboBox<String> custid;
    private javax.swing.JLabel customerIDAndName;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
