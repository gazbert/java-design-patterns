/**
 * <h2>Builder</h2>
 * 
 * Useful pattern for constructing complex objects/products using a consistent assembly approach.
 * <p>
 * Allows for the same construction process to create different representations of the underling 'things' being built,
 * i.e. we might build some things and not others (optional stuff).
 * <p>
 * Pattern enables variation of an object's representation - isolates/decouples construction and representation of
 * objects: it separates the building into separate methods of the builder hierarchy.
 * <p>
 * A Director class specifies the steps to do the building, i.e. it decides which build methods to call and in what 
 * order.
 * <p>
 * The Abstract Builder class requires each concrete builder to provide impl for the getCustomer() method.
 * <p>
 * The Director class is always abstract and provides an abstract build() method that all Concrete Directors impl must
 * implement. The argument to this build() method is the Builder. Director provides the step by step instructions
 * for building something. Each concrete Director simply calls the buildXXX methods on the Builder impl it gets passed.
 * <p>
 * Object creation would use an Abstract Factory in the real-world; skipping this for demo simplicity, but take a look
 * at the Abstract Factory pattern.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Product - the thing we are building</li>
 * <li>Builder interface - defines operations (buildXXX) methods for building the Product</li>
 * <li>Concrete Builder - provides an impl for the buildXXX() methods AND provides method to retrieve it after 
 *                        assembly.</li>
 * <li>Director - controls the assembly process e.g. what buildXXX() gets called and in what order/sequence.</li>
 * <li>Client - creates the (empty) domain object, creates the Builder, creates the Director and tells it to build!
 *              This is the test class.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * 
 * Used for complex objects where there are several steps (with optional bits) to building it. An example would
 * be building up a Customer used in a Financial System.  A Customer could be composed of or reference: Address,
 * Marketing Preferences, Account, Credit History, Employer Details, Loyalty Scheme, Taxation Rules, 
 * Future Sales Leads, etc... etc...
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.creational.builder;