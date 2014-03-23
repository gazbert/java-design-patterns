package com.gazbert.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * This is our Decorator base class.
 * <p>
 * The default behaviour for the Decorator is to always call through to the wrapper Component
 * unless a Concrete Decorator subclass overrides...
 * 
 * @author gazbert
 *
 */
abstract class AccountDecorator extends AbstractAccount {
     
    /**
     * This the Component we are decorating.
     */
    private Account wrappedComponent;   

    /**
     * Constructor takes the object we are decorating as an arg.
     * @param wrappedComponent
     */
    AccountDecorator(final Account wrappedComponent)
    {
	this.wrappedComponent = wrappedComponent;
    }   
          
    /**
     * Gives access to the wrapped Component to our Concrete Decorator subclasses.
     * @return the wrapped component.
     */
    public Account getWrappedComponent() {
        return wrappedComponent;
    }   

    /**
     * Returns the type of Account.
     */
    @Override
    public String getType() {
	
	return this.getClass().getSimpleName();
    }
    
    /**
     * Credits the account after applying the broker fee.
     * @param credit
     */
    @Override
    public synchronized void credit(final BigDecimal credit) {
	
	// dirty instanceof, but this is just a demo ;-)
	if (getWrappedComponent() instanceof StockbrokingAccount)
	{
	    final BigDecimal fee = credit.multiply(getBrokerFee());
    	    final BigDecimal creditAfterFee = credit.subtract(fee);
    
            //now delegate to the wrapped Component
            getWrappedComponent().credit(creditAfterFee);
	}
    }
    
    ////////// default behaviour is to always call through unless overidden //////////
         
    /**
     * Returns the current balance.
     */
    @Override
    public synchronized BigDecimal getBalance() {
        return wrappedComponent.getBalance();
    }

    /**
     * Debits the account.
     * @param debit
     */
    @Override
    public synchronized void debit(final BigDecimal debit) {

	wrappedComponent.debit(debit);
    }
    
    ////////// for accessing the additional state the Decorator provides //////////
    
    /**
     * Gets the broker fee from the sublcass.
     * @return
     */
    protected abstract BigDecimal getBrokerFee();        
}
