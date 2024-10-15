package be.uhasselt.oo2.mvc.app.clock;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.ZoneId;
import java.util.TimeZone;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * Main user interface for the application. Makes sure the model, views and
 * controllers are connected to each other.
 * @author jvermeulen
 */
public class Clock {
    // The clock data (i.e., the Model).
    private ClockModel mModel;
    
    // A digital view of the clock.
    private ClockDigitalView mDigitalView;
    
    // A toolbar for controlling the clock.
    private ClockTools mTools;
    
    // An analog view of the clock.
    private final ClockAnalogView mAnalogView;

    // A analog view of the clock for NEW YORK
    private final ClockAnalogView mAnalogViewNY;


    public Clock(int hour, int minute, int second) {
        // Create the data model.
        mModel = new ClockModel();

        ClockController c = new ClockController(mModel,ZoneId.of("EST"));

        // Create the digital clock view.
        mDigitalView = new ClockDigitalView(mModel, c);
        mModel.addObserver(mDigitalView);

        // Create the analog clock view.
        mAnalogView = new ClockAnalogView(mModel, null);
        mModel.addObserver(mAnalogView);

        // Create the analog clock view for NEW YORK

        mAnalogViewNY = new ClockAnalogView(mModel, null);

        mAnalogView.setTimeZone(NY);

        mModel.addObserver(mAnalogViewNY);
        
        // Create the clock tools view.
        mTools = new ClockTools(mModel, c);
        mModel.addObserver(mTools);
        
        // Set the time.
        mModel.setTime(hour, minute, second);

        // Start the clock ticking.
        mModel.start();
    }
    
    public void createGUI() {
        JFrame frame = new JFrame("Clock");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(mDigitalView.getUI());
        frame.getContentPane().add(mAnalogView);
        frame.getContentPane().add(mAnalogViewNY);
        frame.getContentPane().add(mTools.getUI());                
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void createAndShowGUI() {
        Clock clock = new Clock(9, 10, 22);
        clock.createGUI();
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
