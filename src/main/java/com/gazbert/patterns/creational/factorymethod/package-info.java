/**
 * <h2>Factory Method</h2>
 * The Factory Method provides an interface for creating an object (Product), but it relies on the Concrete Factory 
 * implementation class to create (instantiate) the actual Product.
 * <p>
 * The abstract factory does this by providing a protected createXXX method and which is only visible to the Concrete
 * Factory subclasses; this is the 'Factory Method'.
 * <p>
 * The pattern encapsulates object creation and keeps it one place. If the way the object is created needs to be 
 * changed in the future, the Client is protected from this by the Concrete Factory interface.
 * <p>
 * Be careful not to confuse the Abstract Factory <em>actor</em> in this pattern with the <em>name</em> of the
 * Abstract Factory pattern.
 * <p>
 * The difference between this pattern and the Abstract Factory pattern is that Abstract Factory pattern requires
 * you to know in advance exactly which Product you want to build. The Abstract Factory pattern is also used for 
 * creating 'families' of related/dependent Product; the Factory Method typically only creates one Product per factory.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Abstract Factory - an abstract class for defining the types of Product to built, and provides the Client facing
 *                        business method for building Products.</li>
 * <li>Concrete Factory - provides an implementation of the Abstract Factory's 'Factory Method' for creating 
 *                        Concrete Products </li>
 * <li>Product - the interface of the object we are creating/instantiating</li>
 * <li>Concrete Product - the actual object we create/instantiate</li>
 * <li>Client - the code that uses the pattern to build Products.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * When you cannot know in advance the type of object (Product) to create - you let the concrete factory decide for you
 * based on some information you pass it. Also stops client code from using 'new' all over the place by encapsulating 
 * the point of object creation; it keeps knowledge of how to create an object localised.
 *  
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.creational.factorymethod;