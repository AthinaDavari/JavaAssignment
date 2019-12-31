/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import static gr.aueb.dmst.pijavaparty.proderp.GUI.orders.AddNewCustOrder.corder;
import gr.aueb.dmst.pijavaparty.proderp.dao.COrderDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.COrderItem;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.services.COrderServices;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MariaKokkorou
 */
public class AddProductToCOrder extends javax.swing.JFrame {

    private ArrayList<COrderItem> COrderItemsList = new ArrayList<COrderItem>();

    /**
     * Creates new form AddItemSOrder
     */
    public AddProductToCOrder() {
        initComponents();
        comboBox();
        seticon();
    }

    public AddProductToCOrder(ArrayList<COrderItem> COrderItemsList) {
        this.COrderItemsList = COrderItemsList;
        initComponents();
        comboBox();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        newProduct = new javax.swing.JButton();
        addorder = new javax.swing.JButton();
        product = new javax.swing.JComboBox<>();
        valid_Quantity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Add New Product Order From Customer");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter Products:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Quantity:");

        quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        newProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newProduct.setText("New Product Order From Customer");
        newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductActionPerformed(evt);
            }
        });

        addorder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addorder.setText("Add Product Order From Customer");
        addorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addorderActionPerformed(evt);
            }
        });

        product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        valid_Quantity.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Quantity.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(product, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52)
                                .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addorder, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(product))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(addorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductActionPerformed
        try {
            if (isValidInteger(quantity.getText())) {
                String productString = product.getSelectedItem().toString();
                int quantityInt = Integer.parseInt(quantity.getText().trim());

                String[] productId = productString.split("-");
                int productIdInt = Integer.parseInt(productId[0]);
                ProductDao pd = new ProductDao();
                Product product = pd.getById(productIdInt);

                COrderItem corderitem = new COrderItem(corder, product, quantityInt);
                COrderItemsList.add(corderitem);

                JOptionPane.showMessageDialog(null, "Added to Order List.");
                new AddProductToCOrder(COrderItemsList).setVisible(true);

                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_newProductActionPerformed

    private void addorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addorderActionPerformed
        if (isValidInteger(quantity.getText())) {
            JOptionPane.showMessageDialog(null, "Do You Want To Save Order?");

            COrderDao cod = new COrderDao();

            String productString = product.getSelectedItem().toString();
            int quantityInt = Integer.parseInt(quantity.getText().trim());

            String[] productId = productString.split("-");
            int productIdInt = Integer.parseInt(productId[0]);
            ProductDao pd = new ProductDao();
            Product product = pd.getById(productIdInt);

            COrderItem corderitem = new COrderItem(corder, product, quantityInt);
            COrderItemsList.add(corderitem);

            cod.insertCOrderAndCOrderItems(corder, COrderItemsList);

            JOptionPane.showMessageDialog(null, "Order Saved.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
        }

    }//GEN-LAST:event_addorderActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        if (!isValidInteger(quantity.getText())) {
            valid_Quantity.setText("Quantity is invalid!");
        } else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_quantityKeyReleased

    private void comboBox() {

        List<String> products = COrderServices.rawMaterialsNotIncludedInSuppliersOrder(COrderItemsList);
        int number = products.size();

        try {

            for (int i = 0; i < number; i++) {

                product.addItem(products.get(i));

            }
            
            //Disable newProduct button if combo box has only one item
            if (number == 1){
                disable_newProduct_button();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
      * Disable newProduct button
      */
    private void disable_newProduct_button() {
        newProduct.setEnabled(false);
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
    private javax.swing.JButton addorder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton newProduct;
    private javax.swing.JComboBox<String> product;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel valid_Quantity;
    // End of variables declaration//GEN-END:variables

}
