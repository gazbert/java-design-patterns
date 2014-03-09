package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * A Savings Customer.
 * 
 * @author gazbert
 *
 */
public class SavingsCustomer extends InvestingCustomer {

    public SavingsCustomer(final Account account) {
	
	super(account);	
    }
}
