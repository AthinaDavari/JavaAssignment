package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.GUI.customers.CustomerMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.SOrderDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * OrdersFromSuppliers - a graphical user interface (gui) class for choosing to 
 * update, delete, add the data of an order to supplier, or show all the 
 * raw materials included in a supplier's order.
 * 
 * @author MariaKokkorou
 */

public class OrdersFromSuppliers extends javax.swing.JFrame {

    /**
     * Creates new form OrdersFromSuppliers
     */
    public OrdersFromSuppliers() {
        initComponents();
        showSOrdersTable();
        seticon();
    }

    /**
     *Set the icon that is shown on the frame. 
     */
    private void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    /**
     * Set OrdersFromSuppliers window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addOrder = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SOrdersTable = new javax.swing.JTable();
        showRawMaterials = new javax.swing.JButton();
        selectedOrder = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orders To Suppliers");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Orders To Suppliers");

        addOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addOrder.setText("Add New Order");
        addOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update / Delete Order");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        SOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Supplier ID - Name", "Status", "Created At"
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
        jScrollPane1.setViewportView(SOrdersTable);

        showRawMaterials.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showRawMaterials.setText("Show Raw Materials");
        showRawMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRawMaterialsActionPerformed(evt);
            }
        });

        selectedOrder.setEditable(false);
        selectedOrder.setBackground(new java.awt.Color(153, 153, 153));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        back.setForeground(new java.awt.Color(0, 0, 204));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(addOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(showRawMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showRawMaterials, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(selectedOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Show the graphical user interface of AddNewSOrder class, by
    * clicking on the Add New Order button. 
    * 
    * @param evt is a reference to an ActionEvent object that is sent to the
    * method by clicking the Add New Order button.
    */
    
    private void addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderActionPerformed
       
        new AddNewSOrder().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_addOrderActionPerformed

    /**
    * Show the graphical user interface of EditSOrders class, by
    * clicking on the Update / Delete Order button. 
    * 
    * @param evt is a reference to an ActionEvent object that is sent to the
    * method by clicking the Update / Delete Order button.
    */
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        new EditSOrders().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_updateActionPerformed

    /**
    * Show the graphical user interface - gui of ShowRawMaterialsOfOrder class,
    * by clicking on the Show Raw Materials button - Shows all the raw materials
    * included in the order with the id written in the selectedOrder field.
    * 
    * @param evt is a reference to an ActionEvent object that is sent to the
    * method by clicking the Show Raw Materials button.
    */
    private void showRawMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRawMaterialsActionPerformed
      
        int id = Integer.parseInt(selectedOrder.getText());
        new ShowRawMaterialsOfOrder(id).setVisible(true);
        dispose();
      
    }//GEN-LAST:event_showRawMaterialsActionPerformed

    /**
      * Select a row of the table by clicking on it, and insert the order's ID
      * in the selectedOrder field.
      * 
      * @param evt - a reference to a MouseEvent object that is sent to the
      * method by putting the mouse's cursor over a selected row of the table. 
      */
    private void SOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOrdersTableMouseClicked
        
        int selectedRow = SOrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) SOrdersTable.getModel();
        selectedOrder.setText((model.getValueAt(selectedRow, 0).toString()));
         
    }//GEN-LAST:event_SOrdersTableMouseClicked

    /**
     * Close the Orders From Suppliers window - gui of OrdersFromSuppliers class, 
     * and return back to the orders' menu window - gui of OrdersFrame class,
     * by clicking on back button on the menu bar.
     * 
     * @param evt - a reference to a MouseEvent object that is sent to
     * the method by clicking the back button.
     */
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
        OrdersFrame ordersframe = new OrdersFrame();
        ordersframe.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_backMouseClicked

    /**
     * Refresh the Orders From Suppliers window - gui of OrdersFromSuppliers class
     * 
     * @param evt - a reference to an ActionEvent object that is sent 
     * to the method by clicking on refresh button.
     */
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       setVisible(false);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomerMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
        DefaultTableModel model = (DefaultTableModel)SOrdersTable.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        showSOrdersTable();
    }//GEN-LAST:event_refreshActionPerformed

    /** 
     * Get order's id, supplier's id and name, status and order's time of creation 
     * data from database and show them in showSOrdersTable table.
     * 
     */
    public void showSOrdersTable() {
        try {
            
            SOrderDao obj2 = new SOrderDao();
            List<SOrder> sorders = obj2.getAll();
            // sorders - an arraylist filled with all the orders to suppliers.
            int number1 = sorders.size(); // the number of orders to suppliers.
            DefaultTableModel model2 = (DefaultTableModel) SOrdersTable.getModel();

            Object[] row = new Object[4];

            for (int i = 0; i < number1; i++) {
                row[0] = sorders.get(i).getId(); // Fill the first column of the table with the id of the order.
                row[1] = sorders.get(i).getSupplier().getId() + "-" + sorders.get(i).getSupplier().getFullName();
                // Fill the second column of the table with the id - name of the supplier.
                row[2] = sorders.get(i).getStatus();
                // Fill the third column of the table with the status of the order.
                row[3] = sorders.get(i).getCreated_at();
                // Fill the fourth column of the table with the time of creation of the order.
                
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
            java.util.logging.Logger.getLogger(OrdersFromSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersFromSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersFromSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersFromSuppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersFromSuppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SOrdersTable;
    private javax.swing.JButton addOrder;
    private javax.swing.JMenu back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField selectedOrder;
    private javax.swing.JButton showRawMaterials;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
