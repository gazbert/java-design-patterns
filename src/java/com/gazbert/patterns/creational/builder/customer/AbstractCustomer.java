package com.gazbert.patterns.creational.builder.customer;

import com.gazbert.patterns.creational.builder.Address;
import com.gazbert.patterns.creational.builder.account.Account;

/**
 * Abstract Customer holds all the bits n pieces common to all Customer types.
 * 
 * @author gazbert
 *
 */
public abstract class AbstractCustomer implements Customer {
        
    /** Reference to the Account we have built for this Customer */
    private Account account;
    
    /** Contact details for Customer */
    private Address address;
    
    
    public AbstractCustomer(final Account account)
    {
	this.account = account;
    }
    
    public Account getAccount()
    {
	return account;
    }
    
    public String toString()
    {
	return getClass().getSimpleName() + " Account:" + account;
    }           
    
    public void setAddress(final Address address)
    {
	this.address = address;
    }
}
