
package pijavaparty.proderp.GUI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.ref.WeakReference;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static pijavaparty.proderp.dao.TestUtilities.runTestScript;
import pijavaparty.proderp.dao.UserDao;
import pijavaparty.proderp.entity.User;

/**
 *
 * @author athina
 */
public class LogInTest {
    
    /**
     *
     */
    public LogInTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
//        JPanel myPanel = new JPanel();
//        System.out.println("Remove");
//        myPanel.removeAll();
        Window w[] = Window.getWindows();

        for (Window window : w){
            window.dispose();
//            window.setVisible(false);
        }
        
    }

    /**
     * Test of main method, of class LogIn.
     * @throws java.awt.AWTException
     */
    @Test
    public void testMain() throws AWTException {
            System.out.println("main");
            String[] args = null;
            LogIn.main(args);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            Window w[] = Window.getWindows();
            assertEquals(1, w.length);
            assertEquals("class pijavaparty.proderp.GUI.LogIn", w[0].getClass().toString());
            assertEquals(true, w[0].isVisible());
    }

    /**
     * Test of logInKeyPressed method, of class LogIn.
     * @throws java.awt.AWTException
     */
    @Test
    public void logInKeyPressed() throws AWTException {
        System.out.println("logInKeyPressed");
        LogIn li = new LogIn();
        li.setVisible(true);
        Robot bot = new Robot();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        bot.keyPress(KeyEvent.VK_A);
        bot.keyPress(KeyEvent.VK_T);
        bot.keyPress(KeyEvent.VK_H);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        bot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        bot.keyPress(KeyEvent.VK_A);
        bot.keyPress(KeyEvent.VK_S);
        bot.keyPress(KeyEvent.VK_D);
        bot.keyPress(KeyEvent.VK_F);
        bot.keyPress(KeyEvent.VK_G);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        } 
        bot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        bot.keyPress(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        Window w[] = Window.getWindows();
        System.out.println("window");
        for (Window window : w) {

            System.out.println(window);
        }
        assertEquals(3, w.length);
        assertEquals("class pijavaparty.proderp.GUI.LogIn", w[0].getClass().toString());
        assertEquals(false, w[0].isVisible());
        assertEquals("class pijavaparty.proderp.GUI.LogIn", w[1].getClass().toString());
        assertEquals(false, w[1].isVisible());
        assertEquals("class pijavaparty.proderp.GUI.AdminMenu", w[2].getClass().toString());
        assertEquals(true, w[2].isVisible());
        User expResult = new User("athina", "ath", null, "admin");
        assertEquals(expResult, LogIn.user);
        assertEquals(expResult, new UserDao().getUserByUsername("ath"));

    }
}