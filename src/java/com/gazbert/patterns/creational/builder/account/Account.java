package com.gazbert.patterns.creational.builder.account;

import java.math.BigDecimal;

/**
 * An Account. Here just to show that Customer <has a> Account, and that we can pass other 
 * (already built) domain objects into the Builder pattern.
 * <p>
 * There would be loads more stuff in here in the real world...
 * 
 * @author gazbert
 *
 */
public interface Account {

    public BigDecimal getBalance();
    
    public boolean isOverdraftAvailable();
}