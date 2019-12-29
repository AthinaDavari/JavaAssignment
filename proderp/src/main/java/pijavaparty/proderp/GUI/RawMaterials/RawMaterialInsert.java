
package pijavaparty.proderp.GUI.RawMaterials;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.dao.SupplierDao;
import pijavaparty.proderp.entity.Supplier;
import pijavaparty.proderp.GUI.LogIn;
import pijavaparty.proderp.GUI.Storage.StorageUpdateQuantity;
import pijavaparty.proderp.entity.RawMaterial;
import pijavaparty.proderp.Services.ValidVariables;
import static pijavaparty.proderp.Services.ValidVariables.isValidDouble;
import static pijavaparty.proderp.Services.ValidVariables.isValidInteger;
/**
 *
 * @author aggel
 */
public class RawMaterialInsert extends javax.swing.JFrame {

    /**
     *
     */
    public RawMaterialInsert() {
        initComponents();
        fillcombo();
        seticon();
    }

    /**
     *
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    @SuppressWarnings("unchecked")
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
        drop_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drop_downActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantity:");

        jLabel5.setText("Price:");

        value_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                value_priceActionPerformed(evt);
            }
        });
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

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        dispose(); 
    }//GEN-LAST:event_cancelMouseClicked

    private void addRawMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRawMaterialActionPerformed
        try {
            if (ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText())&& isValidDouble(value_price.getText()) &&  isValidInteger(value_quantity.getText()) ){
            String value2_name=value_name.getText();
            String value_supplier_name=drop_down.getSelectedItem().toString();
            SupplierDao supdao = new SupplierDao();
            List<Supplier> suppliers;
            suppliers=supdao.getAll();
            Supplier sup = null;
            int num=suppliers.size();
            for(int i=0; i<num; i++){
                if (suppliers.get(i).getFullName().equals(value_supplier_name)) {  
                    sup=suppliers.get(i);

                    break;
                }
            }
            String value4_quantity=value_quantity.getText();
            int newvalue4_quantity=Integer.parseInt(value4_quantity);
            double value5_price=Double.parseDouble(value_price.getText());
            RawMaterialDao rawdao=new RawMaterialDao();
            RawMaterial rawmat = new RawMaterial(value2_name, newvalue4_quantity, value5_price, sup);
            rawdao.insert(rawmat);
            JOptionPane.showMessageDialog(null,"Added");
            dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Insert all the details.","Error",  JOptionPane.ERROR_MESSAGE);
            StorageUpdateQuantity stor = new StorageUpdateQuantity();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_addRawMaterialActionPerformed

    private void drop_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drop_downActionPerformed
    }//GEN-LAST:event_drop_downActionPerformed

    private void value_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_value_priceActionPerformed
    }//GEN-LAST:event_value_priceActionPerformed

    private void value_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_nameKeyReleased
        if (!ValidVariables.isStringOnlyAlphabetAndWhiteSpaces(value_name.getText())) {
            valid_Name.setText("Name is invalid!");
        } else {
            valid_Name.setText(null);
        }
    }//GEN-LAST:event_value_nameKeyReleased

    private void value_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_priceKeyReleased
        if (!isValidDouble(value_price.getText())){
            valid_Price.setText("Price is invalid!");
        } else {
            valid_Price.setText(null);
        }
    }//GEN-LAST:event_value_priceKeyReleased

    private void value_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_quantityKeyReleased
        if(!isValidInteger(value_quantity.getText())){
            valid_Quantity.setText("Quantity is invalid!");
        }else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_value_quantityKeyReleased
    //fill up the drop down with suppliers
    private void fillcombo(){
        SupplierDao supdao = new SupplierDao();
        List<Supplier> suppliers;
        suppliers = supdao.getAll();
        int num=supdao.getAll().size();
        try{
            for(int i=0; i<num; i++){
                
                drop_down.addItem(suppliers.get(i).getFullName());
                
            }
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
