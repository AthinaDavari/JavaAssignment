package gr.aueb.dmst.pijavaparty.proderp.GUI.rawmaterials;

import gr.aueb.dmst.pijavaparty.proderp.dao.RawMaterialDao;
import static gr.aueb.dmst.pijavaparty.proderp.dao.TestUtilities.runTestScript;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
     *
     */
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }
  
    /**
     *
     * @throws AWTException
     */
    @Test
    public void deleteActionPerformed() throws AWTException{
        new RawMaterialDelete().setVisible(true);
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_6); 
        try{Thread.sleep(500);}catch(InterruptedException e){}
        bot.mouseMove(478,400);
        try{Thread.sleep(500);}catch(InterruptedException e){}
        // first click
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // second click
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(500);}catch(InterruptedException e){}
        RawMaterialDao instance = new RawMaterialDao();
        assertEquals(false, instance.getAll().contains(instance.getById(6)));
    }
}
