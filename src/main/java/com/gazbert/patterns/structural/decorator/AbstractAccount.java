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
     * @param credit the credit amount.
     */
    @Override
    public synchronized void credit(final BigDecimal credit) {

        // remember, BDs are immutable	
        balance = balance.add(credit);        
    }

    /**
     * Debits the account.
     * @param debit the debit amount.
     */
    @Override
    public synchronized void debit(final BigDecimal debit) {

        // remember, BDs are immutable
        balance = balance.subtract(debit);
    }
}
