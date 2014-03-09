package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * A Stocks n Shares trading Customer.
 * 
 * @author gazbert
 *
 */
public class StockbrokingCustomer extends InvestingCustomer {

    public StockbrokingCustomer(final Account account) {
	
	super(account);	
    }
}
