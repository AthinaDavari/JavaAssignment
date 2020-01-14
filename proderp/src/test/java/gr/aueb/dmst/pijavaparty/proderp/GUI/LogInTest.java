
package gr.aueb.dmst.pijavaparty.proderp.GUI;

import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import gr.aueb.dmst.pijavaparty.proderp.dao.UserDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.User;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;
import java.util.Locale;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author athina
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void atestMain() throws AWTException {
            System.out.println("main");
            new LogIn().setVisible(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            Window w[] = Window.getWindows();
            assertEquals(1, w.length);
            assertEquals("class gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn", w[0].getClass().toString());
            assertEquals(true, w[0].isVisible());
    }

    /**
     * Test of logInKeyPressed method, of class LogIn.
     * @throws java.awt.AWTException
     */
    @Test
    public void blogInKeyPressed() throws AWTException {
        System.out.println("logInKeyPressed");
        LogIn li = new LogIn();
        li.setVisible(true);
        Robot bot = new Robot();
        //close caps lock
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
        //make sure keyboard language is english
        for (;;){
        InputContext context = InputContext.getInstance();  
            System.err.println(context.getLocale().getLanguage());
        if (context.getLocale().getLanguage().equals("en")){
                break;
        }
        //press ALT + SHIFT
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.keyPress(KeyEvent.VK_ALT);
        bot.keyRelease(KeyEvent.VK_ALT);
        bot.keyRelease(KeyEvent.VK_SHIFT);
        bot.keyPress(KeyEvent.VK_ENTER);
                }
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
        assertEquals("class gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn", w[0].getClass().toString());
        assertEquals(false, w[0].isVisible());
        assertEquals("class gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn", w[1].getClass().toString());
        assertEquals(false, w[1].isVisible());
        assertEquals("class gr.aueb.dmst.pijavaparty.proderp.GUI.AdminMenu", w[2].getClass().toString());
        assertEquals(true, w[2].isVisible());
        User expResult = new User("athina", "ath", null, "admin");
        assertEquals(expResult, LogIn.getUser());
        assertEquals(expResult, new UserDao().getUserByUsername("ath"));

    }
}