/**
 * <h2>Visitor</h2>
 *
 * Lets you add new behaviour to all objects in a class structure/object graph without changing the
 * existing classes on which the method needs to operate. Huh? It's a bit tricky to get your head
 * around at first, but stick with it...
 * <p>
 * You can never know all the requirements up-front; you might even *know* that you are going to get
 * trickle-fed stuff. Conventional wisdom would be to keep adding new methods to an existing object
 * graph as and when the requirements become available. The drawback with this is constant
 * disruption to the code.
 * <p>
 * A better approach is the Visitor pattern. The pattern adds a new method to be performed on the
 * Elements of an existing object graph. This new method can be defined without changing the classes
 * of the Elements on which it operates.
 * <p>
 * The Visitor pattern allows us to add one new method that can be invoked with new functionality;
 * the new behaviour is encapsulated in the Visiting object, not in the existing (visited) Element.
 * <p>
 * This achieved using 'Double Dispatch' technique (a callback to the invoking object) - it's used
 * plenty in the JavaScript world!
 *
 * <h2>Actors</h2>
 * <ul>
 * <li>Visitor - defines the interface that declares all of the methods for validating each
 * Visitable Element.</li>
 * <li>Concrete Visitor A, B - implements the Visitor interface for each element that could be
 * visited.</li>
 * <li>Element (Visitable) - defines the interface for all classes that could be visited, typically
 * called the accept() method.</li>
 * <li>Concrete Element A, B - implements Element interface for each class that could be
 * visited.</li>
 * <li>Object Structure - contains references to all objects that could be visited, enabling us to
 * iterate through them all. This is typically the outer/wrapper/highest level domain object.</li>
 * </ul>
 *
 * <h2>Usages</h2>
 * Used to perform a similar operation on an object graph/class hierarchy, e.g validation of data,
 * setting default values.
 * <p>
 * The benefit is that it does not require extensive modification of existing code - all the new
 * logic is inside the Visitor.
 * <p>
 * The drawback is that adding new Visitable objects, means updating the existing Object Structure.
 * <p>
 * A handy pattern to change behaviour of something in the future when you don't have enough
 * requirements up-front.
 * <p>
 *
 * @author gazbert
 * @since 2016/02/27
 */
package com.gazbert.patterns.behavioural.visitor;