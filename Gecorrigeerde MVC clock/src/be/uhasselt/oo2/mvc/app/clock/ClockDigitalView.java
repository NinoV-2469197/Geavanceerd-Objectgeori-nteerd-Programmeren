package be.uhasselt.oo2.mvc.app.clock;

import be.uhasselt.oo2.mvc.AbstractView;
import be.uhasselt.oo2.mvc.Controller;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * A digital clock View for the ClockModel. This View has no user inputs, so no 
 * Controller is required.
 * @author jvermeulen
 */
public class ClockDigitalView extends AbstractView {
    
    // The user interface for this view.
    private JTextField mClock;
    
    public ClockDigitalView(Observable model, Controller controller) {
        super(model, controller);
        init();
    }
    
    /**
     * Initializes the user interface.
     */
    private void init() {
        mClock = new JTextField();
        mClock.addFocusListener((ClockController)getController());
        mClock.addKeyListener((ClockController)getController());
    }
    
  
   
        
    /**
     * Updates the state of the on-screen digital clock.
     * Invoked automatically by ClockModel.
     * @param o The ClockModel object that is broadcasting an update
     * @param info A ClockUpdate instance describing the changes that have 
     * occurred in the ClockModel
     */
    @Override
    public void update(Observable o, Object info) {    
        // Cast info to ClockUpdate type.
        ClockUpdate clockInfo = (ClockUpdate) info;
        
        // Create a String representing the time.        
        String timeString = formatTime(clockInfo);

        // Display the new time in the clock text field.
        mClock.setText(timeString);

        // Fade the color of the display if the clock isn't running.
        if (clockInfo.isRunning()) {
          mClock.setBackground(Color.white);
        } else {
          mClock.setBackground(Color.gray);
        }
    }
    
    /**
     * Convenience method to return the user interface component. We don't need 
     * this if we implement View directly and directly subclass a GUI component.
     * @return the JComponent representing this View.
     */
    public JComponent getUI() {
        return mClock;
    }
    
    private String formatTime(ClockUpdate info) {
        return String.format("%d:%d:%d", 
                             info.getHour(), 
                             info.getMinute(), 
                             info.getSecond());
    }        
    
}
