/**
 * <h2>Command</h2>
 * 
 * The Command pattern encapsulates a request to do something as an object.
 * <p>
 * The pattern does a great job of decoupling the object that is making the request (Command Invoker) from the object 
 * that receives the request (Receiver) and performs the action; it does this by using a middleman: the Command object.
 * <p>
 * The Command interface does the decoupling. The Command Invoker knows nothing about the Receivers; it just calls 
 * the execute() method on the Command. The Client decides which Receiver the Command performs operations on when it 
 * builds the Command object. This Command object is then set on the Command Invoker - the Client
 * <em>parameterises</em> it.
 * <p>
 * The main benefit of the pattern is that new Commands and Receivers can be slotted in without changing the
 * Command Invoker and existing Command/Receivers already setup; you just create new Command objects and set them 
 * on the Command Invoker.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Command interface - all Concrete Commands must implement this; this is the interface for executing an operation.</li>
 * <li>Concrete Command - the Command implementation. Performs the operation on a Receiver.</li>
 * <li>Receiver - the target for the Command. It knows how to make things happen/perform the operations. 
 *                Command objects wrap a Receiver and invoke actions on it. </li>
 * <li>Command Invoker - Clients use this to invoke Commands and make them happen. Clients parameterise the invoker,
 *                       i.e. set the Commands they want to invoke on the Invoker.</li>
 * <li>Client - Creates the Receivers, Commands, parameterises the Command Invoker, and then uses the Command Invoker
 *              to select and execute Commands.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Very common in UI toolkits, e.g. when a button is clicked an actionPerformed() method is often called. Also used
 * in server-side frameworks for processing messages/commands from queues; example code picks orders off an exchange
 * queue.
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.behavioural.command;