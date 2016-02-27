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

/**
 * Bug is in Engineering...
 *
 * @author gazbert
 */
public class EngineeringState implements BugState {

    /**
     * Cost per hour for Engineering work
     */
    private static final int HOURLY_RATE = 100;

    /**
     * Reference to the context
     */
    private BugTrackerContext bugTracker;

    /**
     * Internal state of this object - Cost of the bug
     */
    private int bugCost;

    /**
     * Constructor takes the context as an arg.
     *
     * @param bugTracker the bug tracker
     */
    public EngineeringState(BugTrackerContext bugTracker) {
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
        bugTracker.setState(bugTracker.getTestingState()); // control which state we go to next	
    }
}
