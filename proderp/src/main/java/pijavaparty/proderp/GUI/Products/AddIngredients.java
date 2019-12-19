
package pijavaparty.proderp.GUI.Products;

import java.awt.Toolkit;
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
    
    private List<ProductRawMaterial> prodraw=new LinkedList();
    private int id;
    private Product prod=new Product();
    private int selected;
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }

    //multiple constructors 
    //construcor if product doesnt exist
    public AddIngredients(String name, double price) {
        prod.setName(name);
        prod.setPrice(price);
        prod.setId(-1);
        initComponents();
        fillcombo();
        seticon();
    }
    //product exist
    public AddIngredients(int id) {
        ProductDao proddao2 = new ProductDao();
        this.id = id;
        prod = proddao2.getById(id);
        initComponents();
        fillcombo();
        seticon();
    }
       //product doesnt exist but ingridients already have been chosen
    public AddIngredients(List<ProductRawMaterial> prodraw, Product obj5) {
        this.prodraw = prodraw;
        
        this.prod = obj5;
        initComponents();
        fillcombo();
        seticon();
    }

    public AddIngredients() {
        initComponents();
        fillcombo();
        seticon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Save = new javax.swing.JButton();
        AddMoreIngredients = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        value_quantity = new javax.swing.JTextField();
        drop_down = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cancel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        AddMoreIngredients.setText("Add More Ingredients");
        AddMoreIngredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMoreIngredientsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Add Ingredients:");

        jLabel2.setText("Name-Id:");

        jLabel3.setText("Quantity: ");

        Cancel.setForeground(new java.awt.Color(51, 51, 255));
        Cancel.setText("Cancel");
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        jMenuBar1.add(Cancel);

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
                                    .addComponent(AddMoreIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(170, 170, 170)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(value_quantity)
                                .addComponent(drop_down, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addContainerGap(227, Short.MAX_VALUE))
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
                    .addComponent(value_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddMoreIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //method for add ingredients but not save
    private void AddMoreIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMoreIngredientsActionPerformed
        try {
            String value_name = drop_down.getSelectedItem().toString();
            String stringnamearray[];
            stringnamearray = value_name.split("[^0-9]");
            String stringname="";
            for (String stringnamearray1 : stringnamearray) {
                stringname = stringname + stringnamearray1;
            }
            selected=Integer.parseInt(stringname);
            int quant = Integer.parseInt(value_quantity.getText());
            RawMaterialDao rawdao = new RawMaterialDao();
            List<RawMaterial> rawmaterial;
            rawmaterial = rawdao.getAll();
            RawMaterial rawmat = null;
            int num = rawmaterial.size();
            int a;
            for (int i = 0; i < num; i++) {
                a = rawmaterial.get(i).getId();
                if (a==selected) {
                    rawmat = rawmaterial.get(i);
                    break;
                }
            }
            String value4_quantity = value_quantity.getText();
            ProductRawMaterial prodrawmat = new ProductRawMaterial(prod, rawmat, quant);
            prodraw.add(prodrawmat);
            new AddIngredients(prodraw, prod).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Enter Details.","Error",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddMoreIngredientsActionPerformed
    //method for adding one more ingredient and then save
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try {
            String value_name = drop_down.getSelectedItem().toString();
            String stringnamearray[];
            stringnamearray = value_name.split("[^0-9]");
            String stringname="";
            for (String stringnamearray1 : stringnamearray) {
                stringname = stringname + stringnamearray1;
            }
            selected=Integer.parseInt(stringname);
            int quant = Integer.parseInt(value_quantity.getText());
            RawMaterialDao rawdao = new RawMaterialDao();
            List<RawMaterial> rawmaterial;
            rawmaterial = rawdao.getAll();
            RawMaterial rawmat = null;
            int num = rawmaterial.size();
            int a;
            for (int i = 0; i < num; i++) {
                a = rawmaterial.get(i).getId();
                if (a==selected) {
                    rawmat = rawmaterial.get(i);
                    break;
                }
            }
            ProductRawMaterial prodrawmat = new ProductRawMaterial(prod, rawmat, quant);
            ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
            prodraw.add(prodrawmat);
            ProductDao obj4 = new ProductDao();
            if (prod.getId() == -1) {
                ProductDao proddao = new ProductDao();
                obj4.insertProductAndProductsRecipe(prod, prodraw);
            }else {
                for(int i=0;i<prodraw.size();i++) {
                    prodrawdao.insert(prodraw.get(i));
                }
            }
            prodraw.clear();
            JOptionPane.showMessageDialog(null, "Added");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Enter Details.","Error",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        ProductGui rawmenu = new ProductGui();
        rawmenu.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_CancelMouseClicked
    //fill up the drop down with raw materials and ids from the data base
    private void fillcombo() {
        RawMaterialDao rawdao = new RawMaterialDao();
        List<RawMaterial> raw_material;
        raw_material = rawdao.getAll();
        List<ProductRawMaterial> prodrawlist;
        ProductRawMaterialDao prodrawdao = new ProductRawMaterialDao();
        prodrawlist = prodrawdao.getMaterialsPerProduct(prod.getId());
        int num;
        num = raw_material.size();
        try {
            int j;
            int i;
            int m;
            for (i = 0; i < num; i++) {
                for (j = 0; j < prodrawlist.size(); j++) {
                    if (raw_material.get(i).getId()==prodrawlist.get(j).getRawMaterial().getId()) {
                        break;
                    }
                }
                for (m = 0; m < prodraw.size(); m++) {
                    if (raw_material.get(i).getId()==prodraw.get(m).getRawMaterial().getId()) {
                        break;
                    }
                }
                if (j==prodrawlist.size() && m==prodraw.size()) { 
                    drop_down.addItem(raw_material.get(i).getName()+" - "+raw_material.get(i).getId());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

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
        java.awt.EventQueue.invokeLater(() -> {
            new AddIngredients().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMoreIngredients;
    private javax.swing.JMenu Cancel;
    private javax.swing.JButton Save;
    private javax.swing.JComboBox<String> drop_down;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField value_quantity;
    // End of variables declaration//GEN-END:variables
}
