package gr.aueb.dmst.pijavaparty.proderp.GUI.storage;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.services.StorageServices;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


/**
 *
 * @author aggel
 */
public class StorageUpdateQuantity extends javax.swing.JFrame {
    private int id;
    private String prodorraw;

    /**
     * Create new form StorageUpdateQuantity
     */
    public StorageUpdateQuantity() {
        initComponents();
        seticon();
        setTitle("Update Storage Quantity");
    }

    /**
     *
     * @param id
     * @param prodorraw
     */
    public StorageUpdateQuantity(int id, String prodorraw) {
        this.id=id;
        this.prodorraw=prodorraw;
        initComponents();
        seticon();
    }

    /**
     *Set the icon that is shown on the frame
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    
    /**
     * Set StorageUpdateQuantity window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        update_button = new javax.swing.JButton();
        value_quantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        valid_Quantity = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        value_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_quantityKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Update Quantity.");

        valid_Quantity.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Quantity.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGap(166, 166, 166)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * Returning to the Starage main window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the cancel button.
     */    
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        StorageMain stor = new StorageMain();
        stor.setVisible(true);
        dispose();    
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Update the quantity of a product or a raw material.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the update button.
     */
    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        try { 
            if(isValidInteger(value_quantity.getText())){
                int quant = Integer.parseInt(value_quantity.getText());
                if (prodorraw.equals("Product")) { // update quantity of a product
                    ProductDao productDao=new ProductDao();
                    Product prod = productDao.getById(id);
                    
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Update Ingredients Quantity Acordingly?","Warning",dialogButton);
                    if( dialogResult == JOptionPane.YES_OPTION){
                        updateProdQuantAndCorrespRawMat(quant);
                    } else if(dialogResult == JOptionPane.NO_OPTION) {
                        updateProdQuant(quant);
                    }
                    
                } else { // update quantity of a raw material
                    RawMaterialDao rawmaterialDao=new RawMaterialDao();
                    rawmaterialDao.updateQuantity(id,quant);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
                StorageUpdateQuantity storupquant = new StorageUpdateQuantity();
                storupquant.setVisible(true);
                dispose();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Insert quantity.","Error",  JOptionPane.ERROR_MESSAGE);
            StorageUpdateQuantity stor = new StorageUpdateQuantity();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void value_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_quantityKeyReleased
         if(!isValidInteger(value_quantity.getText())){
            valid_Quantity.setText("Quantity is invalid!");
        }else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_value_quantityKeyReleased

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
            java.util.logging.Logger.getLogger(StorageUpdateQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageUpdateQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageUpdateQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageUpdateQuantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new StorageUpdateQuantity().setVisible(true);
        });
    }
    
     /**
     * Update the quantity of the selected product and corresponding raw material
     */
    private void updateProdQuantAndCorrespRawMat(int quant) {                                          
        StorageServices storser= new StorageServices();
        //Check if the storage have enough raw materials to make a product in quantity we want
        ProductDao productDao = new ProductDao();
        Product prod = productDao.getById(id);
        if (storser.permissionToUpdateIngredients(id,  quant - prod.getQuantity())) {
            //Update the quantity of all the ingredients in product's recipe
            storser.updateIngredients(id,  quant - prod.getQuantity());
            productDao.updateQuantity(id,quant);//update the quantity of product
            JOptionPane.showMessageDialog(null,"Updated");
        } else {
            JOptionPane.showMessageDialog(null,"Cannot update, not enough raw materials.","Error",  JOptionPane.ERROR_MESSAGE);
        }
        new StorageMain().setVisible(true);
        dispose();
    }
    
     /**
     * Update the quantity of the selected product 
     */
    private void updateProdQuant(int quant) {                                         
        ProductDao productDao=new ProductDao();
        productDao.updateQuantity(id,quant);
        new StorageMain().setVisible(true);
        dispose();
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton update_button;
    private javax.swing.JLabel valid_Quantity;
    private javax.swing.JTextField value_quantity;
    // End of variables declaration//GEN-END:variables
}
