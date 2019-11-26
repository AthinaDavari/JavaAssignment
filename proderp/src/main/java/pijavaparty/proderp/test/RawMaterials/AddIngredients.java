/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.test.RawMaterials;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import pijavaparty.proderp.dao.ProductDao;
import pijavaparty.proderp.dao.ProductRawMaterialDao;
import pijavaparty.proderp.dao.RawMaterialDao;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.ProductRawMaterial;
import pijavaparty.proderp.entity.RawMaterial;

/**
 *
 * @author aggel
 */
public class AddIngredients extends javax.swing.JFrame {

    /**
     * Creates new form AddIngredients
     */
    //private List<ProductRawMaterial> prpdrm;
    private List<ProductRawMaterial> prodraw;
    private int id;
    private Product obj5;

    //private List<Ingredients> ingredients=new LinkedList();
    //private List<int> quantity=new LinkedList();
    public AddIngredients(String name, double price) {
        obj5.setName(name);
        obj5.setPrice(price);
        obj5.setId(-1);
        initComponents();
        fillcombo();

    }

    public AddIngredients(int id) {
        int i;
        ProductRawMaterialDao obj = new ProductRawMaterialDao();
        ProductDao obj2 = new ProductDao();
        this.id = id;
        prodraw = obj.getMaterialsPerProduct(id);
        for (i = 1; i < obj.getAll().size(); i++) {
            if (id == obj2.getAll().get(i).getId()) {
                obj5 = obj2.getAll().get(i);
                break;
            }
        }
        initComponents();
        fillcombo();
    }

    public AddIngredients(List<ProductRawMaterial> prodraw, Product obj5) {
        this.prodraw = prodraw;
        this.obj5 = obj5;
        initComponents();
        fillcombo();
    }

    public AddIngredients() {
        initComponents();
        fillcombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        value_quantity = new javax.swing.JTextField();
        drop_down = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add More Ingredients");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Add Ingredients:");

        jLabel2.setText("Name:");

        jLabel3.setText("Quantity: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(223, 223, 223))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(170, 170, 170)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(value_quantity)
                                .addComponent(drop_down, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(124, 124, 124)))
                    .addComponent(jLabel3)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String value_name = drop_down.getSelectedItem().toString();
        int quant = Integer.parseInt(value_quantity.getText());
        RawMaterialDao obj = new RawMaterialDao();
        List<RawMaterial> rawmaterial = new LinkedList();
        rawmaterial = obj.getAll();
        RawMaterial obj2 = null;
        int num = rawmaterial.size();
        for (int i = 0; i < num; i++) {
            if (rawmaterial.get(i).getName().equals(value_name)) {
                obj2 = rawmaterial.get(i);
                break;
            }
        }
        String value4_quantity = value_quantity.getText();
        ProductRawMaterial obj3 = new ProductRawMaterial(obj5, obj2, quant);
        prodraw.add(obj3);
        new AddIngredients(prodraw, obj5).setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String value_name = drop_down.getSelectedItem().toString();
        int quant = Integer.parseInt(value_quantity.getText());
        RawMaterialDao obj = new RawMaterialDao();
        List<RawMaterial> rawmaterial = new LinkedList();
        rawmaterial = obj.getAll();
        RawMaterial obj2 = null;
        int num = rawmaterial.size();
        for (int i = 0; i < num; i++) {
            if (rawmaterial.get(i).getName().equals(value_name)) {
                obj2 = rawmaterial.get(i);
                break;
            }
        }
        ProductRawMaterial obj3 = new ProductRawMaterial(obj5, obj2, quant);
        prodraw.add(obj3);
        ProductDao obj4 = new ProductDao();
        if (obj5.getId() == -1) {
            ProductDao proddao = new ProductDao();
            proddao.insert(obj5);
            for (int i = 0; i < prodraw.size(); i++) {
                prodraw.get(i).getProduct().setId(proddao.bringLastId());
            }
        }
        obj4.insertProductAndProductsRecipe(obj5, prodraw);
        JOptionPane.showMessageDialog(null, "Added");
        dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    private void fillcombo() {
        RawMaterialDao obj = new RawMaterialDao();
        List<RawMaterial> raw_material = new LinkedList();
        raw_material = obj.getAll();
        int num = obj.getAll().size();
        try {
            for (int i = 0; i < num; i++) {

                drop_down.addItem(raw_material.get(i).getName());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            java.util.logging.Logger.getLogger(AddIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddIngredients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> drop_down;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField value_quantity;
    // End of variables declaration//GEN-END:variables
}
