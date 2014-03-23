package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Base class for all Accounts.
 * @author gazbert
 *
 */
abstract class AbstractAccount implements Account {
    
    private BigDecimal balance;


    public AbstractAccount()
    {
	balance = new BigDecimal(0);
    }
    
    /**
     * Returns the type of Account.
     */
    @Override
    public String getType() {
	
	return this.getClass().getSimpleName();	
    }
     
    /**
     * Returns the current balance.
     */
    @Override
    public synchronized BigDecimal getBalance() {
        return balance;
    }
    
    /**
     * Credits the account.
     * @param credit
     */
    @Override
    public synchronized void credit(final BigDecimal credit) {

	// remember, BDs are immutable	
	balance = balance.add(credit);        
    }

    /**
     * Debits the account.
     * @param debit
     */
    @Override
    public synchronized void debit(final BigDecimal debit) {

	// remember, BDs are immutable
	balance = balance.subtract(debit);
    }
}
