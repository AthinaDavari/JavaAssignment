package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import static gr.aueb.dmst.pijavaparty.proderp.GUI.orders.AddNewSOrder.sorder;
import static gr.aueb.dmst.pijavaparty.proderp.GUI.orders.AddNewSOrder.supplierId;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.SOrderDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.SupplierDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.SOrderItem;
import gr.aueb.dmst.pijavaparty.proderp.services.SOrderServices;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * AddItemSOrder.java - A graphical user interface (gui) class responsible for 
 * adding a new order to a supplier - Select the raw material and enter the  
 * quantity for the selected raw material.
 * 
 * @author MariaKokkorou
 */
public class AddItemSOrder extends javax.swing.JFrame {

    private ArrayList<SOrderItem> SOrderItemsList = new ArrayList<SOrderItem>();
    // An array list with all the SOrderItem objects included in one specific 
    // order to a supplier.
    
    /**
     * Creates new form AddItemSOrder
     */
    public AddItemSOrder() {
        initComponents();
        fillComboBox();
        seticon();
        setTitle("Add Items");
    }

    /**
     * A special constructor for this class with an array list with all the
     * SOrderItem objects included in one specific order to a supplier 
     * as a parameter.
     * 
     * @param SOrderItemsList - an array list with all the SOrderItem objects 
     * included in one specific order to a supplier.
     */
    public AddItemSOrder(ArrayList<SOrderItem> SOrderItemsList) {
        this.SOrderItemsList = SOrderItemsList;
        initComponents();
        fillComboBox();
        seticon();
    }

    /**
     *Set the icon that is shown on the frame
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set AddItemSOrder window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNewItemOrderToSupplier = new javax.swing.JLabel();
        enterRawMaterials = new javax.swing.JLabel();
        enterQuantity = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        newitem = new javax.swing.JButton();
        addOrder = new javax.swing.JButton();
        rawMaterialsCombo = new javax.swing.JComboBox<>();
        valid_Quantity = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        addNewItemOrderToSupplier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addNewItemOrderToSupplier.setText("Add New Item Order To Supplier");

        enterRawMaterials.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterRawMaterials.setText("Enter Raw Materials:");

        enterQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterQuantity.setText("Enter Quantity:");

        quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        newitem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newitem.setText("New Item ");
        newitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newitemActionPerformed(evt);
            }
        });

        addOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addOrder.setText("Save Order");
        addOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderActionPerformed(evt);
            }
        });

        rawMaterialsCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        valid_Quantity.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Quantity.setForeground(new java.awt.Color(255, 0, 0));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(addNewItemOrderToSupplier)
                        .addGap(162, 162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newitem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantity))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterRawMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rawMaterialsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addNewItemOrderToSupplier)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enterRawMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(rawMaterialsCombo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enterQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newitem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Add another raw material with its quantity in the order to a specific supplier
     * 
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on New Item Order To Supplier button.
     */
    private void newitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newitemActionPerformed
            if (isValidInteger(quantity.getText())){ 
                // Check if the quantity entered is a valid integer.
                
                String rawMaterialsString = rawMaterialsCombo.getSelectedItem().toString();
                // Get the id - name of the selected raw material.
                int quantityInt = Integer.parseInt(quantity.getText().trim());
                // Get the quantity entered for this raw material.
                
                String[] rawMaterialIdInt = rawMaterialsString.split("-");
                // Split the raw material string in two parts, where the "-" 
                // symbol exists and store the two parts in a table.
                
                int rawMaterialId = Integer.parseInt(rawMaterialIdInt[0]);
                // The raw material's id is stored in position 0 of the table.
                
                RawMaterialDao rmd = new RawMaterialDao();
                RawMaterial rawmaterial = rmd.getById(rawMaterialId);
                // Get the RawMaterial object with id equal to rawMaterialId.

                SOrderItem sorderitem = new SOrderItem(sorder, rawmaterial, quantityInt);
                // Create a SOrderItem object.
                SOrderItemsList.add(sorderitem);
                // Add this SOrderItem object in SOrderItemsList array list.
                

                JOptionPane.showMessageDialog(null, "Added to Order List.");
                new AddItemSOrder(SOrderItemsList).setVisible(true);

                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }
    }//GEN-LAST:event_newitemActionPerformed

    /**
     * Adds the order to a supplier, with all the selected raw 
     * materials and their quantities that are stored in SOrderItemsList, in the
     * database.
     * 
     * @param evt - a reference to an ActionEvent object that is sent to
     * the method by clicking on Save Order button.
     */
    private void addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderActionPerformed

        if(isValidInteger(quantity.getText())){
            // Check if the quantity entered is a valid integer.
            
            JOptionPane.showMessageDialog(null, "Do You Want To Save Order?");

            String rawMaterialsString = rawMaterialsCombo.getSelectedItem().toString();
            // Get the id - name of the selected raw material.
            int quantityInt = Integer.parseInt(quantity.getText().trim());
            // Get the quantity entered for this raw material.

            String[] rawMaterialIdInt = rawMaterialsString.split("-");
            // split the raw material string in two parts, where the "-" 
            // symbol exists and store the two parts in a table.
            
            int rawMaterialId = Integer.parseInt(rawMaterialIdInt[0]);
            // the raw material's id is stored in position 0 of the table.
            
            RawMaterialDao rmd = new RawMaterialDao();
            RawMaterial rawmaterial = rmd.getById(rawMaterialId);
            // Get the RawMaterial object with id equal to rawMaterialId.

            SOrderItem sorderitem = new SOrderItem(sorder, rawmaterial, quantityInt);
            // Create a SOrderItem object.
            SOrderItemsList.add(sorderitem);
            // Add this SOrderItem object in SOrderItemsList array list.

            SOrderDao sod = new SOrderDao();
            sod.insertSOrderAndSOrderItems(sorder, SOrderItemsList);
            // Add the order to a supplier, with all the selected raw materials 
            // and their quantities that are stored in SOrderItemsList, in the
            // database.

            JOptionPane.showMessageDialog(null, "Order Saved.");
            new OrdersFromSuppliers().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
        }

    }//GEN-LAST:event_addOrderActionPerformed

    /**
     * Check if the quantity input is valid
     *
     * @param evt - a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */
    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
       if(!isValidInteger(quantity.getText())){
            valid_Quantity.setText("Quantity is invalid!");
        }else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_quantityKeyReleased

    /**
     * Close the Add Item SOrder window by clicking on cancel button on
     * the menu bar.
     *
     * @param evt - a reference to a MouseEvent object that is sent 
     * to the method by clicking on cancel button on the menu bar. 
     */
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new OrdersFromSuppliers().setVisible(true);
        dispose();

    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Fill rawMaterialsCombo combobox with all raw materials,which aren't 
     * included in Suppliers' Order.
     */
     private void fillComboBox(){
        List<String> rawMaterials;
        SupplierDao sd = new SupplierDao(); 
        // Get all raw materials, which aren't included in order.
        rawMaterials = SOrderServices.rawMaterialsNotIncludedInSuppliersOrder(SOrderItemsList, sd.getById(supplierId));
        int number = rawMaterials.size();// Number of raw materials, which aren't included in order.

        try {
            // Fill combobox
            for (int i = 0; i < number; i++) {

                rawMaterialsCombo.addItem(rawMaterials.get(i));

            }
            //Disable newitem button if combo box has only one item
            if (number == 1){
                disable_newitem_button();
            }

         } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

     /**
      * Disable newitem button
      */
     private void disable_newitem_button(){
         newitem.setEnabled(false);
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
            java.util.logging.Logger.getLogger(AddItemSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItemSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItemSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItemSOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItemSOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addNewItemOrderToSupplier;
    private javax.swing.JButton addOrder;
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel enterQuantity;
    private javax.swing.JLabel enterRawMaterials;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton newitem;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> rawMaterialsCombo;
    private javax.swing.JLabel valid_Quantity;
    // End of variables declaration//GEN-END:variables

}
