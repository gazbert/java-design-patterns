package com.gazbert.patterns.behavioural.state;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Demonstrates use of State pattern.
 * 
 * @author gazbert
 *
 */
public class TestStatePattern 
{
    /**
     * Imagine this test is Bugzilla/JIRA and users log their time working on the bug.
     */
    @Test
    public void testStatePattern() {

        int supportActualCostToDate = 0;
        int supportExpectedCostToDate = 0;

        // Create the state machine
        final BugTrackerContext bugTracker = new BugTrackerContext();	

        // remember, initial state is Customer Support @ £80 per hour...
        supportExpectedCostToDate = 8*80;
        bugTracker.logHoursWorked(8);
        supportActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(supportExpectedCostToDate, supportActualCostToDate);

        // support do some more work
        supportExpectedCostToDate += 4*80;
        bugTracker.logHoursWorked(4);
        supportActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(supportExpectedCostToDate, supportActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // over to engineering - expensive! @ £100 per hour	
        int engineeringActualCostToDate = 0;
        int engineeringExpectedCostToDate = 0;

        engineeringExpectedCostToDate += 16*100;
        bugTracker.logHoursWorked(16);
        engineeringActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(engineeringExpectedCostToDate, engineeringActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // over to testing @ £90 per hour
        int testingActualCostToDate = 0;
        int testingExpectedCostToDate = 0;

        testingExpectedCostToDate += 24*90;
        bugTracker.logHoursWorked(24);
        testingActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(testingExpectedCostToDate, testingActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // Manager runs her reports...
        assertEquals(supportExpectedCostToDate + engineeringExpectedCostToDate + testingExpectedCostToDate,
                bugTracker.getTotalCostOfFixingBug());	
    }
}
