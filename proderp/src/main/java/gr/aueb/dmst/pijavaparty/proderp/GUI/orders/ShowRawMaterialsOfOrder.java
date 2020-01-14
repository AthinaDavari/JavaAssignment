package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.dao.SOrderItemDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * ShowRawMaterialsOfOrder.java - A graphical user interface (gui) class for 
 * showing all the raw materials included in an order to suppliers with a specific 
 * order id - shows the raw material's id, the raw material's name and the 
 * quantity of this specific raw material.
 * 
 * @author MariaKokkorou
 */
public class ShowRawMaterialsOfOrder extends javax.swing.JFrame {
    
    /**
     * Creates new form ShowRawMaterialsOfOrder
     */
    public ShowRawMaterialsOfOrder() {
        initComponents();
        showRawMaterialsTable();
        seticon();
    }
    
    private int selectedOrder;

    /**
     * ShowRawMaterialsOfOrder - a special construstor of this class with the selected 
     * order's id as a parametre.
     * 
     * @param selectedOrder
     */
    public ShowRawMaterialsOfOrder(int selectedOrder) {
        this.selectedOrder=selectedOrder;
        initComponents();
        showRawMaterialsTable();
        seticon();
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    private void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Initialize the form of the window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rawMaterialsOfOrder = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawMaterialsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        rawMaterialsOfOrder.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rawMaterialsOfOrder.setText("Raw Materials Of Order");

        rawMaterialsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material ID", "Raw Material Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rawMaterialsTable);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rawMaterialsOfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rawMaterialsOfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close the Show Raw Materials Of Order window by clicking on cancel button 
     * on the menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is  sent to
     * the method by clicking on cancel button on the menu bar.
     */
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new OrdersFromSuppliers().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked
    
    /**
     * Get raw material's id, raw material's name and raw material's quantity
     * data from database and show them in showRawMaterialsTable table.
     * 
     */
    public void showRawMaterialsTable() {

        SOrderItemDao soid = new SOrderItemDao();
        DefaultTableModel model = (DefaultTableModel) rawMaterialsTable.getModel();
        List<SOrderItem> itemsPerSOrder = soid.getItemsperSOrder(selectedOrder);
        // itemsPerSOrder - an arraylist filled with all the raw materials 
        // that a specific order to suppliers, with id equal to selectedOrder, 
        // contains.
        int number = itemsPerSOrder.size(); // The number of raw materials included
        // in the specific order to suppliers.
        Object[] row = new Object[3];

        for (int i = 0; i < number; i++) {

            row[0] = itemsPerSOrder.get(i).getRawmaterial().getId();
            // Fill the first column of the table with the id of the raw material.
            row[1] = itemsPerSOrder.get(i).getRawmaterial().getName();
            // Fill the second column of the table with the name of the raw material.
            row[2] = itemsPerSOrder.get(i).getQuantity();
            // Fill the third column of the table with the quantity of the raw material.
            
            model.addRow(row);

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
            java.util.logging.Logger.getLogger(ShowRawMaterialsOfOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowRawMaterialsOfOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowRawMaterialsOfOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowRawMaterialsOfOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowRawMaterialsOfOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rawMaterialsOfOrder;
    private javax.swing.JTable rawMaterialsTable;
    // End of variables declaration//GEN-END:variables

}
