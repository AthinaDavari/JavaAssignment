
package gr.aueb.dmst.pijavaparty.proderp.GUI.products;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aggel
 */
public class DeleteIngredients extends javax.swing.JFrame {
    private int id;

    /**
     *
     */
    public DeleteIngredients() {
        initComponents();
        seticon();
        setTitle("Delete Ingredients");
    }

    /**
     *
     * @param id
     */
    public DeleteIngredients(int id) {
        this.id=id;
        initComponents();
        seticon();
        fillcombo();
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

        delete = new javax.swing.JButton();
        drop_down = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Select the Id you want to delete:");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 346, Short.MAX_VALUE)
                        .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(delete)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method that deletes an ingredient from the recipe of a specific product.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the delete button.
     */        
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String value1_id = drop_down.getSelectedItem().toString();
            String stringnamearray[];
            stringnamearray = value1_id.split("[^0-9]");
            String stringname="";
            for (String stringnamearray1 : stringnamearray) {
                value1_id = stringname + stringnamearray1;
            }
            int newvalue1_id=Integer.parseInt(value1_id);
            ProductRawMaterialDao prodrawdao=new ProductRawMaterialDao();
            prodrawdao.delete(id, newvalue1_id);
            JOptionPane.showMessageDialog(null,"Deleted");
            dispose();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Choose Id.","Error",  JOptionPane.ERROR_MESSAGE);
            EditProduct stor = new EditProduct();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * Returning to the ingredients main window.
     *
     * @param evt is a reference to a MouseEvent object that is sent to the
     * method by clicking the cancel button.
     */     
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        Ingredients  ingredients = new Ingredients();
        ingredients.setVisible(true);
        dispose();      
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Fill the drop down with all the ids of the ingredients that the specific product has in its
     * recipe.
     */    
    private void fillcombo() {
        ProductRawMaterialDao prodrawdao=new ProductRawMaterialDao();
        List<ProductRawMaterial> rawlist = prodrawdao.getMaterialsPerProduct(id);
        int number=rawlist.size();
        for(int i=0; i<number; i++){
                System.out.println(rawlist.get(i).getRawMaterial().getName());
                drop_down.addItem(rawlist.get(i).getRawMaterial().getId()+" - "+rawlist.get(i).getRawMaterial().getName());
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
            java.util.logging.Logger.getLogger(DeleteIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteIngredients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> drop_down;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
