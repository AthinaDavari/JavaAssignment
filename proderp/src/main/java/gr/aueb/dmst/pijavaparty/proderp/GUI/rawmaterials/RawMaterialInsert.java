package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.GUI.storage.StorageUpdateQuantity;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.SupplierDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.Supplier;
import gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidDouble;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * RawMaterialInsert.java - A graphical user interface (gui) class responsible for 
 * inserting a new raw material.
 * @author aggel
 */
public class RawMaterialInsert extends javax.swing.JFrame {

    /**
     * Creates new form RawMaterialInsert 
     */
    public RawMaterialInsert() {
        initComponents();
        fillcombo();
        seticon();
        setTitle("Insert Raw Materials");
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set RawMaterialInsert window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addRawMaterial = new javax.swing.JButton();
        value_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        drop_down = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        value_price = new javax.swing.JTextField();
        value_quantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        valid_Name = new javax.swing.JLabel();
        valid_Quantity = new javax.swing.JLabel();
        valid_Price = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addRawMaterial.setText("Add");
        addRawMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRawMaterialActionPerformed(evt);
            }
        });

        value_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_nameKeyReleased(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Supplier Id");

        drop_down.setMaximumRowCount(25);

        jLabel4.setText("Quantity:");

        jLabel5.setText("Price:");

        value_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_priceKeyReleased(evt);
            }
        });

        value_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_quantityKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Insert Raw Material:");

        valid_Name.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Name.setForeground(new java.awt.Color(255, 0, 0));

        valid_Quantity.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Quantity.setForeground(new java.awt.Color(255, 0, 0));

        valid_Price.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Price.setForeground(new java.awt.Color(255, 0, 0));

        cancel.setForeground(new java.awt.Color(51, 51, 255));
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
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valid_Quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valid_Price, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(valid_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(addRawMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(valid_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valid_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addComponent(addRawMaterial)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Returning to the raw material main window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the cancel button.
     */ 
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        new RawMaterialMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Method to add a new raw material
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the add button.
     */    
    private void addRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRawMaterialActionPerformed
        try {
            if (!checkAllConstraints()) {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
                return;
            }
            
                String value2_name = value_name.getText();
                String value_supplier_name = drop_down.getSelectedItem().toString();
                SupplierDao supdao = new SupplierDao();
                List<Supplier> suppliers;
                suppliers = supdao.getAll();
                Supplier sup = null;
                int num = suppliers.size();
                for (int i = 0; i < num; i++) { // association of an already existing supplier with the new raw material.
                    if (suppliers.get(i).getFullName().equals(value_supplier_name)) {
                        sup = suppliers.get(i);

                        break;
                    }
                }
                String value4_quantity = value_quantity.getText();
                int newvalue4_quantity = Integer.parseInt(value4_quantity);
                double value5_price = Double.parseDouble(value_price.getText());
                RawMaterialDao rawdao = new RawMaterialDao();
                RawMaterial rawmat = new RawMaterial(value2_name, newvalue4_quantity, value5_price, sup);
                rawdao.insert(rawmat);
                JOptionPane.showMessageDialog(null, "Added");
                new RawMaterialMenu().setVisible(true);
                dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insert all the details.", "Error", JOptionPane.ERROR_MESSAGE);
            StorageUpdateQuantity stor = new StorageUpdateQuantity();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_addRawMaterialActionPerformed
    
    /**
     * Check if the name input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */
    private void value_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_nameKeyReleased
        if (!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText())) {
            valid_Name.setText("Name is invalid!");
        } else {
            valid_Name.setText(null);
        }
    }//GEN-LAST:event_value_nameKeyReleased
    
    /**
     * Check if the price input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */
    private void value_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_priceKeyReleased
        if (!isValidDouble(value_price.getText())) {
            valid_Price.setText("Price is invalid!");
        } else {
            valid_Price.setText(null);
        }
    }//GEN-LAST:event_value_priceKeyReleased
    
    /**
     * Check if the quantity input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */
    private void value_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_quantityKeyReleased
        if (!isValidInteger(value_quantity.getText())) {
            valid_Quantity.setText("Quantity is invalid!");
        } else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_value_quantityKeyReleased
    
    /**
     * Fill the drop down with all the suppliers that the company works with.
     */
    private void fillcombo() {
        SupplierDao supdao = new SupplierDao();
        List<Supplier> suppliers;
        suppliers = supdao.getAll();
        int num = supdao.getAll().size();
        try {
            for (int i = 0; i < num; i++) {

                drop_down.addItem(suppliers.get(i).getFullName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
       
    /**
     * Check if all jtextfields in window have valid values
     * 
     * @return true-if all jtextfields have valid values,
     * false-if at least a jtextfield has invalid value
     */
    private boolean checkAllConstraints(){
        if(!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText())){
            return false;
        }
        if(!isValidDouble(value_price.getText())){
            return false;
        }
        if(!isValidInteger(value_quantity.getText())){
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(RawMaterialInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawMaterialInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawMaterialInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawMaterialInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RawMaterialInsert().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRawMaterial;
    private javax.swing.JMenu cancel;
    private javax.swing.JComboBox<String> drop_down;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel valid_Name;
    private javax.swing.JLabel valid_Price;
    private javax.swing.JLabel valid_Quantity;
    private javax.swing.JTextField value_name;
    private javax.swing.JTextField value_price;
    private javax.swing.JTextField value_quantity;
    // End of variables declaration//GEN-END:variables
}
