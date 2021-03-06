
package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.services.Checks;
import gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * RawMaterialDelete.java - A graphical user interface (gui) class responsible for 
 * deleting already existing raw materials.
 * @author aggel
 */
public class RawMaterialDelete extends javax.swing.JFrame {

    /**
     * Create new form RawMaterialDelete
     */
    public RawMaterialDelete() {
        initComponents();
        seticon();
        setTitle("Delete Raw Materials");
    }

    /**
     * Set the icon that is shown on the frame. 
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    /**
     * Set RawMaterialdelete window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delete = new javax.swing.JButton();
        value_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        validId = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteKeyPressed(evt);
            }
        });

        value_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_idKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Type the Id you want to delete:");

        validId.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGap(0, 385, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(474, 474, 474))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(364, 364, 364))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(validId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(value_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addComponent(delete)
                .addContainerGap(106, Short.MAX_VALUE))
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
     * Method that deletes a raw material
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the delete button.
     */    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            if (!ValidVariables.isValidInteger(value_id.getText())) {
                JOptionPane.showMessageDialog(null, "Incorrect id! Please try again!");
                return;
            }
            
            String value1_id=value_id.getText();
            int newvalue1_id=Integer.parseInt(value1_id);
            
            Checks check = new Checks();
            if (check.checkIfRawMaterialIsUsed(newvalue1_id)) {
                JOptionPane.showMessageDialog(null,"Cannot be deleted. Raw Material used in a product's recipe.","Error",  JOptionPane.ERROR_MESSAGE);
            } else {
                RawMaterialDao rawdao=new RawMaterialDao();
                rawdao.delete(newvalue1_id);
                JOptionPane.showMessageDialog(null,"Deleted");
                    new RawMaterialMenu().setVisible(true);
                    dispose();
            }
        }  catch (Exception e){
            JOptionPane.showMessageDialog(null,"Insert id or raw material doesn't exist.","Error",  JOptionPane.ERROR_MESSAGE);
            RawMaterialDelete stor = new RawMaterialDelete();
            stor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_deleteActionPerformed
    
    /**
     * 
     * @param evt is a reference to a KeyEvent object that is sent to the
     * method by pressing the Delete button.
     */
    private void deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteKeyPressed
            if (evt.getKeyCode() == evt.VK_ENTER) {
            delete.doClick();
        }
    }//GEN-LAST:event_deleteKeyPressed

    /**
     * Checks if id is valid
     * @param evt is a reference to a KeyEvent object that is sent to the method
     * by typing a key in the keyboard.
     */
    private void value_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_idKeyReleased
        if (!ValidVariables.isValidInteger(value_id.getText())) {
            validId.setText("Integer is invalid!");
        } else {
            validId.setText(null);
        }
    }//GEN-LAST:event_value_idKeyReleased
    
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
            java.util.logging.Logger.getLogger(RawMaterialDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RawMaterialDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RawMaterialDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RawMaterialDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RawMaterialDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cancel;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel validId;
    private javax.swing.JTextField value_id;
    // End of variables declaration//GEN-END:variables
}
