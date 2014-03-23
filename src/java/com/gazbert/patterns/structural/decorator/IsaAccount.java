package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Concrete Decorator implementation for adding extra state for a UK ISA (government backed tax-free savings) account.
 * <p>
 * The broker fee is less to encourage the public to invest more... 
 * 
 * @author gazbert
 *
 */
public class IsaAccount extends AccountDecorator {

    private static BigDecimal BROKER_FEE = new BigDecimal(0.1);
    
    /**
     * Constructor creates this Concrete Decorator.
     * @param wrappedComponent the Account Component we are wrapping/decorating.
     */
    public IsaAccount(final Account wrappedComponent) {
	super(wrappedComponent);
    }    

    @Override
    protected BigDecimal getBrokerFee() {
	return BROKER_FEE;
    }
}
