package gr.aueb.dmst.pijavaparty.proderp.GUI.storage;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.services.StorageServices;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author aggel
 */
public class ProductIngredientsUpdate extends javax.swing.JFrame {

    /**
     * Id of the product.
     */
    public int id;

    /**
     * Quantity of the product.
     */
    public int quant;


    public ProductIngredientsUpdate() {
        initComponents();
        
    }

    /**
     * Constracor to get id and quantity from previous window
     * @param id
     * @param quant
     */
    public ProductIngredientsUpdate(int id, int quant) {
        this.id=id;
        this.quant=quant;
        initComponents();
        seticon();
        setTitle("Update Product's Ingredients");
    }

    /**
     *Set the icon that is shown on the frame
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        answerNo = new javax.swing.JButton();
        answerYes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Update Ingredients Quantity Acordingly?");

        answerNo.setText("NO");
        answerNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerNoActionPerformed(evt);
            }
        });

        answerYes.setText("YES");
        answerYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerYesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answerYes)
                        .addGap(48, 48, 48)
                        .addComponent(answerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerYes)
                    .addComponent(answerNo))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Execution of the quantity update of the materials used in the making of a 
     * product.
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the yes button.
     */
    private void answerYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesActionPerformed
        StorageServices storser= new StorageServices();
        //Check if the storage have enough raw materials to make a product in quantity we want
        if (storser.permissionToUpdateIngredients(id, quant)) {
            //Update the quantity of all the ingredients in product's recipe
            storser.updateIngredients(id, quant);
            ProductDao productDao=new ProductDao();
            productDao.updateQuantity(id,quant);//update the quantity of product
            JOptionPane.showMessageDialog(null,"Updated");
        } else {
            JOptionPane.showMessageDialog(null,"Cannot update, not enough raw materials.","Error",  JOptionPane.ERROR_MESSAGE);
        }
        new StorageMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_answerYesActionPerformed
    
    /**
     * The choice of not updating the materials used in the making of a 
     * product. 
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the no button.
     */
    private void answerNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoActionPerformed
        ProductDao productDao=new ProductDao();
        productDao.updateQuantity(id,quant);
        new StorageMain().setVisible(true);
        dispose();
    }//GEN-LAST:event_answerNoActionPerformed

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
            java.util.logging.Logger.getLogger(ProductIngredientsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductIngredientsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductIngredientsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductIngredientsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductIngredientsUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answerNo;
    private javax.swing.JButton answerYes;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
