package com.gazbert.patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * An Account.
 * <p>
 * There would be loads more stuff in here in the real world...
 * 
 * @author gazbert
 *
 */
public interface Account {

    public BigDecimal getBalance();
    
    public boolean isOverdraftAvailable();
    
    public void creditAccount(final BigDecimal credit);
}