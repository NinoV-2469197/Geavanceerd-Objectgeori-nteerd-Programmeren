package be.uhasselt.oo2.mvc.app.clock;

import be.uhasselt.oo2.mvc.AbstractController;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Observable;

/**
 * A clock controller that allows the clock to be started, stopped and reset.
 * @author jvermeulen
 */
public class ClockController extends AbstractController implements FocusListener, KeyListener{
    private ZoneId zoneId;
    public ClockController(Observable model, ZoneId zoneId) {
        super(model);
        this.zoneId = zoneId;
    }
    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
    
    public void onStart() {
        ((ClockModel)getModel()).start();
    }
    
    public void onStop() {
        ((ClockModel)getModel()).stop();
    }
    
    public void onReset() {
        ((ClockModel)getModel()).setTime(0,0,0);
    }
    public void onSetCurrentTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(this.zoneId);

        ((ClockModel)getModel()).setTime(
                zonedDateTime.getHour(),
                zonedDateTime.getMinute(),
                zonedDateTime.getSecond()
        );
    }


    public void focusGained(FocusEvent e){
        ((ClockModel)getModel()).stop();
    }
    
    public void focusLost(FocusEvent e){ 
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() ==KeyEvent.VK_ENTER){
           
            ((ClockModel)getModel()).setTime(10, 0, 0);
            ((ClockModel)getModel()).start();
        }
    }

public void
keyReleased(KeyEvent e){}

public void
keyTyped(KeyEvent e){}
}
