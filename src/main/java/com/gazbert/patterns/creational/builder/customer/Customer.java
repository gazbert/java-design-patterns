/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * This is the complex 'Product' we are going to build.
 * <p>
 * A Customer class hierarchy is:
 * 
 * <pre>
 * Customer
 *           AbstractCustomer
 *                             InvestingCustomer
 *                                                SavingsCustomer, StockbrokingCustomer
 *                             BorrowingCustomer
 *                                                LoanCustomer, MortgageCustomer
 * </pre>
 * 
 * In reality it would be a lot more complex than this, but this will be enough for the demo!
 * <p>
 * A Customer will have a different Account depending on what type of Customer they are.
 * <p>
 * We also use an Abstract Factory pattern for building the objects in conjunction with this Builder pattern - I'm
 * leaving this out to keep things simple (?!) for now.
 * 
 * @author gazbert
 *
 */
public interface Customer {
    
    /**
     * Each Customer will have an Account. The way the Account is built depends on the type of Customer we have.
     * 
     * @return the Customer's account.
     */
    Account getAccount();
    
    // In reality, there would be a lot more pieces to add here, 
    // e.g. Address, CreditHistory, Employer, LoyaltyScheme, MarketingPreferences, SalesOpportunites, etc...
}
