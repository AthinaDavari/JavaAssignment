package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author athina
 */
public class RawMaterialDeleteTest {

    /**
     *
     */
    public RawMaterialDeleteTest() {
    }

    /**
     * Set up test class
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }

    @AfterClass
    public static void tearDownClass() {
        Window w[] = Window.getWindows();

        for (Window window : w) {
            window.dispose();
        }
    }

    /**
     * Test of deleteKeyPressed method, of class RawMaterialDelete.
     *
     * @throws AWTException
     */
    @Test
    public void deleteActionPerformed() throws AWTException {
        new RawMaterialDelete().setVisible(true);
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_6);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        bot.mouseMove(478, 400);
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
        bot.keyRelease(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        RawMaterialDao instance = new RawMaterialDao();
        assertEquals(false, instance.getAll().contains(instance.getById(6)));
    }
}
