package com.gazbert.patterns.behavioural.state;


/**
 * Bug is in Closed state. This is the terminal state for purposes of demo.
 * <p>
 * In reality, we could re-open a bug and send it back to Engineering - we'd do this
 * in the setNextState() like before.
 * 
 * @author gazbert
 *
 */
public class ClosedState implements BugState {
    
    /** Reference to the context */
    private BugTrackerContext bugTracker;

    /** Internal state of this object - Cost of the bug */
    private int bugCost;
    
    /**
     * Constructor takes the context as an arg.
     * 
     * @param bugTracker
     */
    public ClosedState(final BugTrackerContext bugTracker)
    {
	this.bugTracker = bugTracker;
	
	// init this object's internal state
	bugCost = 0;
    }
    
    public void updateHoursWorked(int hoursWorked) {
	
	// does nothing, as bug closed and nobody working on it
    }
    
    public int getCost() {	
	
	return bugCost;	
    }

    @Override
    public void setNextState() {
	
	throw new IllegalStateException("We've hit the end of road for this demo...");	
    }
}
