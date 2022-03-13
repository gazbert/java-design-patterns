package com.gazbert.patterns.structural.decorator;

/*The MIT License (MIT)

Copyright (c) 2014 Gazbert

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

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
     * @param credit the credit amount.
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
     * @param debit the debit amount.
     */
    @Override
    public synchronized void debit(final BigDecimal debit) {

        wrappedComponent.debit(debit);
    }

    ////////// for accessing the additional state the Decorator provides //////////

    /**
     * Gets the broker fee from the sublcass.
     * @return the broker fee.
     */
    protected abstract BigDecimal getBrokerFee();        
}
