package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * A Loan Customer.
 * 
 * @author gazbert
 *
 */
public class LoanCustomer extends BorrowingCustomer {

    public LoanCustomer(final Account account) {
	
	super(account);	
    }
}
