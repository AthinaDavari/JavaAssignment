/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.main;

import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pijavaparty.proderp.GUI.LogIn;
import pijavaparty.proderp.Services.Checks;
import pijavaparty.proderp.entity.Product;
import pijavaparty.proderp.entity.RawMaterial;

/**
 *
 * @author Natalia
 */
public class ThrowNotification implements Runnable {

    @Override
    public void run() {
        Window[] windows;
        int count = 0;
        for (;;) {
            windows = Window.getWindows();
            boolean foundActive = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThrowNotification.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Window w : windows) {
                System.out.println(w.isVisible());
                if (w.isVisible()|| count == 0) {
                    ++count;
                    foundActive = true;
                    break;
                }
            }
            System.out.println("Found active " + foundActive);
            if (!foundActive) {
                System.exit(0);
            }
            showOptionPane();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThrowNotification.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void showOptionPane() {
        Checks checks = new Checks();
            if (LogIn.user != null) {
                List<RawMaterial> raws = checks.checkRawQuantities();
                List<Product> products = checks.checkProductQuantities();
                StringBuilder sb = new StringBuilder();
                if (!raws.isEmpty()) {
                    sb.append("Low Quantity for RawMaterials: " + "\n");
                    for (RawMaterial r : raws) {
                        sb.append(r.getId() + " " + r.getName() + "\n");
                    }
                    sb.append("----------------------------------------\n");
                }
                if (!products.isEmpty()) {
                    sb.append("Low Quantity for Products: " + "\n");
                    for (Product p : products) {
                        sb.append(p.getId() + " " + p.getName() + "\n");
                    }
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Alert", JOptionPane.INFORMATION_MESSAGE);

            }
        
    }

}
