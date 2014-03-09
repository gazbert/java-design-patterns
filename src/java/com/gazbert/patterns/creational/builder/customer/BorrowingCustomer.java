package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * The root of the Borrowing Customer hierarchy.
 * 
 * @author gazbert
 *
 */
public abstract class BorrowingCustomer extends AbstractCustomer {

    public BorrowingCustomer(final Account account) {
     
	 super(account); 
    }
}
