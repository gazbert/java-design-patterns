package com.gazbert.patterns.structural.adapter;

import java.math.BigDecimal;
import java.math.MathContext;

import com.gazbert.patterns.structural.adapter.thirdparty.OffshoreAccount;

/**
 * Our adapter class.
 * <p>
 * AbstractAccount is the class we are adapting to - we extend from this class.
 * <p>
 * OffshoreAccount is the class we are adapting from - we wrap this class.
 * <p>
 * 
 * @author gazbert
 *
 */
public class AccountAdapter extends AbstractAccount {

    /** The class we are adapting from */
    private OffshoreAccount classBeingAdapted;
    
    /**
     * Constructor takes the class we are going to adapt as an argument.
     * 
     * @param offShoreAccount the 3rd party API class we are going to adapt from.
     */
    public AccountAdapter(final OffshoreAccount offShoreAccount)
    {
	// pull the class into out hierarchy by adapting the diff methods names
	super(offShoreAccount.getGrossBalance(), offShoreAccount.canHaveNegativeBalance());
	
	// keep a reference to it for later
	this.classBeingAdapted = offShoreAccount;
    }                
    
    /**
     * For the offshore account, we have to deduct the tax owed for that country when 
     * making the balance calculation.
     */
    @Override
    public BigDecimal getBalance() {
	
	// get the tax hit from our adapted class
	final BigDecimal taxRate  = classBeingAdapted.getOffshoreTaxRate();	
	final BigDecimal grossBalance = super.getBalance();
	
	final BigDecimal taxableBalance = grossBalance.multiply(taxRate);
	final BigDecimal balanceAfterTax = grossBalance.subtract(taxableBalance, MathContext.DECIMAL32);
	
	return balanceAfterTax;
    }
}
