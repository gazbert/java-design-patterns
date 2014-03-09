package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.account.Account;

/**
 * The root of the Investing Customer hierarchy.
 * 
 * @author gazbert
 *
 */
public abstract class InvestingCustomer extends AbstractCustomer {

    public InvestingCustomer(final Account account) {
     
	 super(account); 
    }
}
