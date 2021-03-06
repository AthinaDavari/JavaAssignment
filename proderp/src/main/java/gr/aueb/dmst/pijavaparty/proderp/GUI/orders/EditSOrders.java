package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.dao.SOrderDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.SOrderItemDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * EditSOrders.java - A graphical user interface (gui) class for modifying 
 * the status of an order to suppliers and delete an order to suppliers.
 * 
 * @author MariaKokkorou
 */
public class EditSOrders extends javax.swing.JFrame {

    /**
     * Creates new form EditOrders
     */   
    public EditSOrders() {
        initComponents();
        showSOrdersTable();
        seticon();
        setTitle("Edit Supplier Order");
    }

    /**
     *Set the icon that is shown on the frame.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/logo.jpg")));
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
        SOrdersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        cancelMenu = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Orders");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Edit Orders");

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update To Delivered");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        SOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order's ID", "Supplier ID - Name", "Status", "Created At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SOrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SOrdersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SOrdersTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Order's ID");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        cancel.setForeground(new java.awt.Color(0, 0, 255));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancelMenu.add(cancel);

        setJMenuBar(cancelMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Update the status of an order in the database and increase the quantity 
    * of raw materials by the quantity of a delivered SOrder.
    * 
    * @param evt - a reference to an ActionEvent object that is sent 
    * to the method by clicking on Update To Delivered button.
    */    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            String orderIDString = jTextField1.getText();
            int orderIDint = Integer.parseInt(orderIDString);

            SOrderDao sd = new SOrderDao();
            sd.updateStatus(orderIDint, "delivered");
            SOrderItemDao orderItemDao = new SOrderItemDao();
            orderItemDao.increaseQuantities(orderIDint); 
            // When an order to a supplier is delivered, increase the quantity 
            // of raw materials by the quantity of a delivered SOrder
            
            JOptionPane.showMessageDialog(null, "Status Updated.");
            
            new EditSOrders().setVisible(true);
            dispose();
    }//GEN-LAST:event_updateActionPerformed

    /**
      * Select a row of the table by clicking on it, and insert the order's ID 
      * in the Order's ID field.
      * 
      * @param evt - a reference to a MouseEvent object that is sent to 
      * the method by putting the mouse's cursor over a selected row of the table. 
      */
    private void SOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOrdersTableMouseClicked

        int selectedRow = SOrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) SOrdersTable.getModel();
        jTextField1.setText((model.getValueAt(selectedRow, 0).toString()));
        
    }//GEN-LAST:event_SOrdersTableMouseClicked


    /**
     * Delete permanently an order to supplier from the database.
     * 
     * @param evt - a reference to an ActionEvent object that is sent 
     * to the method by clicking on Delete button.
     */  
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        String orderIDString = jTextField1.getText();
        int orderIDint = Integer.parseInt(orderIDString);
        
        try {
            
            SOrderDao sod = new SOrderDao();
            sod.delete(orderIDint);
            JOptionPane.showMessageDialog(null,"Order Deleted");
            new EditSOrders().setVisible(true);
            dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * Close the Edit Orders to Suppliers window by clicking on cancel 
     * button on the menu bar.
     * 
     * @param evt - a reference to a MouseEvent object that is sent 
     * to the method by clicking on cancel button on the menu bar.
     */    
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new OrdersFromSuppliers().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked


    /** 
     * Get id, supplier id and name, status and order's time of creation data 
     * from database and show them in showSOrdersTable table.
     * 
     */
    public void showSOrdersTable() {
        try {
            
            SOrderDao obj2 = new SOrderDao();
            List<SOrder> sorders = obj2.getAllPendingOrders();
            // sorders - an arraylist filled with all the orders to suppliers that are currently pending, not delivered.
            int number1 = sorders.size(); // the number of orders to suppliers with status "pending".
            DefaultTableModel model2 = (DefaultTableModel) SOrdersTable.getModel();

            Object[] row = new Object[4];

            for (int i = 0; i < number1; i++) {
                row[0] = sorders.get(i).getId(); // Fill the first column of the table with the id of the order.
                row[1] = sorders.get(i).getSupplier().getId() + "-" + sorders.get(i).getSupplier().getFullName();
                // Fill the second column of the table with the id - name of the supplier.
                
                row[2] = sorders.get(i).getStatus(); // Fill the third column of the table with the status of the order.
                row[3] = sorders.get(i).getCreated_at(); // Fill the fourth column of the table with the time of creation of the order.

                model2.addRow(row);
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
            java.util.logging.Logger.getLogger(EditSOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SOrdersTable;
    private javax.swing.JMenu cancel;
    private javax.swing.JMenuBar cancelMenu;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    protected static javax.swing.JTextField jTextField1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
