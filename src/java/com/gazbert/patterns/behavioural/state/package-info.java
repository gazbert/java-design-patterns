/**
 * <h2>State Pattern</h2>
 * 
 * Allows a business interface to alter its behaviour when its internal state (concrete impl) changes.
 * <p>
 * A State interface/abstract class defines the operations that each concrete state implementation class must do.
 * The  behaviour of these operations varies depending on what State is being executed.
 * <p>
 * A StateImpl does the business logic. It is built by the Context and has a reference to it in order to request
 * the next State transition.
 * <p>
 * The Context drives the State changes (transitions) and invokes the StateImpls.  It always holds a reference
 * to the current StateImpl.
 * <p>
 * A user uses the StateMachine to do stuff.
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