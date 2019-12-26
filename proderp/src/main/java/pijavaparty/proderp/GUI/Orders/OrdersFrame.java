
package pijavaparty.proderp.GUI.Orders;

import java.awt.Toolkit;
import pijavaparty.proderp.GUI.LogIn;
import pijavaparty.proderp.GUI.Menu;

/**
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
     *
     */
    public void seticon() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo.jpg")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        Orders = new javax.swing.JPanel();
        ordersCust = new javax.swing.JButton();
        orderSup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        logOut = new javax.swing.JMenu();
        back = new javax.swing.JMenu();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orders Menu");
        setResizable(false);

        ordersCust.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordersCust.setText("Orders From Customers");
        ordersCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersCustActionPerformed(evt);
            }
        });

        orderSup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        orderSup.setText("Orders To Suppliers");
        orderSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSupActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText(" Orders Menu");

        javax.swing.GroupLayout OrdersLayout = new javax.swing.GroupLayout(Orders);
        Orders.setLayout(OrdersLayout);
        OrdersLayout.setHorizontalGroup(
            OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdersLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ordersCust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(orderSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(103, 103, 103))
        );
        OrdersLayout.setVerticalGroup(
            OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdersLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderSup, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordersCust, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
            .addComponent(Orders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderSupActionPerformed
        new OrdersFromSuppliers().setVisible(true);
    }//GEN-LAST:event_orderSupActionPerformed

    private void ordersCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersCustActionPerformed
        new OrdersFromCustomers().setVisible(true);
    }//GEN-LAST:event_ordersCustActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
       Menu menu = new Menu();
       menu.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_backMouseClicked

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        
        LogIn login = new LogIn();
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
    private javax.swing.JPanel Orders;
    private javax.swing.JMenu back;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JButton orderSup;
    private javax.swing.JButton ordersCust;
    // End of variables declaration//GEN-END:variables
}
