package gr.aueb.dmst.pijavaparty.proderp.GUI.orders;

import gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu;
import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.GUI.SimpleMenu;
import java.awt.Toolkit;


/**
 * OrdersFrame.java - A graphical user interface (gui) class for showing the 
 * menu for orders, with the available options, Orders To Suppliers and Orders
 * From Customers.
 * 
 * @author MariaKokkorou
 */
public class OrdersFrame extends javax.swing.JFrame {

    /**
     * Creates new form OrdersFrame
     */
    public OrdersFrame() {
        initComponents();
        seticon();
    }

    /**
     *Set the icon that is shown on the frame. 
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    /**
     * Initialize the form of the window.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        οrders = new javax.swing.JPanel();
        ordersFromCustomers = new javax.swing.JButton();
        ordersToSuppliers = new javax.swing.JButton();
        ordersMenu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orders Menu");
        setResizable(false);

        ordersFromCustomers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordersFromCustomers.setText("Orders From Customers");
        ordersFromCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersFromCustomersActionPerformed(evt);
            }
        });

        ordersToSuppliers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordersToSuppliers.setText("Orders To Suppliers");
        ordersToSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersToSuppliersActionPerformed(evt);
            }
        });

        ordersMenu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ordersMenu.setText(" Orders Menu");

        javax.swing.GroupLayout οrdersLayout = new javax.swing.GroupLayout(οrders);
        οrders.setLayout(οrdersLayout);
        οrdersLayout.setHorizontalGroup(
            οrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(οrdersLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(οrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ordersMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(οrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ordersFromCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ordersToSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(103, 103, 103))
        );
        οrdersLayout.setVerticalGroup(
            οrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(οrdersLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ordersMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordersToSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordersFromCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        logOut.setForeground(new java.awt.Color(0, 0, 204));
        logOut.setText("Log Out");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);

        back.setForeground(new java.awt.Color(0, 0, 204));
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jMenuBar1.add(back);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(οrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(οrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Show the graphical user interface of OrdersFromSuppliers class, by
    * clicking on the Orders To Suppliers button. 
    * 
    * @param evt - an ActionEvent object generated automatically and sent 
    * to the method by clicking on Orders To Suppliers button.
    */   
    private void ordersToSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersToSuppliersActionPerformed
        new OrdersFromSuppliers().setVisible(true);
        dispose();
    }//GEN-LAST:event_ordersToSuppliersActionPerformed

    /**
    * Show the graphical user interface of OrdersFromCustomers class, by
    * clicking on the Orders From Customers button. 
    * 
    * @param evt - an ActionEvent object generated automatically and sent 
    * to the method by clicking on Orders From Customers button.
    */ 
    private void ordersFromCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersFromCustomersActionPerformed
        new OrdersFromCustomers().setVisible(true);
        dispose();
    }//GEN-LAST:event_ordersFromCustomersActionPerformed

    /**
     * Close the Orders Menu window - gui of OrdersFrame class, 
     * and return back to the main menu window - gui of Menu class,
     * by clicking on back button on the menu bar.
     * 
     * @param evt - an ActionEvent object generated automatically and sent 
     * to the method by clicking on back button on the menu bar.
     */
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
       if((LogIn.getUser().getRole()).equals("admin")){
            AdminMenu menu = new AdminMenu();
            menu.setVisible(true);
        } else {
            SimpleMenu menu = new SimpleMenu();
            menu.setVisible(true);
        }
        dispose();
       
    }//GEN-LAST:event_backMouseClicked

    /**
     * Close the Orders Menu window - gui of OrdersFrame class, 
     * and return back to the log in window - gui of LogIn class,
     * by clicking on back button on the menu bar.
     * 
     * @param evt - an ActionEvent object generated automatically and sent 
     * to the method by clicking on log out button on the menu bar.
     */
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        
        LogIn login = new LogIn();
        LogIn.setUser(null);
        login.setVisible(true);
        dispose(); 
        
    }//GEN-LAST:event_logOutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new OrdersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu back;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JButton ordersFromCustomers;
    private javax.swing.JLabel ordersMenu;
    private javax.swing.JButton ordersToSuppliers;
    private javax.swing.JPanel οrders;
    // End of variables declaration//GEN-END:variables
}
