
package gr.aueb.dmst.pijavaparty.proderp.GUI.products;

import gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.GUI.SimpleMenu;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anna, aggel
 */
public class ProductGui extends javax.swing.JFrame {

    /**
     *
     */
    public ProductGui() {
        initComponents();
        fillProductTable();
        seticon();
        setTitle("Products");
    }

    /**
     *Method that sets the icon that is shown on the frame when the program is running. 
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Show_Ingredients = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        add_new_product = new javax.swing.JButton();
        update_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        product_id = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        LogOut = new javax.swing.JMenu();
        Back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Show_Ingredients.setBackground(java.awt.SystemColor.activeCaption);
        Show_Ingredients.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Show_Ingredients.setText("Show Ingredients of product:");
        Show_Ingredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Show_IngredientsActionPerformed(evt);
            }
        });

        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product_table);

        add_new_product.setBackground(java.awt.SystemColor.activeCaption);
        add_new_product.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        add_new_product.setText("Add");
        add_new_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_productActionPerformed(evt);
            }
        });

        update_delete.setBackground(java.awt.SystemColor.activeCaption);
        update_delete.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        update_delete.setText("Update/Delete");
        update_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Products");

        product_id.setEditable(false);
        product_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_idActionPerformed(evt);
            }
        });

        Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        LogOut.setForeground(new java.awt.Color(51, 51, 255));
        LogOut.setText("Log Out");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(LogOut);

        Back.setForeground(new java.awt.Color(51, 51, 255));
        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jMenuBar1.add(Back);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(315, 315, 315)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(update_delete)
                        .addGap(59, 59, 59)
                        .addComponent(add_new_product, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(Show_Ingredients)
                        .addGap(18, 18, 18)
                        .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_new_product, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Show_Ingredients, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //showing colums from table product in data base

    /**
     *Fill product_table table with all products in database
     */
    public void fillProductTable(){
        ProductDao proddao=new ProductDao();
        DefaultTableModel model=(DefaultTableModel) product_table.getModel();
        //take all products from database
        ArrayList<Product> products = proddao.getAll();
        int number=products.size();//number of products in database
        Object[] row=new Object[3];
        //fill table
        for(int i=0; i<number; i++){
            row[0]=products.get(i).getId();
            row[1]=products.get(i).getName();
            row[2]=products.get(i).getPrice();
            model.addRow(row);
        }
    }

    /**
     *
     * Responsible for the continuing of the execution in the insert product
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the add button.
     */    
    private void add_new_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_productActionPerformed
        new AddProducts().setVisible(true);
        dispose();
    }//GEN-LAST:event_add_new_productActionPerformed

    /**
     *
     * Responsible for the continuing of the execution in the edit product
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the update button.
     */    
    private void update_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_deleteActionPerformed
        new EditProduct().setVisible(true);
        dispose();
    }//GEN-LAST:event_update_deleteActionPerformed

    /**
     *
     * Responsible for the continuing of the execution in the ingredients
     * window.
     *
     * @param evt is a reference to a ActionEvent object that is sent to the
     * method by clicking the show ingredients button.
     */    
    private void Show_IngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Show_IngredientsActionPerformed
        try {
            int id=Integer.parseInt(product_id.getText());
            new Ingredients(id).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Select a Product.","Error",  JOptionPane.ERROR_MESSAGE);
            ProductGui stor = new ProductGui();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_Show_IngredientsActionPerformed

    private void product_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_idActionPerformed
    }//GEN-LAST:event_product_idActionPerformed

    /**
     *
     * Select a row of the table and put the product's id in the field to show its ingredients.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by putting the mouse cursor in a selected row of the table.
     */    
    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
        
        int selectedRow=product_table.getSelectedRow();
        DefaultTableModel model2 =(DefaultTableModel) product_table.getModel();
        product_id.setText((model2.getValueAt(selectedRow, 0).toString()));
    }//GEN-LAST:event_product_tableMouseClicked

    /**
    * Refresh button so that when something is changed, you can see if its also 
    * successfully changed in the data base.
    *
    * @param evt is a reference to an ActionEvent object that is sent to the
    * method by clicking the refresh quantity button.
    */    
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        ProductGui prodgui = new ProductGui();
        prodgui.setVisible(true);
        dispose();
    }//GEN-LAST:event_RefreshActionPerformed

    /**
     *
     * Loging out of the user that you are currently loged in in.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the log out button.
     */    
    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        LogIn login = new LogIn();
        LogIn.setUser(null);
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogOutMouseClicked

    /**
     *
     * Returning to the main menu window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the back button.
     */    
    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        if((LogIn.getUser().getRole()).equals("admin")){
            AdminMenu menu = new AdminMenu();
            menu.setVisible(true);
        } else {
            SimpleMenu menu = new SimpleMenu();
            menu.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_BackMouseClicked

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
            java.util.logging.Logger.getLogger(ProductGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Back;
    private javax.swing.JMenu LogOut;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Show_Ingredients;
    private javax.swing.JButton add_new_product;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField product_id;
    private javax.swing.JTable product_table;
    private javax.swing.JButton update_delete;
    // End of variables declaration//GEN-END:variables
}
