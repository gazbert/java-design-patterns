package com.gazbert.patterns.behavioural.state;

/**
 * The State interface.  
 * <p>
 * The behaviour of these operations varies depending on what concrete State impl class is
 * currently executing.
 * 
 * <p>
 * @author gazbert
 *
 */
public interface BugState {
        
    /**
     * Update number of hours worked on bug in this state.
     */
    void updateHoursWorked(int hours);    
            
    /**
     * Get cost of the bug fix for this state.  
     */
    int getCost();
    
    /**
     * Sets the next State.
     */
    void setNextState();
}
