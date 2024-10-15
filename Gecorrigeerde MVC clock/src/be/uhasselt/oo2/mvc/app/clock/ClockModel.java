package be.uhasselt.oo2.mvc.app.clock;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

/**
 *
 * @author jvermeulen
 */
public class ClockModel extends Observable {
    private int mHour;
    private int mMinute;
    private int mSecond;
    
    private final long mTickInterval = 1000; // tick every second
    private Timer mTimer;
    private boolean mIsRunning;
    
    public ClockModel() {
        // By default, set the clock time to the current system time.
        Calendar now = new GregorianCalendar();        
        setTime(now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), 
                now.get(Calendar.SECOND));        
    }
    
    /**
     * Helper class to run the tick() method multiple times 
     * (e.g., every 1 second).
     */
    class TickTask extends TimerTask {
        public void run() {
            tick();
        }
    }
    
    public void start() {
        if (!mIsRunning) {
            mIsRunning = true;

            // Schedule the tick() method to run every mTickInterval milliseconds.
            mTimer = new Timer();
            mTimer.schedule(new TickTask(), 0, mTickInterval); 
            
            ClockUpdate info = new ClockUpdate(mHour, mMinute, mSecond, 
                                               mIsRunning);
            setChanged();
            notifyObservers(info);
        }
    }
    
    public void stop() {
        if (mIsRunning) {
            mIsRunning = false;
            
            // Stop the timer.
            mTimer.cancel();
            mTimer = null;
            
            ClockUpdate info = new ClockUpdate(mHour, mMinute, mSecond, 
                                               mIsRunning);
            setChanged();
            notifyObservers(info);
        }
    }
    
    /**
     * Sets the current time. Notifies observers of any change in time.
     * @param hour The new hour.
     * @param minute The new minute
     * @param second The new second
     */
    public void setTime(int hour, int minute, int second) {
        if (hour != mHour && isValidHour(hour)) {
            mHour = hour;
            setChanged();
        }
        
        if (minute != mMinute && isValidMinute(minute)) {
            mMinute = minute;
            setChanged();
        }
                
        if (second != mSecond && isValidSecond(second)) {
            mSecond = second;
            setChanged();
        }
        
        // If the model has changed, notify Views.
        if (hasChanged()) {
            ClockUpdate info = new ClockUpdate(mHour, mMinute, mSecond, 
                                               mIsRunning);
            notifyObservers(info);
        }
    }    
    
    /**
     * Checks to see if a number is a valid hour (i.e. in [0,23]).
     * @param hour The hour to check
     * @return True if this is a valid hour
     */
    private boolean isValidHour(int hour) {
        return (hour >= 0 && hour <= 23);
    }
    
    /**
     * Checks to see if a number is a valid minute (i.e. in [0,59]).
     * @param minute The minute to check
     * @return True if this is a valid minute
     */
    private boolean isValidMinute(int minute) {
        return (minute >= 0 && minute <= 59);
    }
    
    /**
     * Checks to see if a number is a valid minute (i.e. in [0,59]).
     * @param second The second to check
     * @return True if this is a valid second
     */
    private boolean isValidSecond(int second) {
        return (second >= 0 && second <= 59);
    }
    
    private void tick() {
        // Get the current time
        int h = mHour;
        int m = mMinute;
        int s = mSecond;
        
        // Increment the current second, adjusting the minute and hour 
        // if necessary.
        s += 1;
        if (s > 59) {
            s = 0;
            m += 1;
            if (m > 59) {
                m = 0;
                h += 1;
                if (h > 23) {
                    h = 0;
                }
            }
        }

        // Set the new time.
        setTime(h, m, s);
    }
}
