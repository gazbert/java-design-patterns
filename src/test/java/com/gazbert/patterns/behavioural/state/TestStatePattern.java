/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.patterns.behavioural.state;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Demonstrates use of State pattern.
 *
 * @author gazbert
 */
public class TestStatePattern {

    /**
     * Imagine this test is Bugzilla/JIRA and users log their time working on the bug.
     */
    @Test
    public void testStatePattern() {

        // TODO Switch to use BigDecimal for this stuff! ;-)
        int supportActualCostToDate = 0;
        int supportExpectedCostToDate = 0;

        // Create the state machine
        final BugTrackerContext bugTracker = new BugTrackerContext();

        // remember, initial state is Customer Support @ £80 per hour...
        supportExpectedCostToDate = 8 * 80;
        bugTracker.logHoursWorked(8);
        supportActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(supportExpectedCostToDate, supportActualCostToDate);

        // support do some more work
        supportExpectedCostToDate += 4 * 80;
        bugTracker.logHoursWorked(4);
        supportActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(supportExpectedCostToDate, supportActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // over to engineering - expensive! @ £100 per hour	
        int engineeringActualCostToDate = 0;
        int engineeringExpectedCostToDate = 0;

        engineeringExpectedCostToDate += 16 * 100;
        bugTracker.logHoursWorked(16);
        engineeringActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(engineeringExpectedCostToDate, engineeringActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // over to testing @ £90 per hour
        int testingActualCostToDate = 0;
        int testingExpectedCostToDate = 0;

        testingExpectedCostToDate += 24 * 90;
        bugTracker.logHoursWorked(24);
        testingActualCostToDate = bugTracker.getCostOfFixingBugForCurrentState();
        assertEquals(testingExpectedCostToDate, testingActualCostToDate);
        bugTracker.finishedWork(); //transition state

        // Manager runs her reports...
        assertEquals(supportExpectedCostToDate + engineeringExpectedCostToDate + testingExpectedCostToDate,
                bugTracker.getTotalCostOfFixingBug());
    }
}
