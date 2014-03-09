package com.gazbert.patterns.creational.builder;

import com.gazbert.patterns.creational.builder.customer.Customer;
import com.gazbert.patterns.creational.builder.customer.InvestingCustomer;

/**
 * Concrete Builder for building an Investing Customer.
 * <p>
 * TODO - The common buildXXX methods could be pushed up into the AbstractCustomerBuilder...
 * 
 * @author gazbert
 *
 */
public class InvestingCustomerBuilder extends AbstractCustomerBuilder {

    /** The Product we are going to build */
    private InvestingCustomer investingCustomerToBuild;
    
    public InvestingCustomerBuilder(final InvestingCustomer customer)
    {
	investingCustomerToBuild = customer;
    }

    @Override
    public Customer getCustomer() {
	
	return investingCustomerToBuild;
    }
    
    public void buildContactDetails()
    {
	System.out.println("Building contact details - performing database lookup...");
	// E.g. database lookup SELECT * FROM Address WHERE CustomerID = 'blabla';
	// Only stubbing the Address, the other buildXXX methods would so something similar...
	investingCustomerToBuild.setAddress(new Address());	
    }
    
    public void buildMarketingPreferences()
    {
	System.out.println("Building Market preferences...");
    }
    
    public void buildSalesOpportunities()
    {
	System.out.println("Building future Sales leads...");
    }
    
    public void buildRewardsScheme()
    {
	System.out.println("Building Customer rewards scheme - making REST service call to Loyalty Scheme...");
    }
    
    public void buildEmployerDetails()
    {
	System.out.println("Building Employer details...");
    }
        
    public void buildTaxationDetails()
    {
	System.out.println("Building Taxation details - making IRS REST service call...");
    }

    /* We don't bother building this - no need for credit report for investors */
//    public void buildCreditRatingReport()
//    {
//	System.out.println("Building Credit rating report");
//    }
    
}
