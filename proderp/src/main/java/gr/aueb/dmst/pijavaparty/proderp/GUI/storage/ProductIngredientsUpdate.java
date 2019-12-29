package gr.aueb.dmst.pijavaparty.proderp.GUI.storage;

import gr.aueb.dmst.pijavaparty.proderp.services.StorageServices;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author aggel
 */
public class ProductIngredientsUpdate extends javax.swing.JFrame {

    /**
     *
     */
    public int id;

    /**
     *
     */
    public int quant;

    /**
     *
     */
    public ProductIngredientsUpdate() {
        initComponents();
    }
    //constracor to get id and quantity from previous window

    /**
     *
     * @param id
     * @param quant
     */
    public ProductIngredientsUpdate(int id, int quant) {
        this.id=id;
        this.quant=quant;
        initComponents();
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

    //update ingredients quantty method
    private void answerYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerYesActionPerformed
        StorageServices storser= new StorageServices();
        if (storser.UpdateIngredients(id, quant)) {
            JOptionPane.showMessageDialog(null,"Updated");
        } else {
            JOptionPane.showMessageDialog(null,"Cannot update, not enough raw materials.","Error",  JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_answerYesActionPerformed

    private void answerNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerNoActionPerformed
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
