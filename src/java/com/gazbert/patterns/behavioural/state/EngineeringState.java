package com.gazbert.patterns.behavioural.state;


/**
 * Bug is in Engineering...
 * 
 * @author gazbert
 *
 */
public class EngineeringState implements BugState {

    /** Cost per hour for Engineering work */
    private static final int HOURLY_RATE = 100;
    
    /** Reference to the state machine */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;
    
    /**
     * Constructor takes the state machine as an arg.
     * 
     * @param clockSetup
     */
    public EngineeringState(final BugTrackerContext bugTracker)
    {
	this.bugTracker = bugTracker;
	
	// init this object's internal state
	bugCost = 0;
    }
    
    public void updateHoursWorked(int hoursWorked) {
	
	bugCost += (hoursWorked * HOURLY_RATE);
    }
    
    public int getCost() {	
	
	return bugCost;	
    }

    @Override
    public void setNextState() {
	bugTracker.setState(bugTracker.getTestingState());	
    }
}
