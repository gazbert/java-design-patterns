/**
 * <h2>Chain of Responsibility</h2>
 *
 * Decouples the Sender of a message from the Receiver(s).  Allows more than one Receiver chance to
 * do something with the message. Allows for easy scaling if a new Receiver is required.
 * <p>
 * Receiver is often called a Handler.
 * <p>
 * The Handlers are chained together, so they call get a look at the message from the Sender. Each
 * Receiver decides to do something or not based on some condition. When it's done, it blindly
 * passes the message on to the next Receiver. The 'blindly' passing on is key here - each Receiver
 * has no knowledge of any other Receivers; this is what makes it easy to scale and drop new
 * Receivers in to the solution.
 *
 * <h2>Actors</h2>
 * <ul>
 * <li>Handler interface - defines the operations that all Concrete Handlers must implement. This
 * is the processHandler() and setNextHandler().</li>
 * <li>Abstract Handler - defines the business method (reviewDocumentRequest) the client calls:
 * this creates and calls the Concrete Handlers. </li>
 * <li>Concrete Handler - they decide if they want to process the Message (getSelectionCriteria)
 * and provide the impl in the handler method (reviewDocument).</li>
 * <li>Message - the message (Document to review in this case) to be sent to the Handlers.</li>
 * <li>Client - Uses the Abstract Handler and calls the business method on it with a Message.
 * </li>
 * </ul>
 *
 * <h2>Usages</h2>
 *
 * Where you have 1 or more interested handlers for a message. And when you want to easily add more
 * handlers in future.
 *
 * E.g. Document review system, Bank/Merchant email enquires, etc...
 * <p>
 *
 * @author gazbert
 */
package com.gazbert.patterns.behavioural.chainofresponsibility;