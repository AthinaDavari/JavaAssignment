package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.dao.COrderDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrder;
import gr.aueb.dmst.pijavaparty.proderp.services.StorageServices;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * EditCOrders.java - A graphical user interface (gui) class for modifying the
 * status of an order from customers and delete an order to customers.
 *
 * @author MariaKokkorou
 */
public class EditCOrders extends javax.swing.JFrame {

    private javax.swing.JScrollPane jScrollPane1;

    /**
     * Creates new form EditOrders
     */
    public EditCOrders() {
        initComponents();
        showCOrdersTable();
        seticon();
        setTitle("Edit Customer Order");
    }

    /**
     * Set the icon that is shown on the frame.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Initialize the form of the window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        COrdersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        orderid = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        stat = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Orders");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Edit Orders");

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update Status");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        COrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order's ID", "Customer ID - Name", "Status", "Created At", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        COrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                COrdersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(COrdersTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Order's ID");

        orderid.setEditable(false);
        orderid.setBackground(new java.awt.Color(204, 204, 204));
        orderid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderid.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Update to");

        stat.setEditable(false);
        stat.setBackground(new java.awt.Color(204, 204, 204));
        stat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Update the status of an order in the database 
     * and update the quantities of the available raw materials and
     * products in the database.
     *
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on Update Status button.
     */
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            String orderIdString = orderid.getText();
            int orderIdInt = Integer.parseInt(orderIdString);
            // Get the value from Order's ID field.
            String status = stat.getText();
            // Get the value from status field.
            StorageServices storageservices = new StorageServices();
            if (status.equals("ready")) { // check if the order's status is "ready".
                if (!(storageservices.permissionToDecreaseRawMaterials(orderIdInt))) {
                    //if raw materials can be not decreased by this quantity stop the process
                    JOptionPane.showMessageDialog(null, "Not enough raw materials for this order.");
                    return;
                }
                storageservices.decreaseRawQuantitiesForProducts(orderIdInt);
                // If the order is "ready", update in the database the quantities
                // of the raw materials that were used to produse this product.
                storageservices.increaseProduct(orderIdInt);
                // Also, if the order is "ready", increase in the database the 
                // number of the products that are available for the customers.
            }
            if (status.equals("delivered")) { // check if the order's status is "delivered".
                if (!(storageservices.permissionToDecreaseProduct(orderIdInt))) {
                    //if products can be not decreased by this quantity stop the process
                    JOptionPane.showMessageDialog(null, "Not enough products in the storage.");
                    return;
                }
                storageservices.decreaseProduct(orderIdInt);
                // Decrease in the database the number of products that are available for customers.
            }
            COrderDao cod = new COrderDao();
            cod.updateStatus(orderIdInt, (status));
            JOptionPane.showMessageDialog(null, "Status Updated.");
            new EditCOrders().setVisible(true);
            dispose();
    }//GEN-LAST:event_updateActionPerformed

    /**
     * Select a row of the table by clicking on it, and insert the order's ID in
     * the Order's ID field and the order's status in the status field.
     *
     * @param evt - a reference to a MouseEvent object that is sent to the
     * method by putting the mouse's cursor over a selected row of the table.
     */
    private void COrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COrdersTableMouseClicked

        int selectedRow = COrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();
        orderid.setText((model.getValueAt(selectedRow, 0).toString()));
        stat.setText(((model.getValueAt(selectedRow, 2).toString().equals("ready"))) ? "delivered" : "ready");

    }//GEN-LAST:event_COrdersTableMouseClicked

    /**
     * Delete permanently an order from customer from the database.
     *
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on Delete button.
     */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        String orderIDString = orderid.getText();
        int orderIDint = Integer.parseInt(orderIDString);

        try {

            COrderDao cod = new COrderDao();
            cod.delete(orderIDint);
            JOptionPane.showMessageDialog(null, "Order Deleted.");
            new EditCOrders().setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * Close the Edit Orders to Suppliers window by clicking on cancel button on
     * the menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is sent to
     * the method by clicking on cancel button on the menu bar.
     */
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        OrdersFromCustomers a = new OrdersFromCustomers();
        a.setVisible(true);
        dispose();

    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Get order's id, customer's id and name, status and order's time of
     * creation data from database and show them in showCOrdersTable table.
     *
     */
    public void showCOrdersTable() {
        try {

            COrderDao cod = new COrderDao();
            List<COrder> corders = cod.getAllExceptFromDelivered();
            // corders - an arraylist filled only with all the orders from customers
            // that are not delivered yet. Orders with status different than "delivered".
            int number = corders.size(); // the number of orders from customers that are not delivered yet.
            DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();

            Object[] row = new Object[5];

            //Fill the table.
            for (int i = 0; i < number; i++) {
                row[0] = corders.get(i).getId(); // Fill the first column of the table with the id of the order.
                row[1] = corders.get(i).getCustomer().getId() + "-" + corders.get(i).getCustomer().getFullName();
                // Fill the second column of the table with the id - name of the customer.
                row[2] = corders.get(i).getStatus(); // Fill the third column of the table with the status of the order.
                row[3] = corders.get(i).getCreated_at(); // Fill the fourth column 
                // of the table with the time of creation of the order.
                row[4] = corders.get(i).getUser().getFullName();
                // Fill the fifth column of the table with the username.
                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            java.util.logging.Logger.getLogger(EditCOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable COrdersTable;
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    protected static javax.swing.JTextField orderid;
    private javax.swing.JTextField stat;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
