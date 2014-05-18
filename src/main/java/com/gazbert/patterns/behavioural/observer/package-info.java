/**
 * <h2>Observer</h2>
 * 
 * The Observer pattern defines a one-to-many dependency between objects so that when the 'one' object changes, it 
 * notifies/broadcasts the change to the 'many'.
 * <p>
 * It enables a loose coupling between a Subject/Observable (the 'one' or the thing that is of interest) and the 
 * Observers (the 'many' or the things that are interested in something about the 'one'). The Subject and Observers are
 * decoupled through a common Observer interface.
 * <p>
 * The pattern uses a Publish/Subscribe (pub-pub) mechanism: the Observers register/subscribe their interest with the 
 * Subject, then when 'something' happens to change on the Subject, the Subject  notifies the registered Observers of
 * the change.
 * <p>
 * Register/Unregister and Subscribe/Unsubscribe are synonymous with the Observer pattern.
 * <p>
 * The main benefits of the pattern are:
 * <ul>
 * <li>You can add new Observers at any time.</li>
 * <li>You don't need to modify the Subject if we you new Observers.</li>
 * <li>It decouples Observers and the Subject.</li>
 * </ul>
 * 
 * There are 3 common ways of implementing the Observer pattern in Java:
 * <ol>
 * <li>JDK Observer - my preferred way to implement the pattern. <strong>But</strong>, you can only use 
 *                    <code>java.util.Observable</code> when your Observer does not extend any other class; 
 *                    Java uses single inheritance remember. The main benefit of this approach is that removes burden
 *                    for developer to write boiler-plate code (and bugs!) to register/unregister Observers and send 
 *                    notifications to Observers.</li>
 * <li>JDK Eventing - neat way using <code>java.util.EventObject</code> if your Observable/Subject already extends an
 *                    existing class.</li>
 * <li>'Code your Own' - use where your Observable/Subject already extends an existing class and you need more
 *                       control than the Eventing model.</li>
 * </ol>
 * 
 * I've split the 3 approaches into separate packages to make it easy to distinguish between them; see the code and 
 * javadoc for full details of each approach.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Observable - provides methods to register/unregister Observers, and notifies Observers when something 
 *                  changes. Subjects (Concrete Observables) are different implementations of the Observable.</li>
 * <li>Concrete Observable/Subject - extends Observable. Provides the impl for the Observable. Also called the Subject.
 * </li>
 * <li>Observer - all clients implement this so they can be notified by the Subject.</li>
 * <li>Concrete Observer - the implementation for an Observer. A Concrete Observer registers/unregisters with an
 *                         Observable. These are the trading bots in the sample code.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Lots in the OO world! GUI events/listeners, JMS, JavaBeans events/listeners... In our example, we use the Observer
 * pattern to send market price updates (Subject) to some trading bots (Observers).  
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.behavioural.observer;