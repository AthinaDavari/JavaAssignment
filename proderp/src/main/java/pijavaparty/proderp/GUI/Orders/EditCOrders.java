/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.GUI.Orders;

import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pijavaparty.proderp.dao.COrderDao;
import pijavaparty.proderp.dao.COrderItemDao;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.entity.COrder;
import pijavaparty.proderp.entity.COrderItem;
import pijavaparty.proderp.entity.Product;

/**
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
    }

    /**
     *
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        back = new javax.swing.JMenu();
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
                "Order's ID", "Customer ID - Name", "Status", "Created At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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

        back.setForeground(new java.awt.Color(0, 0, 204));
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jMenuBar1.add(back);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(orderid, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(stat))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            String orderIdString = orderid.getText();
            int orderIdInt = Integer.parseInt(orderIdString);

            String status = stat.getText();
            
            
            if (status.equals("ready")){
                
//               updateIngridients(orderIdInt, );
               increaseProduct(orderIdInt);
                
            }
            
            if (status.equals("delivered")){
                
               decreaseProduct(orderIdInt);
                
            }
            
            COrderDao cod = new COrderDao();
            cod.updateStatus(orderIdInt, (status));
    
            JOptionPane.showMessageDialog(null, "Status Updated.");
            
            new EditCOrders().setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_updateActionPerformed

    private void COrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COrdersTableMouseClicked

        int selectedRow = COrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();
        orderid.setText((model.getValueAt(selectedRow, 0).toString()));
        stat.setText(((model.getValueAt(selectedRow, 2).toString().equals("ready")))?"delivered":"ready");
        
    }//GEN-LAST:event_COrdersTableMouseClicked


    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        String orderIDString = orderid.getText();
        int orderIDint = Integer.parseInt(orderIDString);
        
        try {
            
            COrderDao cod = new COrderDao();
            cod.delete(orderIDint);
            JOptionPane.showMessageDialog(null,"Order Deleted.");
            new EditCOrders().setVisible(true);
            dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
        OrdersFromCustomers ordersfromcustomers = new OrdersFromCustomers();
        ordersfromcustomers.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_backMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
       
        dispose();
        
    }//GEN-LAST:event_cancelMouseClicked

    /**
     *
     */
    public void showCOrdersTable() {
        try {
            
            COrderDao cod = new COrderDao();
            List<COrder> corders = cod.getAllExceptFromDelivered();
            int number = corders.size();
            DefaultTableModel model = (DefaultTableModel) COrdersTable.getModel();

            Object[] row = new Object[5];

            for (int i = 0; i < number; i++) {
                row[0] = corders.get(i).getId();
                row[1] = corders.get(i).getCustomer().getId() + "-" + corders.get(i).getCustomer().getFullName();
                row[2] = corders.get(i).getStatus();
                row[3] = corders.get(i).getCreated_at();
                row[4] = corders.get(i).getUser().getFullName();

                model.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     *
     * @param corderid
     */
    public void increaseProduct(int corderid){
        
        COrderItemDao coid = new COrderItemDao();
        List <COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {
            
            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() + cOrderItem.getQuantity());
       
        }
        
    }
    
    /**
     *
     * @param corderid
     */
    public void decreaseProduct(int corderid){
        
        COrderItemDao coid = new COrderItemDao();
        List <COrderItem> corderitems = coid.getItemsPerCOrder(corderid);
        ProductDao pd = new ProductDao();
        for (COrderItem cOrderItem : corderitems) {
            
            Product productFromOrder = cOrderItem.getProduct();
            pd.updateQuantity(productFromOrder.getId(), pd.getById(productFromOrder.getId()).getQuantity() - cOrderItem.getQuantity());
       
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
    private javax.swing.JMenu back;
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField orderid;
    private javax.swing.JTextField stat;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
