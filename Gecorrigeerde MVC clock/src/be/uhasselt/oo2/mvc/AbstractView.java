package be.uhasselt.oo2.mvc;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author jvermeulen
 */
public abstract class AbstractView implements View, Observer {

    private Observable mModel;
    private Controller mController;
    
    /**
     * Empty constructor so that the model and controller can be set later.
     */
    public AbstractView() {        
    }
    
    public AbstractView(Observable model, Controller controller) {
        // Set the model.
        setModel(model);
        // If a controller was supplied, use it. Otherwise let the first call to 
        // getController() create the default controller.
        if (controller != null) {
            setController(controller);
        }
    }
    
    @Override
    public void setController(Controller controller) {
        mController = controller;
        // Tell the controller this object is its view.
        mController.setView(this);
    }

    @Override
    public Controller getController() {
       
        return mController;
    }

    @Override
    public void setModel(Observable model) {
        mModel = model;
    }

    @Override
    public Observable getModel() {
        return mModel;
    }

    
    /**
     * A do-nothing implementation of the Observer interface's update method.
     * Subclasses of AbstractView will provide a concrete implementation for 
     * this method.
     */
    @Override
    public void update(Observable o, Object arg) {    
    }
    
}
