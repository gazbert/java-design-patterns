/**
 * <h2>Strategy</h2>
 *
 * Probably the most common behavioural pattern out there.
 * <p>
 * The Strategy pattern creates a family of algorithms (strategies) that a Client can swap in and out at runtime
 * depending on the 'rules of engagement' ;-)
 * <p>
 * The pattern consists of a Strategy interface; all Concrete Strategies implement this. The Strategy provides the
 * strategic operation that all Concrete Strategies must implement; this is their Strategy for <em>doing</em> something.
 * <p>
 * The Context defines the business methods. The Client interacts with the Strategy pattern through the Context.
 * <p>
 * It differs from the State pattern in that it is the Client that decides when to swap in another Strategy instead of
 * the Concrete Strategies themselves; remember, in the State pattern, the Concrete States hold a reference to the
 * Context and <em>tell it</em> to change State. The Concrete Strategies typically do not hold a reference to the
 * Context. 
 * <p>
 * One of the benefits of the Strategy pattern is that when a new strategy is needed, it can easily be slotted in and
 * called by the Client.
 * <p>
 * Very similar to the State pattern: the main difference is the State pattern changes its behaviour based on
 * its current state, whereas the Strategy pattern changes it behaviour using different algorithms independent of state.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Strategy - the interface that defines the <em>strategic</em> method which all Concrete Strategies must provide
 *                an algorithm implementation for.</li>
 * <li>Concrete Strategy - implements the Strategy interface and provides its own algorithm for doing something</li>
 * <li>Context - Contains the business methods. Holds a reference to the current Strategy that is being used to realise
 *               the business method.</li>
 * <li>Client - sets the Strategy to be used on the Context and calls a Context business method to do something.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Use whenever you need different algorithms for processing the same 'thing', where you cannot know until runtime 
 * which algorithm to use. 
 * <br>
 * Very popular in MVC frameworks like Struts/JSF: the controller acts as the Context and delegates to actions 
 * (Strategies) to process web requests.
 * <br>
 * Another example is a trading bot using different algos to send new trade orders.
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.behavioural.strategy;