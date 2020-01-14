package gr.aueb.dmst.pijavaparty.proderp.GUI.products;

import gr.aueb.dmst.pijavaparty.proderp.dao.ProductDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.ProductRawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.ProductRawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.services.Fillcombo;
import static gr.aueb.dmst.pijavaparty.proderp.services.ValidVariables.isValidInteger;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aggel
 */
public class AddIngredients extends javax.swing.JFrame {

    private List<ProductRawMaterial> prodraw = new ArrayList();
    private int id;
    private Product prod = new Product();
    private int selected;

    /**
     * Set the icon that is shown on the frame.
     */
    public void seticon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    //multiple constructors 
    /**
     * Construcor if product doesnt exist
     *
     * @param name
     * @param price
     */
    public AddIngredients(String name, double price) {
        prod.setName(name);
        prod.setPrice(price);
        prod.setId(-1);
        initComponents();
        fillcombo();
        seticon();
        setTitle("Add Ingredients");
    }

    /**
     * Product exist
     *
     * @param id
     */
    public AddIngredients(int id) {
        ProductDao proddao2 = new ProductDao();
        this.id = id;
        prod = proddao2.getById(id);
        initComponents();
        fillcombo();
        seticon();
    }

    /**
     * Product doesnt exist but ingridients already have been chosen
     *
     * @param prodraw
     * @param obj5
     */
    public AddIngredients(List<ProductRawMaterial> prodraw, Product obj5) {
        this.prodraw = prodraw;

        this.prod = obj5;
        initComponents();
        fillcombo();
        seticon();
    }

    /**
     *
     */
    public AddIngredients() {
        initComponents();
        fillcombo();
        seticon();
    }

    /**
     * Set AddIngredients window
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        addMoreIngredients = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        value_quantity = new javax.swing.JTextField();
        drop_down = new javax.swing.JComboBox<>();
        valid_Quantity = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        addMoreIngredients.setText("Add More Ingredients");
        addMoreIngredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoreIngredientsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Add Ingredients:");

        jLabel2.setText("Name-Id:");

        jLabel3.setText("Quantity: ");

        value_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                value_quantityKeyReleased(evt);
            }
        });

        valid_Quantity.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        valid_Quantity.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGap(242, 242, 242)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(99, 99, 99))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(addMoreIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(170, 170, 170)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(value_quantity)
                                .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valid_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMoreIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method for adding ingredients but not save them in the data base yet.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the add more ingredients button.
     */
    private void addMoreIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoreIngredientsActionPerformed
        try {
            if (!isValidInteger(value_quantity.getText())) {
             JOptionPane.showMessageDialog(null, "Incorrect validations! Please try again!");
             return;
            }
                String value_name = drop_down.getSelectedItem().toString();
                String stringnamearray[];
                stringnamearray = value_name.split("[^0-9]");
                String stringname = "";
                StringBuilder sb = new StringBuilder();
                for (String stringnamearray1 : stringnamearray) {
                    sb.append(stringnamearray1);
                }
                stringname = sb.toString();
                selected = Integer.parseInt(stringname);
                int quant = Integer.parseInt(value_quantity.getText());
                RawMaterialDao rawdao = new RawMaterialDao();
                List<RawMaterial> rawmaterial;
                rawmaterial = rawdao.getAll();
                RawMaterial rawmat = null;
                int num = rawmaterial.size();
                int a;
                for (int i = 0; i < num; i++) {
                    a = rawmaterial.get(i).getId();
                    if (a == selected) {
                        rawmat = rawmaterial.get(i);
                        break;
                    }
                }
                ProductRawMaterial prodrawmat = new ProductRawMaterial(prod, rawmat, quant);
                prodraw.add(prodrawmat);
                new AddIngredients(prodraw, prod).setVisible(true);
                dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter Details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addMoreIngredientsActionPerformed

    /**
     * Add one more ingredient and then save this one and all of
     * the previous ones in the data base.
     *
     * @param evt is a reference to an ActionEvent object that is sent to the
     * method by clicking the add more ingredients button.
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (!isValidInteger(value_quantity.getText())) {
            JOptionPane.showMessageDialog(null, "Enter Details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            String value_name = drop_down.getSelectedItem().toString();
            String stringnamearray[];
            stringnamearray = value_name.split("[^0-9]");
            String stringname = "";
            StringBuilder sb = new StringBuilder();
            for (String stringnamearray1 : stringnamearray) {
                sb.append(stringnamearray1);
            }
            stringname = sb.toString();
            selected = Integer.parseInt(stringname);
            int quant = Integer.parseInt(value_quantity.getText());
            RawMaterialDao rawdao = new RawMaterialDao();
            List<RawMaterial> rawmaterial;
            rawmaterial = rawdao.getAll();
            RawMaterial rawmat = null;
            int num = rawmaterial.size();
            int a;
            for (int i = 0; i < num; i++) {
                a = rawmaterial.get(i).getId();
                if (a == selected) {
                    rawmat = rawmaterial.get(i);
                    break;
                }
            }
            ProductRawMaterial prodrawmat = new ProductRawMaterial(prod, rawmat, quant);
            ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
            prodraw.add(prodrawmat);
            ProductDao obj4 = new ProductDao();
            if (prod.getId() == -1) {
                obj4.insertProductAndProductsRecipe(prod, prodraw);
            } else {
                for (int i = 0; i < prodraw.size(); i++) {
                    prodrawdao.insert(prodraw.get(i));
                }
            }
            prodraw.clear();
            JOptionPane.showMessageDialog(null, "Added");
            ProductGui stor = new ProductGui();
            stor.setVisible(true);
            dispose();
         
    }//GEN-LAST:event_saveActionPerformed

/**
 * Returning to the ingredients window.
 *
 * @param evt is a reference to a MouseEvent object that is sent to the method
 * by clicking the cancel button.
 */
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        ProductGui rawmenu = new ProductGui();
        rawmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelMouseClicked

    /**
     * Check if the quantity input is valid and if it is invalid show a warning
     * message.
     *
     * @param evt is a reference to a KeyEvent object that is sent to the method
     * by typing a key in the keyboard.
     */
    private void value_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_value_quantityKeyReleased
        if (!isValidInteger(value_quantity.getText())) {
            valid_Quantity.setText("Quantity is invalid!");
        } else {
            valid_Quantity.setText(null);
        }
    }//GEN-LAST:event_value_quantityKeyReleased
    /**
     * Fill up the drop down with raw materials and ids from the data base.
     */
    private void fillcombo() {
        Fillcombo fill = new Fillcombo();
        ArrayList<String> combocontents = fill.fillcomboArray(prodraw, prod);
        int j = 0;
        for (int i = 0; i < combocontents.size(); i++) {
            drop_down.addItem(combocontents.get(i));
            j++;
        }
        //Disable AddMoreIngredients button if combo box has only one item
        if (j == 1) {
            disablebuttonAdd();
        }
    }

    //Disable AddMoreIngredients button
    private void disablebuttonAdd() {
        addMoreIngredients.setEnabled(false);
    }

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(AddIngredients.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddIngredients.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddIngredients().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMoreIngredients;
    private javax.swing.JMenu cancel;
    private javax.swing.JComboBox<String> drop_down;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton save;
    private javax.swing.JLabel valid_Quantity;
    private javax.swing.JTextField value_quantity;
    // End of variables declaration//GEN-END:variables
}
