package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.GUI.customers.CustomerMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.COrderDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrder;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * OrdersFromCustomers - a graphical user interface (gui) class for choosing to 
 * update, delete, add the data of an order from customer, or show all the 
 * products included in a customer's order.
 * 
 * @author MariaKokkorou
 */
public class OrdersFromCustomers extends javax.swing.JFrame {

    /**
     * Creates new form OrdersFromCustomers
     */
    public OrdersFromCustomers() {
        initComponents();
        seticon();
        showCOrdersTable();
    }

    /**
     *Sets the icon that is shown on the frame. 
     */
    private void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    /**
     * Initialize the form of the window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addCustOrder = new javax.swing.JButton();
        editCustOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        COrdersTable = new javax.swing.JTable();
        showProducts = new javax.swing.JButton();
        selectedOrder = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Orders From Customers Menu");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Orders From Customers");

        addCustOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addCustOrder.setText("Add New Order");
        addCustOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustOrderActionPerformed(evt);
            }
        });

        editCustOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editCustOrder.setText("Update / Delete Order");
        editCustOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustOrderActionPerformed(evt);
            }
        });

        COrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID - Name", "Status", "Created At", "User Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(COrdersTable);

        showProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showProducts.setText("Show Products ");
        showProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProductsActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(editCustOrder)
                .addGap(65, 65, 65)
                .addComponent(addCustOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(showProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectedOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editCustOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addCustOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectedOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Show the graphical user interface of AddNewCustOrder class, by
    * clicking on the Add New Order button. 
    * 
    * @param evt - a reference to an ActionEvent object that is sent 
    * to the method by clicking on the Add New Order button.
    */   
    private void addCustOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustOrderActionPerformed
        
        new AddNewCustOrder().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_addCustOrderActionPerformed

    /**
    * Show the graphical user interface of EditCOrders class, by
    * clicking on the "Update / Delete Order" button. 
    * 
    * @param evt - a reference to an  ActionEvent object that is sent 
    * to the method by clicking on the Update / Delete Order button.
    */  
    private void editCustOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustOrderActionPerformed
        
        new EditCOrders().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_editCustOrderActionPerformed

    /**
      * Select a row of the table by clicking on it, and insert the order's ID
      * in the selectedOrder field.
      * 
      * @param evt - a reference to a MouseEvent object that is sent to 
      * the method by putting the mouse's cursor over a selected row of the table. 
      */
    private void COrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COrdersTableMouseClicked
       
        int selectedRow = COrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();
        selectedOrder.setText((model.getValueAt(selectedRow, 0).toString()));
        
    }//GEN-LAST:event_COrdersTableMouseClicked

    /**
    * Show the graphical user interface - gui of ShowProductsOfOrder class, by
    * clicking on the Show Products button - Shows all the products included
    * in the order with the id written in the selectedOrder field.
    * 
    * @param evt - a reference to an  ActionEvent object that is sent 
    * to the method by clicking on the Show Products button.
    */
    private void showProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProductsActionPerformed
       
        int id = Integer.parseInt(selectedOrder.getText());
        new ShowProductsOfOrder(id).setVisible(true);
        
    }//GEN-LAST:event_showProductsActionPerformed

    /**
     * Close the Orders From Customers window - gui of OrdersFromCustomers class, 
     * and return back to the orders' menu window - gui of OrdersFrame class,
     * by clicking on back button on the menu bar.
     * 
     * @param evt - a reference to a MouseEvent object that is sent 
     * to the method by clicking the back button on the menu bar.
     */
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
        OrdersFrame ordersframe = new OrdersFrame();
        ordersframe.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_backMouseClicked

    /** 
     * Refresh the Orders From Customers window - gui of OrdersFromCustomers class.
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
        DefaultTableModel model = (DefaultTableModel)COrdersTable.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        showCOrdersTable();
        
    }//GEN-LAST:event_refreshActionPerformed

     /** 
     * Get order's id, customer's id and name, status and order's time of creation 
     * and username data from database and show them in showCOrdersTable table.
     * 
     */
     private void showCOrdersTable() {
        try {
            
            COrderDao obj = new COrderDao();
            List<COrder> corders = obj.getAll();
            // corders - an arraylist filled with all the orders from customers.
            int number = corders.size(); // the number of orders from customers.
            DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();

            Object[] row = new Object[5];

            for (int i = 0; i < number; i++) {
                row[0] = corders.get(i).getId(); // Fill the first column of the table with the id of the order.
                row[1] = corders.get(i).getCustomer().getId() + "-" + corders.get(i).getCustomer().getFullName();
                // Fill the second column of the table with the id - name of the customer.
                row[2] = corders.get(i).getStatus(); // Fill the third column of the table with the status of the order.
                row[3] = corders.get(i).getCreated_at(); // Fill the fourth column 
                // of the table with the time of creation of the order.
                row[4] = " - ";
                if(corders.get(i).getUser()!=null){
                row[4] = corders.get(i).getUser().getUsername(); 
                // Fill the fifth column of the table with the username.
                }
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
            java.util.logging.Logger.getLogger(OrdersFromCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersFromCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersFromCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersFromCustomers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdersFromCustomers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable COrdersTable;
    private javax.swing.JButton addCustOrder;
    private javax.swing.JMenu back;
    private javax.swing.JButton editCustOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField selectedOrder;
    private javax.swing.JButton showProducts;
    // End of variables declaration//GEN-END:variables
}
