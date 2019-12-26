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
import pijavaparty.proderp.dao.SOrderDao;
import pijavaparty.proderp.entity.SOrder;

/**
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

        jLabel1 = new javax.swing.JLabel();
        addOrder = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SOrdersTable = new javax.swing.JTable();
        showraw = new javax.swing.JButton();
        orid = new javax.swing.JTextField();
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

        showraw.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showraw.setText("Show Raw Materials");
        showraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showrawActionPerformed(evt);
            }
        });

        orid.setEditable(false);
        orid.setBackground(new java.awt.Color(153, 153, 153));

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
                .addComponent(showraw, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(showraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(orid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderActionPerformed
       
        new AddNewSOrder().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_addOrderActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       
        new EditSOrders().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_updateActionPerformed

    private void showrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showrawActionPerformed
      
        int id = Integer.parseInt(orid.getText());
        new ShowRawMaterialsOfOrder(id).setVisible(true);
        dispose();
      
    }//GEN-LAST:event_showrawActionPerformed

    private void SOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOrdersTableMouseClicked
        
        int selectedRow = SOrdersTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) SOrdersTable.getModel();
        orid.setText((model.getValueAt(selectedRow, 0).toString()));
         
    }//GEN-LAST:event_SOrdersTableMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
        OrdersFrame ordersframe = new OrdersFrame();
        ordersframe.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_backMouseClicked

<<<<<<< HEAD
    /**
     *
     */
=======
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       
        OrdersFromSuppliers ordersfromsuppliers = new OrdersFromSuppliers();
        ordersfromsuppliers.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_refreshActionPerformed

    
    
>>>>>>> 91beeba3ee77d600a6975bf57ec9c056f0b12a5a
    public void showSOrdersTable() {
        try {
            
            SOrderDao obj2 = new SOrderDao();
            List<SOrder> sorders = obj2.getAll();
            int number1 = sorders.size();
            DefaultTableModel model2 = (DefaultTableModel) SOrdersTable.getModel();

            Object[] row = new Object[4];

            for (int i = 0; i < number1; i++) {
                row[0] = sorders.get(i).getId();
                row[1] = sorders.get(i).getSupplier().getId() + "-" + sorders.get(i).getSupplier().getFullName();
                row[2] = sorders.get(i).getStatus();
                row[3] = sorders.get(i).getCreated_at();

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
    private javax.swing.JTextField orid;
    private javax.swing.JButton refresh;
    private javax.swing.JButton showraw;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
