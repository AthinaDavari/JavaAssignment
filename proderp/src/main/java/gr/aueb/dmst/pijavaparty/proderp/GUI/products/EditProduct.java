
package gr.aueb.dmst.pijavaparty.proderp.GUI.products;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isStringOnlyAlphabetAndNumbersAndWhiteSpaces;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidDouble;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * EditProduct.java - A graphical user interface (gui) class responsible for 
 * editing the information of an already existing product.
 * @author anna, aggel
 */
public class EditProduct extends javax.swing.JFrame {

    /**
     * Creates new form EditProduct
     */
    public EditProduct() {
        initComponents();
        showProductsTable();
        seticon();
        setTitle("Edit Product");
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set EditProduct window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        value_name = new javax.swing.JTextField();
        value_price = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        value_id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        valid_Name = new javax.swing.JLabel();
        valid_Price = new javax.swing.JLabel();
        jMenuBar4 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Edit Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Product ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Price");

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

        update.setBackground(java.awt.SystemColor.activeCaption);
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Products_Id", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(products_table);

        value_id.setEditable(false);

        delete.setBackground(java.awt.SystemColor.activeCaption);
        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        valid_Name.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Name.setForeground(new java.awt.Color(255, 0, 0));

        valid_Price.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Price.setForeground(new java.awt.Color(255, 0, 0));

        cancel.setForeground(new java.awt.Color(51, 51, 255));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        jMenuBar4.add(cancel);

        setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(value_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(value_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(value_id, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valid_Price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valid_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(value_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(value_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * Select a row of the table and put the raw product's data in the fields.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by putting the mouse cursor in a selected row of the table.
     */    
    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        
        int selectedRow=products_table.getSelectedRow();
        DefaultTableModel model2 =(DefaultTableModel) products_table.getModel();
        value_id.setText((model2.getValueAt(selectedRow, 0).toString()));
        value_name.setText((model2.getValueAt(selectedRow, 1).toString()));
       // value_quantity.setText((model2.getValueAt(selectedRow, 2).toString()));
        value_price.setText((model2.getValueAt(selectedRow, 2).toString()));
    }//GEN-LAST:event_products_tableMouseClicked

    /**
     * Method that deletes a product.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the delete button.
     */        
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String value1_id=value_id.getText();
            int newvalue1_id=Integer.parseInt(value1_id);
            ProductDao productDao=new ProductDao();
            productDao.delete(newvalue1_id);
            JOptionPane.showMessageDialog(null,"Deleted");
            new EditProduct().setVisible(true);
            dispose();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Insert Details.","Error",  JOptionPane.ERROR_MESSAGE);
            EditProduct stor = new EditProduct();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * Update the details of a product.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the update button.
     */    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       try{
           if(checkAllConstraints()){
              JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
              return;
           }
            String value1_id=value_id.getText();
            int newvalue1_id=Integer.parseInt(value1_id);
            String value2_name=value_name.getText();
            String value4_price=value_price.getText();
            double newvalue4_price=Double.parseDouble(value4_price);
            
            ProductDao proddao=new ProductDao();
            proddao.updateName(newvalue1_id, value2_name);
            proddao.updatePrice(newvalue1_id, newvalue4_price);
            
            
            JOptionPane.showMessageDialog(null,"Updated");
            new EditProduct().setVisible(true);
            dispose();

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Insert Details.","Error",  JOptionPane.ERROR_MESSAGE);
            EditProduct stor = new EditProduct();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_updateActionPerformed

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
     * Check if the name input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
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
     * Check if the price input is valid and if it is invalid show a
     * warning message.
     *
     * @param evt  is a reference to a KeyEvent object that is sent to
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
     * Check if all jtextfields in window have valid values
     * 
     * @return true-if all jtextfields have valid values,
     * false-if at least a jtextfield has invalid value
     */
    private boolean checkAllConstraints(){
       if(!isStringOnlyAlphabetAndNumbersAndWhiteSpaces(value_name.getText())){
           return false;
       } 
       if(!isValidDouble(value_price.getText())){
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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProduct().setVisible(true);
            }
        });
    }


    /**
     *Method that shows every product that the copmany has along with 
     *some information for each one. 
     */
    public void showProductsTable(){
        ProductDao proddao=new ProductDao();
        DefaultTableModel model=(DefaultTableModel) products_table.getModel();
        int number=proddao.getAll().size();
        Object[] row=new Object[3];
        for(int i=0; i<number; i++){
            row[0]=proddao.getAll().get(i).getId();
            row[1]=proddao.getAll().get(i).getName();
            row[2]=proddao.getAll().get(i).getPrice();
            model.addRow(row);
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable products_table;
    private javax.swing.JButton update;
    private javax.swing.JLabel valid_Name;
    private javax.swing.JLabel valid_Price;
    private javax.swing.JTextField value_id;
    private javax.swing.JTextField value_name;
    private javax.swing.JTextField value_price;
    // End of variables declaration//GEN-END:variables
}
