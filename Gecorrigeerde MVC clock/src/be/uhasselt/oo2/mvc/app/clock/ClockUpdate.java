package be.uhasselt.oo2.mvc.app.clock;

/**
 * Represent a clock update including all necessary information.
 * @author jvermeulen
 */
public class ClockUpdate {
    private int mHour;
    private int mMinute;
    private int mSecond;
    private boolean mIsRunning; 
    
    
    ClockUpdate(int hour, int minute, int second, boolean isRunning) {
        mHour = hour;
        mMinute = minute;
        mSecond = second;
        mIsRunning = isRunning;
    }

    /**
     * @return the mHour
     */
    public int getHour() {
        return mHour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.mHour = hour;
    }

    /**
     * @return the mMinute
     */
    public int getMinute() {
        return mMinute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {
        this.mMinute = minute;
    }

    /**
     * @return the mSecond
     */
    public int getSecond() {
        return mSecond;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.mSecond = second;
    }

    /**
     * @return the mIsRunning
     */
    public boolean isRunning() {
        return mIsRunning;
    }

    /**
     * @param isRunning the isRunning to set
     */
    public void setRunning(boolean isRunning) {
        this.mIsRunning = isRunning;
    }
    
}
