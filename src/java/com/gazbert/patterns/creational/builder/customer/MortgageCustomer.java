package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * A Mortgage Customer.
 * 
 * @author gazbert
 *
 */
public class MortgageCustomer extends BorrowingCustomer {

    public MortgageCustomer(final Account account) {
	
	super(account);	
    }
}
