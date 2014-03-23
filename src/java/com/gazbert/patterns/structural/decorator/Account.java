package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * This is the Component.
 * 
 * @author gazbert
 *
 */
public interface Account {

    public String getType();
    
    public BigDecimal getBalance();        
    
    public void credit(BigDecimal credit);
    
    public void debit(BigDecimal debit);    
}
