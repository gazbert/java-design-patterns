/**
 * <h2>Decorator</h2>
 * Used to add extra responsibility/functionality to an existing object dynamically and without changing the existing
 * inheritance hierarchy; the additional functionality is added using composition at runtime rather than through class
 * extension at compile time.
 * <p>
 * The Decorator can add additional state or behaviour to an existing inheritance hierarchy.
 * <p>
 * This extra functionality is achieved by <em>decorating</em> the class (Component) you wish to add extra 
 * functionality to; this is also more commonly known as <em>wrapping</em> the object. 
 * <p>
 * Typically, you create a new class hierarchy with the root of it (Decorator) implementing the same interface/extending 
 * the Component. You then create Concrete Decorator classes that extend/implement from your Decorator. These Concrete
 * Decorators take the Component you want to 'enhance' as an arg in their constructors - they decorate/wrap them.
 * <p>
 * In the Concrete Decorator, when the Client calls the business method (defined in Component) is called, you do the
 * extra stuff, before delegating the call to the wrapped Component. 
 * <p>
 * One of the benefits of the pattern is that it can reduce the number of classes required to add new functionality
 * to an existing inheritance hierarchy; instead of creating <em>lots</em> of combinations of new subclasses, you just
 * create a decorator and re-use the existing classes using composition.
 * <p>
 * The other benefits is that you don;t have to keep messing with the existing (production stable) class hierarchy when
 * adding new functionality.
 * 
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Component - the interface/abstract class that defines the business methods that a Concrete Component must
 *                 provide.</li>
 * <li>Concrete Component - this the class we are going to wrap.</li>
 * <li>Decorator - the class that wraps the Concrete Component; it keeps a reference to the Concrete Component and
 *                 it extends/implements the Component.</li>
 * <li>Concrete Decorator - implements/extends the Decorator. This provides the additional functionality
 *                          implementation for decorating the Component.</li>
 * <li>Client - uses the Decorator.</li> 
 * </ul>
 * 
 * <h2>Usages</h2>
 * One simple use of a decorator is to check pre-contract conditions (e.g. NullPointer arg checks) and then delegate 
 * to the actual business class. 
 * <p>
 * Decorators can be used to add functionality to an existing class hierarchy that is stable and running in 
 * production. Clients of existing APIs are not keen on changes; the Decorator would not break their existing code.
 * <p>
 * The JDK IO classes make extensive use of decorators for wrapping the various IO stream classes. 
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.structural.decorator;