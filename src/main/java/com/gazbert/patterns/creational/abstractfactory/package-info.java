/**
 * <h2>Abstract Factory</h2>
 * 
 * Provides an interface for Clients to create 'families' of related or dependent objects without specifying their 
 * concrete impl classes.
 * <p>
 * The Abstract Factory pattern provides the operations for building the family of parts that make up a 'thing'. It 
 * allows for easy exchange of different Product families when building new 'things' given that the factories use
 * the same buildXXX interface methods for creating new Product impls through the same Product interface.
 * <p>
 * The pattern stops the 'new' word cropping up all over the place and encapsulates the creation of objects in one 
 * place.
 * <p>
 * One thing to note, the Abstract Factory pattern does <em>not</em> create an actual 'thing'; 
 * it only creates the (family of) parts that make it up.
 * <p>
 * The Client needs to know in advance what type of Product it is making in order to use the right
 * Concrete Factory. However, once they have done this, they always use the same interface (the Abstract Factory) for
 * creating the parts of the Product.
 * <p>
 * Main drawback of pattern is that if we need additional Products, we need to hack the Abstract Factory to add the new
 * createXXX operation - all the concrete subclass factories would need to provide an impl (even if they do nothing)
 * too.
 * <p>
 * Often combined with the Builder pattern for creating complex objects, e.g. Customer.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Abstract Factory - defines the Products we can create. Client calls the createXXX ops on this which invoke the
 *                        actual Concrete Factory createXXX methods. The ops provide a consistent build approach.</li>
 * <li>Concrete Factory - a concrete implementation of the Abstract Factory for creating Products. These factories
 *                        do the actual instantiation of the Product families.</li>                        
 * <li>Product - one of the family (related) parts that the factories build. Each Product type has the same interface,
 *               but each Product can obviously have multiple different impls.</li>
 * <li>Client - the code that uses the Abstract Factory and Concrete Factories for building Product(s). </li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * For building related parts of a 'thing' using the same consistent creation interface/methods. E.g. the parts that
 * make up a Customer: address, account, financial product. Often combined with the Builder pattern for creating
 * complex objects.
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.creational.abstractfactory;