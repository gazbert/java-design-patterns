package com.gazbert.patterns.creational.builder.account;

import java.math.BigDecimal;


/**
 * Abstract Account holds all the bits n pieces common to all Account types.
 * 
 * @author gazbert
 *
 */
public class AbstractAccount implements Account {

    private BigDecimal balance;
    private boolean isOverdraftAvailable;
    
    public AbstractAccount(final BigDecimal size, boolean isOverdraftAvailable)
    {
	this.balance = size;
	this.isOverdraftAvailable = isOverdraftAvailable;	
    }
    
    @Override
    public BigDecimal getBalance() {
	
	return balance;
    }

    @Override
    public boolean isOverdraftAvailable() {

	return isOverdraftAvailable;
    }

    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " Balance=" + balance + " Overdraft:" + isOverdraftAvailable;
    }
}
