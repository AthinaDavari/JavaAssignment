package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.dao.SupplierDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrder;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * AddNewSOrder.java - A graphical user interface (gui) class responsible for 
 * adding a new order to a supplier - Select the supplier's id and name and then 
 * shows the graphical user interface (gui) of AddItemSOrder class.
 * 
 * @author MariaKokkorou
 */
public class AddNewSOrder extends javax.swing.JFrame {

    static SOrder sorder;
    static int supplierId;

    /**
     * Creates a new form AddNewSOrder
     */
    public AddNewSOrder() {
        initComponents();
        comboBox();
        seticon();
    }

    /**
     *Set the icon that is shown on the frame. 
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set AddNewSOrder window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOrderToSupplier = new javax.swing.JLabel();
        enterSupplierIDAndName = new javax.swing.JLabel();
        addNewItem = new javax.swing.JButton();
        supid = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        addOrderToSupplier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addOrderToSupplier.setText("Add Order To Supplier");

        enterSupplierIDAndName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterSupplierIDAndName.setText("Enter Supplier ID - Name:");

        addNewItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addNewItem.setText("Add New Item Order");
        addNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewItemActionPerformed(evt);
            }
        });

        supid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cancel.setForeground(new java.awt.Color(0, 0, 255));
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
                        .addGap(11, 11, 11)
                        .addComponent(enterSupplierIDAndName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(supid, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(addNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addOrderToSupplier)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addOrderToSupplier)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterSupplierIDAndName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supid, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(addNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Select the supplier's id and name to whom the order is added, and then
     * show the graphical user interface (gui) of AddItemSOrder class.
     *
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on Add New Item Order button.
     */
    private void addNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewItemActionPerformed

        try {
            
            String supplierAsString = supid.getSelectedItem().toString();
            // Get the selected supplier id and name.
            createSOrder(supplierAsString);
            // Create a SOrder object, which represents the order to the specific 
            // supplier with the selected id and name. 
            
            new AddItemSOrder().setVisible(true);
            // Shows the graphical user interface (gui) of AddItemSOrder class.
            
            dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_addNewItemActionPerformed

    /**
     * Fill the "supid" combobox with the ids and the names of all the suppliers
     * that exist in the database.
     * 
     */
    private void comboBox() {
        
        SupplierDao sd = new SupplierDao();
        List<Supplier> suppliers = new ArrayList();
        // suppliers - an array list with all the available suppliers that
        // exist in the database.
        suppliers = sd.getAll();
        int number = suppliers.size(); // the number of all the available 
        // suppliers existing in the database.
        
        try {
            
            for (int i = 0; i < number; i++) {
                supid.addItem(suppliers.get(i).getId() + "-" + suppliers.get(i).getFullName());
                // add in the combo box the id - name of all the suppliers.
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * 
     * A method that gets a string with the id - name of a supplier as a 
     * parametre, splits it and keeps only the supplier's id and creates 
     * a SOrder object that represents an order to the supplier with this specific id.
     * 
     * @param supplier - a string with the selected id and name of the supplier
     * from the combo box.
     */
    private void createSOrder(String supplier) {
        
        SupplierDao sd = new SupplierDao();
        String[] supplierTable = supplier.split("-");
        // split the supplier string in two parts, where the "-" symbol exists
        // and store the two parts in a table.
        
        supplierId = Integer.parseInt(supplierTable[0]); // the supplier's id is 
        // stored in position 0 of the table.
        sorder = new SOrder(sd.getById(supplierId));
        // creates a SOrder object that represents an order to the supplier 
        // with this specific id.
     
    }
    
    /**
     * Close the Add New SOrder window by clicking on cancel button on
     * the menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is sent to 
     * the method by clicking on the cancel button on the menu bar.
     */  
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new OrdersFromSuppliers().setVisible(true);
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
            java.util.logging.Logger.getLogger(AddNewSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewSOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewItem;
    private javax.swing.JLabel addOrderToSupplier;
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel enterSupplierIDAndName;
    private javax.swing.JMenuBar jMenuBar1;
    protected static javax.swing.JComboBox<String> supid;
    // End of variables declaration//GEN-END:variables
}
