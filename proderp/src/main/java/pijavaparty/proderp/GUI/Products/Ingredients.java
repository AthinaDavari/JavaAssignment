
package pijavaparty.proderp.GUI.Products;

import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import pijavaparty.proderp.GUI.LogIn;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;

/**
 *
 * @author anna
 */
public class Ingredients extends javax.swing.JFrame {

    private int id;

    /**
     *
     * @param id
     */
    public Ingredients(int id) {
        this.id=id;
        initComponents();
        showIngredientsTable();
        seticon();
    }

    /**
     *
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    } 

    /**
     *
     */
    public Ingredients() {
        initComponents();
        showIngredientsTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ingredients_Table = new javax.swing.JTable();
        DeleteIngredient = new javax.swing.JButton();
        AddIngredient = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        LogOut = new javax.swing.JMenu();
        Back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ingredients:");

        Ingredients_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw_Material_Id", "Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Ingredients_Table);

        DeleteIngredient.setText("Delete");
        DeleteIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteIngredientActionPerformed(evt);
            }
        });

        AddIngredient.setText("Add");
        AddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIngredientActionPerformed(evt);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(AddIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(DeleteIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteIngredientActionPerformed
        new DeleteIngredients(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_DeleteIngredientActionPerformed

    private void AddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIngredientActionPerformed
        new AddIngredients(id).setVisible(true);
        dispose();
    }//GEN-LAST:event_AddIngredientActionPerformed

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        LogIn login = new LogIn();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogOutMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        ProductGui menu = new ProductGui();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMouseClicked
    //showing colums of product table in data base 

    /**
     *
     */
    public void showIngredientsTable(){
        ProductRawMaterialDao prodrawdao=new ProductRawMaterialDao();
        DefaultTableModel model=(DefaultTableModel) Ingredients_Table.getModel();
        int number=prodrawdao.getAll().size();
        Object[] row=new Object[3];
        for(int i=0; i<number; i++){
            if (prodrawdao.getAll().get(i).getProduct().getId()==id){
                row[0]=prodrawdao.getAll().get(i).getRawMaterial().getId();
                row[1]=prodrawdao.getAll().get(i).getRawMaterial().getName();
                row[2]=prodrawdao.getAll().get(i).getQuantityOfRawMaterial();
                model.addRow(row);
            }
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
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingredients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddIngredient;
    private javax.swing.JMenu Back;
    private javax.swing.JButton DeleteIngredient;
    private javax.swing.JTable Ingredients_Table;
    private javax.swing.JMenu LogOut;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
