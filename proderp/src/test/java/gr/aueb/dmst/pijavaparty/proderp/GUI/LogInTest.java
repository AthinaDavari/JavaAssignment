package gr.aueb.dmst.pijavaparty.proderp.GUI;

import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import gr.aueb.dmst.pijavaparty.proderp.dao.UserDao;
import gr.aueb.dmst.pijavaparty.proderp.entity.User;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
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
     * An empty constructor.
     */
    public LogInTest() {
    }

    /**
     * Set up test class
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }

    /**
     * Tear down after each method
     */
    @After
    public void tearDown() {

        Window w[] = Window.getWindows();

        for (Window window : w) {
            window.dispose();
//            window.setVisible(false);
        }

    }

    /**
     * Test of main method, of class LogIn.
     *
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
        //check windows in memory
        Window w[] = Window.getWindows();
        assertEquals(1, w.length);
        assertEquals("class gr.aueb.dmst.pijavaparty.proderp.GUI.LogIn", w[0].getClass().toString());
        assertEquals(true, w[0].isVisible());
    }

    /**
     * Test of logInKeyPressed method, of class LogIn.
     *
     * @throws java.awt.AWTException
     */
    @Test
    public void blogInKeyPressed() throws AWTException {
        System.out.println("logInKeyPressed");
        LogIn li = new LogIn();
        Robot bot = new Robot();
        //close caps lock
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
        li.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        //write ath in username jtextfield
        bot.keyPress(KeyEvent.VK_A);
        bot.keyPress(KeyEvent.VK_T);
        bot.keyPress(KeyEvent.VK_H);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        //go to password jtextfield
        bot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        //write asdfg in password jtextfield
        bot.keyPress(KeyEvent.VK_A);
        bot.keyPress(KeyEvent.VK_S);
        bot.keyPress(KeyEvent.VK_D);
        bot.keyPress(KeyEvent.VK_F);
        bot.keyPress(KeyEvent.VK_G);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        //go to logIn jbutton
        bot.keyPress(KeyEvent.VK_TAB);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        //press logIn jbutton
        bot.keyPress(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        Window w[] = Window.getWindows();
        
        //check windows in memory
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
