package com.gazbert.patterns.structural.adapter.thirdparty;

import java.math.BigDecimal;


/**
 * The 3rd party API class - in real-life, we would not have access to the source, probably just the 
 * jar file and the Javadoc/user guides.
 * <p>
 * This is the class we are going to adapt.
 * 
 * @author gazbert
 *
 */
public class OffshoreAccount {

    private BigDecimal balance;
    private boolean canHaveNegativeBalance;
    
    /** The tax for the country where the account is */
    private static final BigDecimal TAX_RATE = new BigDecimal(0.03);
    
    public OffshoreAccount(final BigDecimal size, boolean canHaveNegativeBalance)
    {
	this.balance = size;
	this.canHaveNegativeBalance = canHaveNegativeBalance;	
    }
    
    public BigDecimal getGrossBalance() {
	
	return balance;
    }
    
    public BigDecimal getOffshoreTaxRate() {
	
	return TAX_RATE;
    }
   
    public boolean canHaveNegativeBalance() {

	return canHaveNegativeBalance;
    }

    public void creditTheAccount(final BigDecimal credit)
    {
	balance = balance.add(credit);
    }
    
    @Override
    public String toString()
    {
	return getClass().getSimpleName() + " Balance=" + getGrossBalance() + " -veBalanceAllowed:"
                + canHaveNegativeBalance();
    }
}
