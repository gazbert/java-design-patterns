package com.gazbert.patterns.behavioural.state;


/**
 * Bug is in Closed state/
 * 
 * @author gazbert
 *
 */
public class ClosedState implements BugState {

    /** Cost per hour for Closed bug it 0! */
    private static final int HOURLY_RATE = 0;
    
    /** Reference to the state machine */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;
    
    /**
     * Constructor takes the state machine as an arg.
     * 
     * @param clockSetup
     */
    public ClosedState(final BugTrackerContext bugTracker)
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
	
	// in reality, we'd re-open the bug if there was a problem
	throw new IllegalStateException("We've hit the end of road for this demo...");	
    }
}
