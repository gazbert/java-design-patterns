package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for a Standard account.
 * <p>
 * Standard accounts are domicile and not within an ISA; they carry the 'standard' broker fees.
 * 
 * @author gazbert
 *
 */
public class StandardAccount extends AccountDecorator {

    private static BigDecimal BROKER_FEE = new BigDecimal(0.3);
    
    
    /**
     * Constructor creates this Concrete Decorator.
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public StandardAccount(final Account wrappedComponent) {
	super(wrappedComponent);	
    }
    
    @Override
    protected BigDecimal getBrokerFee() {
	return BROKER_FEE;
    }
}
 