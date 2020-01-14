package gr.aueb.dmst.pijavaparty.proderp.GUI.products;

import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isStringOnlyAlphabetAndNumbersAndWhiteSpaces;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidDouble;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * AddProducts.java - A graphical user interface (gui) class responsible for 
 * adding a new product along with its information. - Type name and price and press add.
 * @author anna, aggel
 */
public class AddProducts extends javax.swing.JFrame {

    /**
     *
     */
    public AddProducts() {
        initComponents();
        seticon();
        setTitle("Add Products");
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set AddProducts window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        value_name = new javax.swing.JTextField();
        value_price = new javax.swing.JTextField();
        addProduct = new javax.swing.JButton();
        valid_Price = new javax.swing.JLabel();
        valid_Name = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Add New Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Price");

        value_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_nameKeyReleased(evt);
            }
        });

        value_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_priceKeyReleased(evt);
            }
        });

        addProduct.setBackground(java.awt.SystemColor.activeCaption);
        addProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addProduct.setText("Add");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        valid_Price.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Price.setForeground(new java.awt.Color(255, 0, 0));

        valid_Name.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Name.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGap(264, 264, 264)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valid_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valid_Price, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method to add a new product.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the add button.
     */     
    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
       try {
           if (checkAllConstraints()){
           new AddIngredients(value_name.getText(),Double.parseDouble(value_price.getText())).setVisible(true);
           dispose(); 
           } else {
               JOptionPane.showMessageDialog(null, "Incorrect validation! Please try again!");
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Enter Details.","Error",  JOptionPane.ERROR_MESSAGE);
       }
       
    }//GEN-LAST:event_addProductActionPerformed

    /**
     * Returning to the product main window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the cancel button.
     */     
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        ProductGui productGui = new ProductGui();
        productGui.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Check if the price input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */    
    private void value_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_priceKeyReleased
       if (!isValidDouble(value_price.getText())){
            valid_Price.setText("Price is invalid!");
        } else {
            valid_Price.setText(null);
        }
    }//GEN-LAST:event_value_priceKeyReleased

    /**
     * Check if the name input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to
     * the method by typing a key in the keyboard.
     */    
    private void value_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_nameKeyReleased
        if (!isStringOnlyAlphabetAndNumbersAndWhiteSpaces(value_name.getText())) {
            valid_Name.setText("Name is invalid!");
        } else {
            valid_Name.setText(null);
        }
    }//GEN-LAST:event_value_nameKeyReleased

    
     /**
     * Check if all jtextfields in window have valid values
     * 
     * @return true-if all jtextfields have valid values,
     * false-if at least a jtextfield has invalid value
     */
    private boolean checkAllConstraints(){
        if(!isValidDouble(value_price.getText())){
            return false;
        }
        if(!isStringOnlyAlphabetAndNumbersAndWhiteSpaces(value_name.getText())){
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
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JMenu cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel valid_Name;
    private javax.swing.JLabel valid_Price;
    private javax.swing.JTextField value_name;
    private javax.swing.JTextField value_price;
    // End of variables declaration//GEN-END:variables
}
