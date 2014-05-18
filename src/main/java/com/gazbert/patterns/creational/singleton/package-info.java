/**
 * <h2>Singleton</h2>
 * 
 * Ensures that only 1 instance of a class can be in existence and provides 1 method to access it.
 * <p>
 * My preferred method for implementing a Singleton in Java (post Java 5) is using an enum.
 * <p>
 * You can also use a class with a private constructor and a synchronised accessor method that creates
 * (only once) an instance of the object and returns it to the Client; this is the classic way of using
 * Singletons. The classic way can create Singletons <em>eagerly</em> or <em>lazily</em> - see the class
 * JavaDoc for the differences.
 * <p>
 * Perhaps the most familiar and most used (abused) of all design patterns!
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Singleton - the single instance of a class</li>
 * <li>Client - the client code that uses the Singleton<li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * When you only want 1 instance of a class at runtime. Typically used to wrap and control access to configuration,
 * log files, registry/database/catalogue/dictionary implementations where atomicity is crucial.
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.creational.singleton;