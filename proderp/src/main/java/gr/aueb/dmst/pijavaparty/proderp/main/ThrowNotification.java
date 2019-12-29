package gr.aueb.dmst.pijavaparty.proderp.main;

import gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn;
import gr.aueb.dmst.pijavaparty.proderp.entity.Product;
import gr.aueb.dmst.pijavaparty.proderp.entity.RawMaterial;
import gr.aueb.dmst.pijavaparty.proderp.services.Checks;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


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
            if (LogIn.user != null) {
            showOptionPane();
            }
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThrowNotification.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     *
     */
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
