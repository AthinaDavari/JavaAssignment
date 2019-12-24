
package pijavaparty.proderp.GUI.RawMaterials;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pijavaparty.proderp.dao.RawMaterialDao;
import static pijavaparty.proderp.dao.TestUtilities.runTestScript;

/**
 *
 * @author athina
 */
public class RawMaterialDeleteTest {
    
    public RawMaterialDeleteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        runTestScript();
    }
  
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
