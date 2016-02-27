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
 * The context for a *very* simple bug tracker.  The example shows how the State pattern can be used for keeping
 * tabs on the cost of the work being done to fix the bug as it travels through the various departments.
 * <p>
 * All the different states are listed here.
 * <p>
 * This class controls the state transitions and always 'knows' the current state.
 *
 * @author gazbert
 */
public class BugTrackerContext {

    /**
     * Initial state
     */
    private BugState customerSupportState;

    /**
     * Another state...
     */
    private BugState engineeringState;

    /**
     * Another state...
     */
    private BugState testingState;

    /**
     * Terminal state.
     */
    private BugState closedState;


    /**
     * The current state
     */
    private BugState currentState;


    /**
     * Constructor initialises the state context.
     * <p>
     * It creates all the state objects and passes the context into each one.
     * <p>
     * It sets the initial state.
     */
    public BugTrackerContext() {
        customerSupportState = new CustomerSupportState(this);
        engineeringState = new EngineeringState(this);
        testingState = new TestingState(this);
        closedState = new ClosedState(this);

        // Set initial state
        currentState = customerSupportState;
    }

    public void setState(BugState state) {
        currentState = state;
    }

    /////////////// State Accessors //////////////////

    public BugState getEngineeringState() {
        return engineeringState;
    }

    public BugState getTestingState() {
        return testingState;
    }

    public BugState getCustomerSupportState() {
        return customerSupportState;
    }

    public BugState getClosedState() {
        return closedState;
    }

    /////////////// Business Methods //////////////////

    /**
     * Users log their hours on the bug.
     *
     * @param hours hours logged on bug
     */
    public void logHoursWorked(int hours) {
        currentState.updateHoursWorked(hours);
    }

    /**
     * Users notify system they have finished working on bug.
     */
    public void finishedWork() {
        currentState.setNextState();
    }

    /**
     * Managers want to know cost of bug fix in current state.
     *
     * @return current state cost
     */
    public int getCostOfFixingBugForCurrentState() {
        return currentState.getCost();
    }

    /**
     * Managers want to know total cost of bug fix
     *
     * @return total cost of fix.
     */
    public int getTotalCostOfFixingBug() {
        return customerSupportState.getCost()
                + engineeringState.getCost()
                + testingState.getCost()
                + closedState.getCost();
    }
}
