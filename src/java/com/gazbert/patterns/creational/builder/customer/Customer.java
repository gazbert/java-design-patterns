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
 * We's also use an Abstract Factory pattern for building the objects in conjunction with this Builder pattern - I'm 
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
    public Account getAccount();    
    
    // In reality, there would be a lot more pieces to add here, 
    // e.g. Address, CreditHistory, Employer, LoyaltyScheme, MarketingPreferences, SalesOpportunites, etc...
}
