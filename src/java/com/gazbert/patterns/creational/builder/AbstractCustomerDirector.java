package com.gazbert.patterns.creational.builder;

import com.gazbert.patterns.creational.builder.customer.Customer;

/**
 * Abstract Director for all Concrete Directors to extend from.
 * 
 * @author gazbert
 *
 */
public abstract class AbstractCustomerDirector {
    
    public abstract Customer build(final AbstractCustomerBuilder builder);
}
