package com.gazbert.patterns.behavioural.state;


/**
 * Bug is in integration Testing team...
 * 
 * @author gazbert
 *
 */
public class TestingState implements BugState {

    /** Cost per hour for Testing team work */
    private static final int HOURLY_RATE = 90;
    
    /** Reference to the state machine */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;
    
    /**
     * Constructor takes the state machine as an arg.
     * 
     * @param clockSetup
     */
    public TestingState(final BugTrackerContext bugTracker)
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
	bugTracker.setState(bugTracker.getEngineeringState());	
    }
}
