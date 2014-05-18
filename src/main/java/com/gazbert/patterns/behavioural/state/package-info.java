/**
 * <h2>State</h2>
 * 
 * Allows an object (behind an interface) to alter its behaviour when its internal state changes.
 * <p>
 * A State interface/abstract class defines the operations that each concrete state implementation class must do.
 * <p>
 * A StateImpl does the business logic. It is built by the Context and has a reference to it in order to make
 * the next State transition.
 * <p>
 * The Context drives the State changes (transitions) and invokes the StateImpls.  It always holds a reference
 * to the current StateImpl.  The Context exposes the business methods.
 * <p>
 * The consumer of the State pattern uses the Context directly.
 * <p>
 * Very similar to the Strategy pattern: the main difference is the State pattern changes its behaviour based on
 * its state, whereas the Strategy pattern changes it behaviour using a different algorithm.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>State interface - defines the operation for all Concrete State implementations to provide impl for its current
 *                       state</li>
 * <li>Concrete State - provides the implementation for its state (getCost)</li>
 * <li>Context - Creates all the Concrete States. Always holds a reference to the current State.
 *               Provides the business methods.</li>
 * <li>Client - Uses the Context to call the business methods. This is the test class. </li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * 
 * Workflow mostly, e.g. a trading system, bug tracker, ...
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.behavioural.state;