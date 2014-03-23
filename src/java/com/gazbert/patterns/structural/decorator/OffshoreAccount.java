package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for an Offshore account.
 * <p>
 * Offshore investments carry the highest broker fees.
 * 
 * @author gazbert
 *
 */
public class OffshoreAccount extends AccountDecorator {

    private static BigDecimal BROKER_FEE = new BigDecimal(0.5);
    
    
    /**
     * Constructor creates this Concrete Decorator.
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public OffshoreAccount(final Account wrappedComponent) {
	super(wrappedComponent);	
    }
    
    @Override
    protected BigDecimal getBrokerFee() {
	return BROKER_FEE;
    }
}
 