/**
 * <h2>Static Factory Method / Simple Factory</h2>
 * 
 * The <em>Static</em> Factory Method is essentially the Factory Method pattern where the 'factory method' is
 * declared as being static. Clients call this static method to get the Product created.
 * <p>
 * This pattern is often called a Simple Factory.
 * <p>
 * The advantage of this is that he Client only needs to know about and use 1 factory class to build the Product; it
 * combines the work of the Concrete Factories and the Abstract Factory as seen in the traditional Factory Method.  The
 * 'factory method' is not abstract this time - it does the actual Product building.
 * <p>
 * Handy for simpler factory requirements for building Products, e.g. you have say 3 or 4 product types.
 * <p>
 * I use this in preference to the traditional Factory Method most of the time.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Static Factory / Simple Factory - an abstract class for defining the types of Product to built, and provides 
 *                                       the Client facing business method for building Products which doubles up as 
 *                                       the 'factory method'.</li>
 * <li>Product - the interface of the object we are creating/instantiating</li>
 * <li>Concrete Product - the actual object we create/instantiate</li>
 * <li>Client - the code that uses the pattern to build Products.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Same usages as the traditional Factory Method. Involves writing fewer classes to build the factory, and the Client
 * has less to do to get something built - always a good thing.
 *  
 * <p>  
 * @author gazbert
 *
 */
package com.gazbert.patterns.creational.staticfactorymethod;