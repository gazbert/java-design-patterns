package com.gazbert.patterns.creational.abstractfactory;

import com.gazbert.patterns.creational.abstractfactory.account.Account;
import com.gazbert.patterns.creational.abstractfactory.address.Address;
import com.gazbert.patterns.creational.abstractfactory.product.Product;

/**
 * This is the Abstract Factory class providing operations that all concrete factory classes must
 * override and implement to build stuff.
 * <p>
 * Yes, this could have been an interface, but the 'abstract class' bit clearly shows we're using the 
 * Abstract Factory pattern for the demo here.
 * <p>
 * The Abstract Factory provides the operations for building the family of parts that make up a Customer.
 * <p>
 * One thing to note, the Abstract Factory pattern does <em>not</em> create an actual Customer object; 
 * it only creates the (family of) parts that make it up.
 * 
 * @author gazbert
 *
 */
public abstract class AbstractCustomerFactory {

    /**
     * Creates an Address object.
     * @return
     */
    public abstract Address createAddress();
    
    /**
     * Creates an Account object.
     * @return
     */
    public abstract Account createAccount();
    
    /**
     * Creates a Product object. 
     * @return
     */
    public abstract Product createProduct();
    
    // etc etc etc.... more ops defined....    
}
