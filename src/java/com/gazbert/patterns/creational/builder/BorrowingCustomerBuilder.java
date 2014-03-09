package com.gazbert.patterns.creational.builder;

import com.gazbert.patterns.creational.builder.customer.BorrowingCustomer;
import com.gazbert.patterns.creational.builder.customer.Customer;

/**
 * 
 * Concrete Builder for building a Borrowing Customer.
 * <p>
 * TODO - The common buildXXX methods could be pushed up into the AbstractCustomerBuilder...
 * 
 * @author gazbert
 *
 */
public class BorrowingCustomerBuilder extends AbstractCustomerBuilder {

    /** The Product we are going to build */
    private BorrowingCustomer borrowingCustomerToBuild;
    
    public BorrowingCustomerBuilder(final BorrowingCustomer customer)
    {
	borrowingCustomerToBuild = customer;
    }
    
    @Override
    public Customer getCustomer() {
	
	return borrowingCustomerToBuild;
    }
    
    public void buildContactDetails()
    {
	System.out.println("Building contact details - performing database lookup...");
	// E.g. database lookup SELECT * FROM Address WHERE CustomerID = 'blabla';
	// Only stubbing the Address, the other buildXXX methods would so something similar...
	borrowingCustomerToBuild.setAddress(new Address());	
    }   
    
    public void buildMarketingPreferences()
    {
	System.out.println("Building Mareting Preferences...");
    }
    
    public void buildSalesOpportunities()
    {
	System.out.println("Building future sales leads...");
    }   
    
    public void buildEmployerDetails()
    {
	System.out.println("Building Employer details...");
    }
    
    public void buildCreditRatingReport()
    {
	System.out.println("Building Credit Report - making REST service call to Equifax...");
    }    
    
    /* We don't bother building this - no rewards scheme for borrowers :-( */
//  public void buildRewardsScheme()
//  {
//	System.out.println("Building Rewards scheme details...");
//  }
    
    /* We don't bother building this - no taxing for borrowers :-) */
//  public void buildTaxationDetails()
//  {
//	System.out.println("Building Taxation details...");
//  }
    
}